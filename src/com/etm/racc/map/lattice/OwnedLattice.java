package com.etm.racc.map.lattice;

import com.etm.racc.Player;

public abstract class OwnedLattice extends NormalLattice {

    /**
     * 拥有者
     */
    protected Player owner;

    public OwnedLattice(int number) {
        super(number);
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

}
