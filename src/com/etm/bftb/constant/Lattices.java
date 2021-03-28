package com.etm.bftb.constant;

import java.util.Arrays;
import java.util.List;

public interface Lattices {
    /**
     * 动物格子数量
     */
    int ANIMAL_COUNT = 8;
    /**
     * 空白格子数量
     */
    int BLANK_COUNT = 12;
    /**
     * 收容所数量
     */
    int SHELTER_COUNT = 10;
    /**
     * 偷猎者数量
     */
    int POACHER_COUNT = 10;
    /**
     * 特殊格子数量
     */
    int SPECIAL_COUNT = 4;
    /**
     * 特殊格子固定的位置
     */
    List<Integer> FIXED_POSITION = Arrays.asList(1, 12, 23, 34);
    /**
     * 总数
     */
    int TOTAL_LATTICE = Lattices.ANIMAL_COUNT + Lattices.BLANK_COUNT + Lattices.POACHER_COUNT
            + Lattices.SPECIAL_COUNT + Lattices.SHELTER_COUNT;
}
