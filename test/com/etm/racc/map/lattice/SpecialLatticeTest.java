package com.etm.racc.map.lattice;

import com.etm.racc.Player;
import org.junit.Before;

import java.util.List;

public class SpecialLatticeTest {

    private SpecialLattice specialLatticeUnderTest;

    @Before
    public void setUp() throws Exception {
        specialLatticeUnderTest = new SpecialLattice(0) {
            @Override
            public void run(List<Player> players) {

            }
        };
    }
}
