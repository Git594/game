package com.etm.bftb.map.lattice;

import com.etm.bftb.Player;

public abstract class ReturnableLattice extends Lattice {

    public ReturnableLattice(int number) {
        super(number);
    }

    /**
     * 需要返回值的格子
     * @param player 当前玩家
     * @return 运行结果
     */
    public abstract RunResult run(Player player);

}
