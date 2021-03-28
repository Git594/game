package com.etm.racc.map.lattice;

import com.etm.racc.Player;
import org.junit.Before;

public class ReturnableLatticeTest {

    private ReturnableLattice returnableLatticeUnderTest;

    @Before
    public void setUp() throws Exception {
        returnableLatticeUnderTest = new ReturnableLattice(0) {
            @Override
            public RunResult run(Player player) {
                return null;
            }
        };
    }
}
