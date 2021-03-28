package com.etm.racc.map.prop;

import com.alibaba.fastjson.JSONArray;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class CardFactoryTest {

    private CardFactory cardFactoryUnderTest;

    @Before
    public void setUp() throws Exception {
        cardFactoryUnderTest = new CardFactory();
    }

    @Test
    public void testCreateCard() {
        // Setup

        // Run the test
        final Card result = cardFactoryUnderTest.createCard(0, 0);

        // Verify the results
    }

    @Test
    public void testCreateQACard() {
        // Setup

        // Run the test
        final QACard result = cardFactoryUnderTest.createQACard(0);

        // Verify the results
    }

    @Test
    public void testCreateAnimalCard() {
        // Setup

        // Run the test
        final EndangeredAnimalCard result = cardFactoryUnderTest.createAnimalCard(0);

        // Verify the results
    }

    @Test
    public void testGetAnimalList() {
        assertEquals(Collections.singletonList("value"), CardFactory.getAnimalList());
        assertEquals(Collections.emptyList(), CardFactory.getAnimalList());
    }

    @Test
    public void testGetQaList() {
        // Setup
        final JSONArray expectedResult = new JSONArray(Collections.singletonList("value"));

        // Run the test
        final JSONArray result = CardFactory.getQaList();

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
