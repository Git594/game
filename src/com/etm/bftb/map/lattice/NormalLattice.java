package com.etm.bftb.map.lattice;

import com.etm.bftb.Player;

public abstract class NormalLattice extends Lattice {
    /**
     * 根据格子的规则计算玩家和拥有者的声望值
     *
     * @param player 玩家（非拥有者）
     */
    public abstract void compute(Player player);

    public NormalLattice(int number) {
        super(number);
        this.type = 0;
    }
}
