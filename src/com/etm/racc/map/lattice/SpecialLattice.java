package com.etm.racc.map.lattice;

import com.etm.racc.Player;

import java.util.List;

public abstract class SpecialLattice extends Lattice {

    public SpecialLattice(int number) {
        super(number);
        this.setType(1);
    }

    /**
     * 根据格子的规则执行的动作
     * @param players 所有的玩家
     */
    public abstract void run(List<Player> players);
}
