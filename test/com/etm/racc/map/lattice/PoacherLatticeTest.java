package com.etm.racc.map.lattice;

import com.etm.racc.Player;
import com.etm.racc.map.prop.EndangeredAnimalCard;
import org.junit.Before;
import org.junit.Test;

public class PoacherLatticeTest {

    private PoacherLattice poacherLatticeUnderTest;

    @Before
    public void setUp() {
        poacherLatticeUnderTest = new PoacherLattice(0);
    }

    @Test
    public void testRun() {
        // Setup
        final Player player = new Player("name", 0, new EndangeredAnimalCard(0, "title"));

        // Run the test
        poacherLatticeUnderTest.run(player);

        // Verify the results
    }
}
