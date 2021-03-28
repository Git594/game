package com.etm.racc.map.lattice;

import com.etm.racc.Player;
import org.junit.Before;

public class OwnedLatticeTest {

    private OwnedLattice ownedLatticeUnderTest;

    @Before
    public void setUp() {
        ownedLatticeUnderTest = new OwnedLattice(0) {
            @Override
            public void run(Player player) {

            }
        };
    }
}
