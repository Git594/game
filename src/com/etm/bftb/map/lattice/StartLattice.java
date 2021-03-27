package com.etm.bftb.map.lattice;

import com.etm.bftb.Player;

public class StartLattice extends NormalLattice {

    public StartLattice(int number) {
        super(number);
    }

    @Override
    public void run(Player player) {
        for (OwnedLattice item : player.getLattices()) {
            if (item instanceof BlankLattice) {
                player.reducePrestige(80);
            } else if (item instanceof ShelterLattice) {
                player.reducePrestige(50);
            }
        }
    }
}
