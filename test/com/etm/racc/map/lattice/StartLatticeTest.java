package com.etm.racc.map.lattice;

import com.etm.racc.Player;
import com.etm.racc.map.prop.EndangeredAnimalCard;
import org.junit.Before;
import org.junit.Test;

public class StartLatticeTest {

    private StartLattice startLatticeUnderTest;

    @Before
    public void setUp() throws Exception {
        startLatticeUnderTest = new StartLattice(0);
    }

    @Test
    public void testRun() {
        // Setup
        final Player player = new Player("name", 0, new EndangeredAnimalCard(0, "title"));

        // Run the test
        startLatticeUnderTest.run(player);

        // Verify the results
    }
}
