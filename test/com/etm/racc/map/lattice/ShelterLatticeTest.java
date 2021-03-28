package com.etm.racc.map.lattice;

import com.etm.racc.Player;
import com.etm.racc.map.prop.EndangeredAnimalCard;
import org.junit.Before;
import org.junit.Test;

public class ShelterLatticeTest {

    private ShelterLattice shelterLatticeUnderTest;

    @Before
    public void setUp() throws Exception {
        shelterLatticeUnderTest = new ShelterLattice(0);
    }

    @Test
    public void testRun() {
        // Setup
        final Player player = new Player("name", 0, new EndangeredAnimalCard(0, "title"));

        // Run the test
        shelterLatticeUnderTest.run(player);

        // Verify the results
    }
}
