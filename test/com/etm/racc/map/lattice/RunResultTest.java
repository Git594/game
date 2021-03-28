package com.etm.racc.map.lattice;

import org.junit.Before;
import org.junit.Test;

public class RunResultTest {

    private RunResult runResultUnderTest;

    @Before
    public void setUp() throws Exception {
        runResultUnderTest = new RunResult(false);
    }

    @Test
    public void createInstantTest() {
        System.out.println(runResultUnderTest);
    }
}
