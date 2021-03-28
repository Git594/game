package com.etm.racc.map.lattice;

import org.junit.Before;
import org.junit.Test;

public class LatticeFactoryTest {

    private LatticeFactory latticeFactoryUnderTest;

    @Before
    public void setUp() {
        latticeFactoryUnderTest = new LatticeFactory();
    }

    @Test
    public void testCreateLattice() {
        // Setup

        // Run the test
        final Lattice result = latticeFactoryUnderTest.createLattice(0, 0);

        // Verify the results
    }
}
