package com.etm.racc.map.prop;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class PropTest {

    @Test
    public void testGetInstant() {
        // Run the test
        final Prop result = Prop.getInstant();
        assertEquals(Collections.singletonList(new EndangeredAnimalCard(0, "title")), result.getAnimalCards());
        assertEquals(new EndangeredAnimalCard(0, "title"), result.drawAnimalCards());
        assertEquals(Collections.singletonList(new QACard(0, "title", "answer")), result.getQaCards());
    }
}
