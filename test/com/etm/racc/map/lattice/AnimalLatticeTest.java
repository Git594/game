package com.etm.racc.map.lattice;

import com.etm.racc.Player;
import com.etm.racc.map.prop.EndangeredAnimalCard;
import com.etm.racc.map.prop.Prop;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AnimalLatticeTest {

    private AnimalLattice animalLatticeUnderTest;

    @Before
    public void setUp() {
        animalLatticeUnderTest = new AnimalLattice(0);
    }

    @Test
    public void testRun() {
        // Setup
        final List<EndangeredAnimalCard> cards = Prop.getInstant().getAnimalCards();
        final Player player1 = new Player("name", 0, cards.get(0));

        // Run the test
        animalLatticeUnderTest.run(player1);

        // Setup
        final Player player2 = new Player("name", 0, cards.get(1));

        // Run the test
        animalLatticeUnderTest.run(player2);

    }
}
