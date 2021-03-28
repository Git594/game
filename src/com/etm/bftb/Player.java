package com.etm.bftb;

import com.etm.bftb.constant.Game;
import com.etm.bftb.constant.Lattices;
import com.etm.bftb.map.lattice.BlankLattice;
import com.etm.bftb.map.lattice.OwnedLattice;
import com.etm.bftb.map.lattice.ShelterLattice;
import com.etm.bftb.map.prop.Dice;
import com.etm.bftb.map.prop.EndangeredAnimalCard;
import com.etm.bftb.map.prop.QACard;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Player {

    /**
     * 名称
     */
    private final String name;

    /**
     * 输入
     */
    private String comments;

    /**
     * 声望
     */
    private int prestige;

    /**
     * 濒危动物卡
     */
    private EndangeredAnimalCard card;

    /**
     * 是否是当前玩家
     */
    private boolean current;

    /**
     * 是否出局
     */
    private boolean out;

    /**
     * 是否入狱
     */
    private boolean jailed;

    /**
     * 下一轮是否需要释放
     */
    private boolean release;

    /**
     * 所在的格子数
     */
    private int step;

    /**
     * 拥有的格子
     */
    private List<OwnedLattice> lattices;

    public Player(String name, int prestige, EndangeredAnimalCard card) {
        this.name = name;
        this.prestige = prestige;
        this.card = card;
        this.lattices = new LinkedList<>();
        this.step = 0;
        this.out = false;
        this.release = false;
    }

    /**
     * 减少声望
     * @param prestige 减少的声望
     */
    public void reducePrestige(int prestige) {
        System.out.println(this.getName() + ", you've reduced your prestige by " + prestige);
        this.prestige -= prestige;
        System.out.println(this.getName() + "'s current prestige: " + this.prestige);
    }

    /**
     * 增加声望
     * @param prestige 增加的声望
     */
    public void plusPrestige(int prestige) {
        System.out.println(this.getName() + ", you've plus your prestige by " + prestige);
        this.prestige += prestige;
        System.out.println(this.getName() + "'s current prestige: " + this.prestige);
    }

    /**
     * 投掷色子
     * @return 点数
     */
    public int throwingDice() {
        int result = Dice.getNum();
        System.out.println("The number of points " + this.getName() + " throw is: " + result);
        return result;
    }

    /**
     * 移动棋子
     * @param point 点数
     */
    public void movePiece(int point) {
        this.step += point;
        if (this.step >= Lattices.TOTAL_LATTICE) {
            this.step -= Lattices.TOTAL_LATTICE;
        }
        System.out.println("Current location: " + (this.step + 1));
    }

    /**
     * 是否同意
     * @return 是否同意
     */
    public boolean agreeOrNot() {
        System.out.println(this.name + ", do you agree(y/n)?");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if ("y".equals(str)) {
            return true;
        } else if ("n".equals(str)) {
            return false;
        } else {
            System.out.println("Illegal input!");
            return agreeOrNot();
        }
    }

    /**
     * 发表言论
     */
    public void makeAComments() {
        System.out.println(this.name + ", please make your comments. it's your show time!");
        Scanner sc = new Scanner(System.in);
        this.comments = sc.next();
    }

    /**
     * 建立栖息地
     * @param lattice 空白格子
     */
    public void establishHabitat(BlankLattice lattice) {
        if (this.getPrestige() >= Game.PRESTIGE_HABITAT_ESTABLISH) {
            lattice.setOwner(this);
            this.reducePrestige(Game.PRESTIGE_HABITAT_ESTABLISH);
            this.addLattice(lattice);
        } else {
            System.out.println("Sorry, you don't have enough prestige to build a habitat");
        }
    }

    /**
     * 答题
     * @param qaCard 答题卡实体类
     * @return 是否正确
     */
    public boolean answerQuestion(QACard qaCard) {
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        if (qaCard.checkAnswer(in)) {
            return true;
        } else {
            this.reducePrestige(Game.PRESTIGE_LOST_COMPETITION);
            return false;
        }
    }

    /**
     * 购买收容所
     * @param lattice 格子
     */
    public void buyShelter(ShelterLattice lattice) {
        if (this.getPrestige() >= Game.PRESTIGE_HABITAT_ESTABLISH) {
            this.reducePrestige(lattice.getPrestige());
            lattice.setOwner(this);
            this.addLattice(lattice);
        } else {
            System.out.println("Sorry, you don't have enough reputation to buy this shelter. Prestige needed : " + lattice.getPrestige());
        }
    }

    /**
     * 卖出收容所
     * @param lattice 收容所
     */
    public void sellShelter(ShelterLattice lattice) {
        this.plusPrestige(lattice.getPrestige());
        this.removeLattice(lattice);
    }

    public void addLattice(OwnedLattice lattice) {
        this.lattices.add(lattice);
    }

    public void removeLattice(ShelterLattice lattice) {
        this.lattices.remove(lattice);
    }

    public int getPrestige() {
        return prestige;
    }

    public EndangeredAnimalCard getCard() {
        return card;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public boolean isJailed() {
        return jailed;
    }

    public void setJailed(boolean jailed) {
        this.jailed = jailed;
    }

    public String getName() {
        return name;
    }

    public List<OwnedLattice> getLattices() {
        return lattices;
    }

    public void setLattices(List<OwnedLattice> lattices) {
        this.lattices = lattices;
    }

    public int getStep() {
        return step;
    }

    public boolean isOut() {
        return out;
    }

    public void setOut(boolean out) {
        this.out = out;
    }

    public boolean isRelease() {
        return release;
    }

    public void setRelease(boolean release) {
        this.release = release;
    }
}
