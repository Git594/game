package com.etm.racc.map.lattice;

public abstract class Lattice {
    /**
     * 这个格子的编号
     */
    protected int number;

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

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + ": number: " + this.number + ", type: " + this.type;
    }

}
