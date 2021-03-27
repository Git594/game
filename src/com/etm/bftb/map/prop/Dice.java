package com.etm.bftb.map.prop;

import java.util.Random;

public class Dice {

    public static int getNum() {
        Random ran = new Random();
        return ran.nextInt(6) + 1;
    }

}
