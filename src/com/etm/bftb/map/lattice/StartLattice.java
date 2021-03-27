package com.etm.bftb.map.lattice;

import com.etm.bftb.Player;

public class StartLattice extends NormalLattice {

    public StartLattice(int number) {
        super(number);
    }

    @Override
    public void run(Player player) {
        System.out.println("You're back to the beginning");
        int habitatCount = 0;
        int shelterCount = 0;
        for (OwnedLattice item : player.getLattices()) {
            if (item instanceof BlankLattice) {
                habitatCount++;
            } else if (item instanceof ShelterLattice) {
                shelterCount++;
            }
        }
        if (habitatCount > 0) {
            System.out.println("You have " + habitatCount + " habitat");
            player.reducePrestige(80 * habitatCount);
        }
        if (shelterCount > 0) {
            System.out.println("You have " + shelterCount + " shelter");
            player.reducePrestige(50 * shelterCount);
        }
    }
}
