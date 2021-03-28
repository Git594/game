package com.etm.bftb.map.lattice;

import com.etm.bftb.constant.Lattices;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LatticeFactory {

    private List<Integer> normalList;
    private List<Integer> specialList;

    public LatticeFactory() {
        createNormalList();
        createSpecialList();
    }

    /**
     * 创建格子
     * @param type 种类(0为常规，1为特殊）
     */
    public Lattice createLattice(int type, int number) {
        // 获取不重复的类型
        int r = getAvailableRandomInt(type, number);
        switch (r) {
            case 0: return new AnimalLattice(number);
            case 1: return new BlankLattice(number);
            case 2: return new ShelterLattice(number);
            case 3: return new PoacherLattice(number);
            case 4: return new StartLattice(number);
            case 5: return new PrisonLattice(number);
            case 6: return new MeetingLattice(number);
            case 7: return new CompetitionLattice(number);
            default: throw new RuntimeException();
        }
    }

    private int getAvailableRandomInt(int type, int number) {
        if (type == 0) {
            return getClass(this.normalList);
        } else {
            if (number == 0) {
                specialList.remove(0);
                return 4;
            } else {
                return getClass(this.specialList);
            }
        }
    }

    private int getClass(List<Integer> list) {
        Random random = new Random();
        int index = random.nextInt(list.size());
        int result = list.get(index);
        list.remove(index);
        return result;
    }

    private void createNormalList() {
        this.normalList = new ArrayList<>();
        for (int i = 0; i < Lattices.ANIMAL_COUNT; i++) {
            this.normalList.add(0);
        }
        for (int i = 0; i < Lattices.BLANK_COUNT; i++) {
            this.normalList.add(1);
        }
        for (int i = 0; i < Lattices.SHELTER_COUNT; i++) {
            this.normalList.add(2);
        }
        for (int i = 0; i < Lattices.POACHER_COUNT; i++) {
            this.normalList.add(3);
        }
    }

    private void createSpecialList() {
        this.specialList = new ArrayList<>();
        for (int i = 0; i < Lattices.SPECIAL_COUNT; i++) {
            this.specialList.add(i + 4);
        }
    }

}
