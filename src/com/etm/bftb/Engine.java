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

    private void init() throws IOException {
        map = new Map();
        Prop prop = new Prop();
        players = new ArrayList<>();
        CompetitionLattice.setQaCards(prop.getQaCards());
        int maxPlayerCount = com.etm.bftb.constant.Prop.ENDANGERED_CARD_COUNT;
        System.out.println("Please input the number of players(2-" + maxPlayerCount + ")");
        Scanner sc1 = new Scanner(System.in);
        int playerCount = sc1.nextInt();
        if (2 <= playerCount && playerCount <= maxPlayerCount) {
            for (int i = 0; i < playerCount; i++) {
                System.out.println("Please input player name");
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
        while (players.size() > 1) {
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
                runOnce(player, iter);
                player.setCurrent(false);
            }
        }
        System.out.println("Congratulations, you are the winner, " + players.get(0).getName());
        System.out.println("Prestige at the time of victory: " + players.get(0).getPrestige());
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

    private void runOnce(Player player, Iterator<Player> iter) {
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
        } else if (runMoreTime) {
            runOnce(player, iter);
        }
    }

    private void out(Player player, Iterator<Player> iter) {
        List<OwnedLattice> ownedLattices = player.getLattices();
        for (OwnedLattice lattice : ownedLattices) {
            lattice.setOwner(null);
        }
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
