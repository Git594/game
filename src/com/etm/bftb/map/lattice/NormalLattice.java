package com.etm.bftb.map.lattice;

import com.etm.bftb.Player;

public abstract class NormalLattice extends Lattice {
    /**
     * 根据格子的规则执行动作
     *
     * @param player 玩家（非拥有者）
     */
    public abstract void run(Player player);

    public NormalLattice(int number) {
        super(number);
        this.type = 0;
    }
}
