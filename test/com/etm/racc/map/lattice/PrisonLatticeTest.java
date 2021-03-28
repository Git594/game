package com.etm.racc.map.lattice;

import com.etm.racc.Player;
import com.etm.racc.map.prop.EndangeredAnimalCard;
import org.junit.Before;
import org.junit.Test;

public class PrisonLatticeTest {

    private PrisonLattice prisonLatticeUnderTest;

    @Before
    public void setUp() throws Exception {
        prisonLatticeUnderTest = new PrisonLattice(0);
    }

    @Test
    public void testRun() {
        // Setup
        final Player player = new Player("name", 0, new EndangeredAnimalCard(0, "title"));

        // Run the test
        prisonLatticeUnderTest.run(player);

        // Verify the results
    }
}
