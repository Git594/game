package com.etm.bftb.map.lattice;

import com.etm.bftb.Player;

public class BlankLattice extends NormalLattice {

    /**
     * 拥有者
     */
    private Player owner;

    public BlankLattice(int number) {
        super(number);
    }

    @Override
    public void run(Player player) {
        // 是否建立栖息地
        boolean hasOwner = player.establishHabitat(this);
        if (hasOwner && !this.owner.equals(player)) {
            int prestige = 80;
            player.reducePrestige(prestige);
            this.owner.plusPrestige(prestige);
        }
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
