package com.etm.bftb.map.lattice;

import com.etm.bftb.Player;

public class BlankLattice extends OwnedLattice {

    public BlankLattice(int number) {
        super(number);
    }

    @Override
    public void run(Player player) {
        System.out.println("The current lattice is the blank lattice");
        // 是否拥有栖息地
        boolean hasOwner = player.establishHabitat(this);
        if (hasOwner && !this.owner.equals(player)) {
            int prestige = 80;
            player.reducePrestige(prestige);
            if (!this.owner.isJailed()) {
                this.owner.plusPrestige(prestige);
            }
        }
    }

}
