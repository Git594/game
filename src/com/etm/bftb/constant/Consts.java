package com.etm.bftb.constant;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public interface Consts {
    interface Lattices {
        int ANIMAL = 8;
        int BLANK = 12;
        int SHELTER = 10;
        int POACHER = 10;
        int SPECIAL = 4;
        List<Integer> FIXED_POSITION = Arrays.asList(0, 11, 22, 33);
    }
}
