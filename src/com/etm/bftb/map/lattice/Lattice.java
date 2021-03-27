package com.etm.bftb.map.lattice;

import com.etm.bftb.Player;

public abstract class Lattice {
    /**
     * 这个格子的编号
     */
    protected int number;
    /**
     * 这个格子的拥有者
     */
    protected Player owner;

    /**
     * 种类，0为常规，1为特殊
     */
    protected int type;

    public Lattice(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.getClass() + ": number: " + this.number + ", type: " + this.type + ", owner: " + this.owner;
    }
}
