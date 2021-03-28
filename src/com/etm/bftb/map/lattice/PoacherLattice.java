package com.etm.bftb.map.lattice;

import com.etm.bftb.Player;
import com.etm.bftb.constant.Game;

public class PoacherLattice extends NormalLattice {

    public PoacherLattice(int number) {
        super(number);
    }

    @Override
    public void run(Player player) {
        System.out.println("You've met poachers!");
        player.reducePrestige(Game.PRESTIGE_MET_POACHER);
    }
}
