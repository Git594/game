package com.etm.racc.map.lattice;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.etm.racc.Player;
import com.etm.racc.constant.Game;
import com.etm.racc.map.prop.EndangeredAnimalCard;
import com.etm.racc.map.prop.Prop;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class StartLatticeTest {

    private StartLattice startLatticeUnderTest;

    @Parameterized.Parameters
    public static JSONArray data() {
        JSONArray result = new JSONArray();
        Player player1 = new Player("player1", 0, Prop.getInstant().getAnimalCards().get(0));
        player1.addLattice(new ShelterLattice(0));
        player1.addLattice(new BlankLattice(1));
        Player player2 = new Player("player2", 1000, Prop.getInstant().getAnimalCards().get(0));
        player1.addLattice(new ShelterLattice(0));
        Player player3 = new Player("player3", 500, Prop.getInstant().getAnimalCards().get(0));
        player1.addLattice(new BlankLattice(1));
        Player player4 = new Player("player4", 500, Prop.getInstant().getAnimalCards().get(0));
        result.add(player1);
        result.add(player2);
        result.add(player3);
        result.add(player4);
        return result;
    }

    @Parameterized.Parameter
    public Player param;

    @Before
    public void setUp() throws Exception {
        startLatticeUnderTest = new StartLattice(0);
    }

    @Test
    public void testRun() {
        // Setup
        final Player player = param;
        int oldValue = player.getPrestige();

        // Run the test
        startLatticeUnderTest.run(player);

        // Verify the results
        for (OwnedLattice ownedLattice : player.getLattices()) {
            if (ownedLattice instanceof ShelterLattice) {
                oldValue -= Game.PRESTIGE_SHELTER_MAINTENANCE;
            } else if (ownedLattice instanceof BlankLattice){
                oldValue -= Game.PRESTIGE_HABITAT_MAINTENANCE;
            }
        }
        Assert.assertEquals(oldValue, player.getPrestige());
    }
}
