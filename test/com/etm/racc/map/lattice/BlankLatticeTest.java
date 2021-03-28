package com.etm.racc.map.lattice;

import com.etm.racc.Player;
import com.etm.racc.constant.Game;
import com.etm.racc.map.prop.EndangeredAnimalCard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;


public class BlankLatticeTest {

    private BlankLattice blankLatticeUnderTest;

    @Before
    public void setUp() {
        blankLatticeUnderTest = new BlankLattice(0);
    }

    @Test
    public void testRun() {
        // Setup
        final Player player = new Player("name", 1000, new EndangeredAnimalCard(0, "title"));

        // Run the test
        System.setIn(new ByteArrayInputStream("y".getBytes()));
        blankLatticeUnderTest.run(player);
        Assert.assertEquals(1000 - Game.PRESTIGE_HABITAT_ESTABLISH, player.getPrestige());

        System.setIn(new ByteArrayInputStream("n".getBytes()));
        blankLatticeUnderTest.run(player);
        Assert.assertEquals(1000 - Game.PRESTIGE_HABITAT_ESTABLISH, player.getPrestige());

        final Player player2 = new Player("name2", 1000, new EndangeredAnimalCard(1, "title"));
        blankLatticeUnderTest.setOwner(player2);
        player2.setJailed(false);
        blankLatticeUnderTest.run(player);
        Assert.assertEquals(200 - Game.PRESTIGE_TURN_IN_HABITAT, player.getPrestige());
        Assert.assertEquals(1000 + Game.PRESTIGE_TURN_IN_HABITAT, player2.getPrestige());

        blankLatticeUnderTest.setOwner(player2);
        player2.setJailed(true);
        blankLatticeUnderTest.run(player);
        Assert.assertEquals(200 - Game.PRESTIGE_TURN_IN_HABITAT * 2, player.getPrestige());
        Assert.assertEquals(1000 + Game.PRESTIGE_TURN_IN_HABITAT, player2.getPrestige());

        blankLatticeUnderTest.setOwner(player);
        blankLatticeUnderTest.run(player);

    }
}
