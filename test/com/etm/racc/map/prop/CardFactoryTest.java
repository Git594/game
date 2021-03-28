package com.etm.racc.map.prop;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.etm.racc.constant.Prop;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
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
        // Run the test
        final Card result = cardFactoryUnderTest.createCard(0, 0);

        // Verify the results
        Assert.assertTrue(result instanceof EndangeredAnimalCard);

        // Run the test
        final Card result2 = cardFactoryUnderTest.createCard(1, 0);

        // Verify the results
        Assert.assertTrue(result2 instanceof QACard);
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
    public void testGetAnimalList() throws IOException {
        final JSONArray expectedResult = JSONArray.parseArray(FileUtils.readFileToString(new File(Prop.ENDANGERED_ANIMAL_FILE_NAME)));
        assertEquals(expectedResult, CardFactory.getAnimalList());
    }

    @Test
    public void testGetQaList() throws IOException {
        // Setup
        final JSONArray expectedResult = JSONArray.parseArray(FileUtils.readFileToString(new File(Prop.Q_A_FILE_NAME)));

        // Run the test
        final JSONArray result = CardFactory.getQaList();

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
