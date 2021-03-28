package com.etm.racc.map;

import com.etm.racc.constant.Lattices;
import com.etm.racc.map.lattice.Lattice;
import com.etm.racc.map.lattice.LatticeFactory;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private final List<Lattice> lattices;

    public Map() {
        LatticeFactory factory = new LatticeFactory();
        this.lattices = new ArrayList<>();
        for (int i = 0; i < Lattices.TOTAL_LATTICE; i++) {
            Lattice lattice;
            if (Lattices.FIXED_POSITION.contains(i + 1)) {
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
