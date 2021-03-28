package com.etm.racc.map.lattice;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LatticeTest {

    private Lattice latticeUnderTest;

    @Before
    public void setUp() {
        latticeUnderTest = new Lattice(0) {
        };
    }

    @Test
    public void testToString() {
        // Setup

        // Run the test
        final String result = latticeUnderTest.toString();

        // Verify the results
        assertEquals("result", result);
    }
}
