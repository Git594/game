package com.etm.racc;

import com.etm.racc.map.lattice.BlankLattice;
import com.etm.racc.map.lattice.OwnedLattice;
import com.etm.racc.map.lattice.ShelterLattice;
import com.etm.racc.map.prop.EndangeredAnimalCard;
import com.etm.racc.map.prop.QACard;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {

    @Mock
    private EndangeredAnimalCard mockCard;

    private Player playerUnderTest;

    @Before
    public void setUp() throws Exception {
        playerUnderTest = new Player("name", 0, mockCard);
    }

    @Test
    public void testReducePrestige() {
        // Setup

        // Run the test
        playerUnderTest.reducePrestige(0);

        // Verify the results
    }

    @Test
    public void testPlusPrestige() {
        // Setup

        // Run the test
        playerUnderTest.plusPrestige(0);

        // Verify the results
    }

    @Test
    public void testThrowingDice() {
        // Setup

        // Run the test
        final int result = playerUnderTest.throwingDice();

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testMovePiece() {
        // Setup

        // Run the test
        playerUnderTest.movePiece(0);

        // Verify the results
    }

    @Test
    public void testAgreeOrNot() {
        // Setup

        // Run the test
        final boolean result = playerUnderTest.agreeOrNot();

        // Verify the results
        assertTrue(result);
    }

    @Test
    public void testMakeAComments() {
        // Setup

        // Run the test
        playerUnderTest.makeAComments();

        // Verify the results
    }

    @Test
    public void testEstablishHabitat() {
        // Setup
        final BlankLattice lattice = new BlankLattice(0);

        // Run the test
        playerUnderTest.establishHabitat(lattice);

        // Verify the results
    }

    @Test
    public void testAnswerQuestion() {
        // Setup
        final QACard qaCard = new QACard(0, "title", "answer");

        // Run the test
        final boolean result = playerUnderTest.answerQuestion(qaCard);

        // Verify the results
        assertTrue(result);
    }

    @Test
    public void testBuyShelter() {
        // Setup
        final ShelterLattice lattice = new ShelterLattice(0);

        // Run the test
        playerUnderTest.buyShelter(lattice);

        // Verify the results
    }

    @Test
    public void testSellShelter() {
        // Setup
        final ShelterLattice lattice = new ShelterLattice(0);

        // Run the test
        playerUnderTest.sellShelter(lattice);

        // Verify the results
    }

    @Test
    public void testAddLattice() {
        // Setup
        final OwnedLattice lattice = null;

        // Run the test
        playerUnderTest.addLattice(lattice);

        // Verify the results
    }

    @Test
    public void testRemoveLattice() {
        // Setup
        final ShelterLattice lattice = new ShelterLattice(0);

        // Run the test
        playerUnderTest.removeLattice(lattice);

        // Verify the results
    }
}
