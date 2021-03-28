package com.etm.racc.map.prop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QACardTest {

    private QACard qaCardUnderTest;

    @Before
    public void setUp() throws Exception {
        qaCardUnderTest = new QACard(0, "title", "answer");
    }

    @Test
    public void testCheckAnswer() {
        // Setup

        // Run the test
        final boolean result = qaCardUnderTest.checkAnswer("answer");

        // Verify the results
        assertTrue(result);
    }

    @Test
    public void testToString() {
        // Setup

        // Run the test
        final String result = qaCardUnderTest.toString();

        // Verify the results
        assertEquals("result", result);
    }
}
