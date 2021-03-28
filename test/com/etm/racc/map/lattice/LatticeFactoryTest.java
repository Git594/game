package com.etm.racc.map.lattice;

import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RunWith(Parameterized.class)
public class LatticeFactoryTest {

    private LatticeFactory latticeFactoryUnderTest;


    @Parameterized.Parameters
    public static List<JSONObject> data() {
        List<JSONObject> param = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 9; j++) {
                JSONObject temp = new JSONObject();
                temp.put("1", i);
                temp.put("2", j);
                param.add(temp);
            }
        }
        return param;
    }

    @Parameterized.Parameter
    public JSONObject param;

    @Before
    public void setUp() {
        latticeFactoryUnderTest = new LatticeFactory();
    }

    @Test
    public void testCreateLattice() {
        // Setup

        // Run the test
        final Lattice result = latticeFactoryUnderTest.createLattice(param.getInteger("1"), param.getInteger("2"));

        // Verify the results
    }
}
