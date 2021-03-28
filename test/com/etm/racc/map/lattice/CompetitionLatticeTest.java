package com.etm.racc.map.lattice;

import com.etm.racc.Player;
import com.etm.racc.map.prop.EndangeredAnimalCard;
import com.etm.racc.map.prop.QACard;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompetitionLatticeTest {

    private CompetitionLattice competitionLatticeUnderTest;

    @Before
    public void setUp() {
        competitionLatticeUnderTest = new CompetitionLattice(0);
    }

    @Test
    public void testRun() {
        // Setup
        final Player player = new Player("name", 0, new EndangeredAnimalCard(0, "title"));

        // Run the test
        final RunResult result = competitionLatticeUnderTest.run(player);

        // Verify the results
    }

    @Test
    public void testSetQaCards() {
        // Setup
        final List<QACard> qaCards = Collections.singletonList(new QACard(0, "title", "answer"));

        // Run the test
        CompetitionLattice.setQaCards(qaCards);

        // Verify the results
    }
}
