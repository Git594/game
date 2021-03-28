package com.etm.racc.map.prop;

import java.util.Random;

public class Dice {

    public static int getNum() {
        Random ran = new Random();
        return ran.nextInt(6) + 1;
    }

}
