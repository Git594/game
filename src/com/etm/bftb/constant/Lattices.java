package com.etm.bftb.constant;

import java.util.Arrays;
import java.util.List;

public interface Lattices {
    int ANIMAL_COUNT = 8;
    int BLANK_COUNT = 12;
    int SHELTER_COUNT = 10;
    int POACHER_COUNT = 10;
    int SPECIAL_COUNT = 4;
    int TOTAL_LATTICE = Lattices.ANIMAL_COUNT + Lattices.BLANK_COUNT + Lattices.POACHER_COUNT
            + Lattices.SPECIAL_COUNT + Lattices.SHELTER_COUNT;
    List<Integer> FIXED_POSITION = Arrays.asList(1, 12, 23, 34);
}
