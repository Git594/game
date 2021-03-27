package com.etm.bftb.map.lattice;

import com.etm.bftb.Player;

public class PoacherLattice extends NormalLattice {

    public PoacherLattice(int number) {
        super(number);
    }

    @Override
    public void run(Player player) {
        System.out.println("You've met poachers!");
        player.reducePrestige(200);
    }
}
