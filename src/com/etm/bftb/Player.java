package com.etm.bftb;

import java.util.Scanner;

public class Player {
    /**
     * 声望
     */
    private String prestige;

    /**
     * 投掷色字
     * @return 点数
     */
    public int throwingDice() {
        return 1;
    }

    /**
     * 是否同意
     * @return 是否同意
     */
    public boolean agreeOrNot() {
        System.out.println("Do you agree(y/n)?");
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

}
