package com.etm.racc.map.lattice;

import com.etm.racc.Player;
import com.etm.racc.constant.Game;

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
            player.reducePrestige(Game.PRESTIGE_HABITAT_MAINTENANCE * habitatCount);
        }
        if (shelterCount > 0) {
            System.out.println("You have " + shelterCount + " shelter");
            player.reducePrestige(Game.PRESTIGE_SHELTER_MAINTENANCE * shelterCount);
        }
    }
}
