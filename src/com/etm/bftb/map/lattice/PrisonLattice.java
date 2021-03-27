package com.etm.bftb.map.lattice;

import com.etm.bftb.Player;

public class PrisonLattice extends NormalLattice {

    public PrisonLattice(int number) {
        super(number);
    }

    @Override
    public void run(Player player) {
        System.out.println(player.getName() + ", you re in jail");
        player.setJailed(true);
    }
}
