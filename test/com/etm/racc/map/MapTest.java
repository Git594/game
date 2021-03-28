package com.etm.racc.map;

import com.etm.racc.constant.Lattices;
import com.etm.racc.map.Map;
import com.etm.racc.map.lattice.*;
import org.junit.Assert;
import org.junit.Test;

public class MapTest {

    @Test
    public void createMapTest() {
        Map map = new Map();
        int countAnimal = 0;
        int countBlank = 0;
        int countShelter = 0;
        int countPoacher = 0;
        int countSpecial = 0;
        for (Lattice lattice : map.getLattices()) {
            System.out.println(lattice.toString());
            if (lattice instanceof AnimalLattice) {
                countAnimal++;
            } else if (lattice instanceof BlankLattice) {
                countBlank++;
            } else if (lattice instanceof ShelterLattice) {
                countShelter++;
            } else if (lattice instanceof PoacherLattice) {
                countPoacher++;
            } else {
                countSpecial++;
            }
        }
        Assert.assertEquals(Lattices.ANIMAL_COUNT, countAnimal);
        Assert.assertEquals(Lattices.BLANK_COUNT, countBlank);
        Assert.assertEquals(Lattices.SHELTER_COUNT, countShelter);
        Assert.assertEquals(Lattices.POACHER_COUNT, countPoacher);
        Assert.assertEquals(Lattices.SPECIAL_COUNT, countSpecial);
    }
}
