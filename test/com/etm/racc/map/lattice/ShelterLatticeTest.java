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

import java.io.ByteArrayInputStream;
import java.util.List;

@RunWith(Parameterized.class)
public class ShelterLatticeTest {

    private ShelterLattice shelterLatticeUnderTest;

    @Parameterized.Parameters
    public static JSONArray data() {
        JSONArray result = new JSONArray();
        Player player1 = new Player("player1", 0, Prop.getInstant().getAnimalCards().get(0));
        Player player2 = new Player("player2", 1000, Prop.getInstant().getAnimalCards().get(0));
        Player player3 = new Player("player3", 500, Prop.getInstant().getAnimalCards().get(0));
        result.add(player1);
        result.add(player2);
        result.add(player3);
        return result;
    }

    @Parameterized.Parameter
    public Player param;

    @Before
    public void setUp() throws Exception {
        shelterLatticeUnderTest = new ShelterLattice(0);
    }

    /**
     * 测试不完全，因控制台输入多次
     */
    @Test
    public void testRun() {
        // Setup
        final Player player = param;
        int oldValue = player.getPrestige();

        // Run the test
        System.setIn(new ByteArrayInputStream("y".getBytes()));
        shelterLatticeUnderTest.run(player);

        // Verify the results
        int expect = oldValue - Game.PRESTIGE_INIT_SHELTER < 0 ? oldValue : oldValue - Game.PRESTIGE_INIT_SHELTER;
        Assert.assertEquals(expect, player.getPrestige());

        // Setup
        shelterLatticeUnderTest.setOwner(player);

        // Run the test
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        shelterLatticeUnderTest.run(player);

        // Verify the results
        Assert.assertEquals(expect, player.getPrestige());

        // Setup
        shelterLatticeUnderTest.setOwner(new Player());

        // Run the test
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        shelterLatticeUnderTest.run(player);

        // Verify the results
        expect = expect - Game.PRESTIGE_ENTER_SHELTER;
        Assert.assertEquals(expect, player.getPrestige());

    }
}
