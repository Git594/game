package com.etm.racc.map.lattice;

import com.etm.racc.Player;
import com.etm.racc.constant.Game;
import com.etm.racc.map.prop.EndangeredAnimalCard;
import com.etm.racc.map.prop.Prop;
import com.etm.racc.map.prop.QACard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(Parameterized.class)
public class CompetitionLatticeTest {

    private CompetitionLattice competitionLatticeUnderTest;

    @Parameterized.Parameters
    public static List<String> data() {
        return Arrays.asList("fdas", "A", "B", "C");
    }

    @Parameterized.Parameter
    public String input;

    @Before
    public void setUp() {
        CompetitionLattice.setQaCards(Prop.getInstant().getQaCards());
        competitionLatticeUnderTest = new CompetitionLattice(0);
    }

    @Test
    public void testRun() {
        // Setup
        final Player player = new Player("name", 1000, new EndangeredAnimalCard(0, "title"));

        // Run the test
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        final RunResult result = competitionLatticeUnderTest.run(player);
        if (result.isBooleanValue()) {
            Assert.assertEquals(1000, player.getPrestige());
        } else {
            Assert.assertEquals(1000 - Game.PRESTIGE_LOST_COMPETITION, player.getPrestige());
        }

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
