package com.etm.racc.map.lattice;

import com.etm.racc.Player;

public abstract class NormalLattice extends Lattice {
    /**
     * 根据格子的规则执行动作
     *
     * @param player 玩家
     */
    public abstract void run(Player player);

    public NormalLattice(int number) {
        super(number);
        this.type = 0;
    }
}
