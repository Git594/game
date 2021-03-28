package com.etm.racc.map.lattice;

import com.etm.racc.Player;
import org.junit.Before;

public class NormalLatticeTest {

    private NormalLattice normalLatticeUnderTest;

    @Before
    public void setUp() {
        normalLatticeUnderTest = new NormalLattice(0) {
            @Override
            public void run(Player player) {

            }
        };
    }
}
