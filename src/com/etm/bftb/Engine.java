package com.etm.bftb;

import com.etm.bftb.constant.Game;
import com.etm.bftb.map.Map;
import com.etm.bftb.map.lattice.*;
import com.etm.bftb.map.prop.EndangeredAnimalCard;
import com.etm.bftb.map.prop.Prop;

import java.io.IOException;
import java.util.*;

public class Engine {

    /**
     * 地图
     */
    private static Map map;

    /**
     * 玩家
     */
    private static List<Player> players;


    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to " + Game.OWNER + "'s game " + Game.NAME);
        System.out.println("Game is loading!");
        Engine engine = new Engine();
        engine.init();
        System.out.println("Game loaded!");
        engine.run();
    }

    private void init() {
        Prop prop = Prop.getInstant();
        map = new Map();
        players = new ArrayList<>();
        CompetitionLattice.setQaCards(prop.getQaCards());
        int maxPlayerCount = prop.getAnimalCards().size();
        System.out.println("Please input the number of players(2-" + maxPlayerCount + ")");
        Scanner sc1 = new Scanner(System.in);
        int playerCount = sc1.nextInt();
        if (2 <= playerCount && playerCount <= maxPlayerCount) {
            for (int i = 0; i < playerCount; i++) {
                System.out.println("Player " + (i + 1) + ", please input player name");
                Scanner sc2 = new Scanner(System.in);
                String name = sc2.next();
                EndangeredAnimalCard card = prop.drawAnimalCards();
                Player player = new Player(name, Game.PRESTIGE, card);
                System.out.println(name + ", your endangered animal card is " + card.getTitle());
                players.add(player);
            }
        }
    }

    private void run() {
        int endCount = players.size();
        Player outPlayer = null;
        while (players.size() == endCount) {
            Iterator<Player> iter = players.listIterator();
            while (iter.hasNext()) {
                Player player = iter.next();
                player.setCurrent(true);
                if (player.isJailed()) {
                    if (player.isRelease()) {
                        player.setJailed(false);
                        player.setRelease(false);
                    } else {
                        System.out.println(player.getName() + " was suspended for one round because he/she was in prison");
                        player.setRelease(true);
                        continue;
                    }
                }
                // 运行一次
                outPlayer = runOnce(player, iter);
                if (!Objects.isNull(outPlayer)) {
                    break;
                }
                player.setCurrent(false);
            }
        }
        if (Objects.isNull(outPlayer)) {
            throw new RuntimeException("No player is out!");
        } else {
            System.out.println("Unfortunately, you lost, " + outPlayer.getName());
            System.out.println("Prestige at the time of lost: " + outPlayer.getPrestige() + ", make persistent efforts");
        }
    }

    private boolean runLattice(Lattice lattice, Player player) {
        if (lattice instanceof NormalLattice) {
            NormalLattice normalLattice = (NormalLattice) lattice;
            normalLattice.run(player);
        } else if (lattice instanceof SpecialLattice){
            SpecialLattice specialLattice = (SpecialLattice) lattice;
            specialLattice.run(players);
        } else {
            ReturnableLattice returnableLattice = (ReturnableLattice) lattice;
            RunResult runResult = returnableLattice.run(player);
            return handleRunResult(returnableLattice, runResult);
        }
        return false;
    }

    private boolean handleRunResult(ReturnableLattice returnableLattice, RunResult runResult) {
        if (returnableLattice instanceof CompetitionLattice) {
            return runResult.isBooleanValue();
        }
        return false;
    }

    private Player runOnce(Player player, Iterator<Player> iter) {
        System.out.println(player.getName() + ", it's your turn to throw the dice (enter)");
        // 等待确认
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        // 抛色子
        int point = player.throwingDice();
        // 移动棋子
        player.movePiece(point);
        // 移动到的格子
        Lattice lattice = map.getLattices().get(player.getStep());
        // 是否多运行依一次，根据当前所在的格子规则运行
        boolean runMoreTime = runLattice(lattice, player);
        // 检查状态
        boolean out = checkStatus(player);
        if (out) {
            out(player, iter);
            return player;
        } else if (runMoreTime) {
            return runOnce(player, iter);
        }
        return null;
    }

    private void out(Player player, Iterator<Player> iter) {
        List<OwnedLattice> ownedLattices = player.getLattices();
        for (OwnedLattice lattice : ownedLattices) {
            lattice.setOwner(null);
        }
        player.setRelease(false);
        iter.remove();
    }

    private boolean checkStatus(Player player) {
        if (player.getPrestige() <= 0) {
            player.setOut(true);
            return true;
        }
        return false;
    }

}
