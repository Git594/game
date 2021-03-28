package com.etm.racc.map.lattice;

import com.etm.racc.Player;
import com.etm.racc.constant.Game;

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
