package com.etm.racc.map.lattice;

import com.etm.racc.Player;

public class PrisonLattice extends NormalLattice {

    public PrisonLattice(int number) {
        super(number);
    }

    @Override
    public void run(Player player) {
        System.out.println(player.getName() + ", you're in jail");
        player.setJailed(true);
    }
}
