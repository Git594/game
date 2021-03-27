package com.etm.bftb;

import com.etm.bftb.map.Map;
import com.etm.bftb.map.lattice.BlankLattice;
import com.etm.bftb.map.lattice.ShelterLattice;
import com.etm.bftb.map.prop.Dice;
import com.etm.bftb.map.prop.EndangeredAnimalCard;
import com.etm.bftb.map.prop.QACard;

import java.util.Objects;
import java.util.Scanner;

public class Player {

    public Player(int prestige, EndangeredAnimalCard card) {
        this.prestige = prestige;
        this.card = card;
    }

    /**
     * 名称
     */
    private String name;

    /**
     * 输入
     */
    private String input;

    /**
     * 声望
     */
    private int prestige;

    /**
     * 濒危动物卡
     */
    private final EndangeredAnimalCard card;

    /**
     * 是否是当前玩家
     */
    private boolean current;

    /**
     * 是否出局
     */
    private boolean out;

    /**
     * 所在的格子数
     */
    private int step;

    /**
     * 减少声望
     * @param prestige 减少的声望
     */
    public void reducePrestige(int prestige) {
        this.prestige -= prestige;
    }

    /**
     * 增加声望
     * @param prestige 增加的声望
     */
    public void plusPrestige(int prestige) {
        this.prestige += prestige;
    }

    /**
     * 投掷色子
     */
    public void throwingDice() {
        int stepNum = Dice.getNum();
        this.step += stepNum;
        if (this.step > Map.totalLattice) {
            this.step -= Map.totalLattice;
        }
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
        this.input = sc.next();
    }

    /**
     * 建立栖息地
     * @param lattice 空白格子
     * @return 是否已建立
     */
    public boolean establishHabitat(BlankLattice lattice) {
        if (Objects.isNull(lattice.getOwner())) {
            System.out.println(this.name + ", do you establish your animal habitat?(y/n)");
            Scanner sc = new Scanner(System.in);
            String in = sc.next();
            if ("y".equals(in)) {
                lattice.setOwner(this);
                return true;
            }
        }
        return false;
    }

    /**
     * 答题
     * @param qaCard 答题卡实体类
     * @return 是否正确
     */
    public boolean answerQuestion(QACard qaCard) {
        System.out.println("Please answer the question:");
        System.out.println(qaCard.getTitle());
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        if (qaCard.checkAnswer(in)) {
            this.throwingDice();
            return true;
        } else {
            this.reducePrestige(200);
            return false;
        }
    }

    public void buyShelter(ShelterLattice lattice) {

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

}
