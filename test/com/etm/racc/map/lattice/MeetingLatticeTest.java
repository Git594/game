package com.etm.racc.map.lattice;

import com.etm.racc.Player;
import com.etm.racc.map.prop.EndangeredAnimalCard;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MeetingLatticeTest {

    private MeetingLattice meetingLatticeUnderTest;

    @Before
    public void setUp() {
        meetingLatticeUnderTest = new MeetingLattice(0);
    }

    @Test
    public void testRun() {
        // Setup
        final List<Player> players = Collections.singletonList(new Player("name", 0, new EndangeredAnimalCard(0, "title")));

        // Run the test
        meetingLatticeUnderTest.run(players);

        // Verify the results
    }
}
