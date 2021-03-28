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
        System.out.println(result);
    }
}
