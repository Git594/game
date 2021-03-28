package com.etm.racc.map.lattice;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LatticeTest {

    private Lattice latticeUnderTest;

    @Before
    public void setUp() {
        latticeUnderTest = new BlankLattice(0);
    }

    @Test
    public void testToString() {
        // Setup

        // Run the test
        latticeUnderTest.setNumber(1);
        final String result = latticeUnderTest.toString();

        // Verify the results
        assertEquals(latticeUnderTest.getClass().getName() + "@" + Integer.toHexString(latticeUnderTest.hashCode()) + ": number: " + latticeUnderTest.getNumber() + ", type: " + 0, result);
    }
}
