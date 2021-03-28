package com.etm.racc.map.prop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    private Card cardUnderTest;

    @Before
    public void setUp() throws Exception {
        cardUnderTest = new Card(0, "title") {
        };
    }

    @Test
    public void testToString() {
        // Setup

        // Run the test
        final String result = cardUnderTest.toString();

        // Verify the results
        assertEquals("result", result);
    }
}
