package com.etm.bftb.map;

import com.etm.bftb.constant.Consts;
import com.etm.bftb.map.lattice.*;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private final List<Lattice> lattices;

    public Map() {
        int totalLattice = Consts.Lattices.ANIMAL + Consts.Lattices.BLANK + Consts.Lattices.POACHER
                + Consts.Lattices.SPECIAL + Consts.Lattices.SHELTER;
        LatticeFactory factory = new LatticeFactory();
        this.lattices = new ArrayList<>();
        for (int i = 0; i < totalLattice; i++) {
            Lattice lattice;
            if (Consts.Lattices.FIXED_POSITION.contains(i)) {
                lattice = factory.createLattice(1, i);
            } else {
                lattice = factory.createLattice(0, i);
            }
            this.lattices.add(lattice);
        }
    }

    public List<Lattice> getLattices() {
        return lattices;
    }

//    /**
//     * 测试用
//     * @param args 入参
//     */
//    public static void main(String[] args) {
//        Map map = new Map();
//        int countAnimal = 0;
//        int countBlank = 0;
//        int countShelter = 0;
//        int countPoacher = 0;
//        int countSpecial = 0;
//        for (Lattice lattice : map.lattices) {
//            System.out.println(lattice.toString());
//            if (lattice instanceof AnimalLattice) {
//                countAnimal++;
//            } else if (lattice instanceof BlankLattice) {
//                countBlank++;
//            } else if (lattice instanceof ShelterLattice) {
//                countShelter++;
//            } else if (lattice instanceof PoacherLattice) {
//                countPoacher++;
//            } else {
//                countSpecial++;
//            }
//        }
//        System.out.println("animal: " + countAnimal + ", blank: " + countBlank + ", shelter: " + countShelter +
//                ", poacher: " + countPoacher + ", special: " + countSpecial);
//    }

}
