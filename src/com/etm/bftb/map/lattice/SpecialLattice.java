package com.etm.bftb.map.lattice;

import com.etm.bftb.Player;

import java.util.List;

public abstract class SpecialLattice extends Lattice {

    public SpecialLattice(int number) {
        super(number);
        this.type = 1;
    }

    /**
     * 根据格子的规则执行的动作
     * @param players 所有的玩家
     */
    public abstract void run(List<Player> players);
}
