package com.etm.bftb;

import com.etm.bftb.map.prop.Dice;
import com.etm.bftb.map.prop.EndangeredAnimalCard;

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
     * 言论
     */
    private String comments;

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
     * @return 点数
     */
    public int throwingDice() {
        return Dice.getNum();
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
