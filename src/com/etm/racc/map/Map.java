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

}
