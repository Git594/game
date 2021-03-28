package com.etm.racc.map.lattice;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.etm.racc.Player;
import com.etm.racc.constant.Game;
import com.etm.racc.constant.Lattices;
import com.etm.racc.map.prop.EndangeredAnimalCard;
import com.etm.racc.map.prop.Prop;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(Parameterized.class)
public class MeetingLatticeTest {

    private MeetingLattice meetingLatticeUnderTest;

    private static final int prestige = 1000;

    @Parameterized.Parameters
    public static List<JSONObject> data() {
        List<JSONObject> result = new LinkedList<>();
        for(int i = 2; i <= Lattices.ANIMAL_COUNT; i++) {
            List<Player> players = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            sb.append("coment\n");
            for (int j = 0; j < i; j++) {
                Player player = new Player("player" + j, prestige, Prop.getInstant().getAnimalCards().get(j));
                if (j == i - 1) {
                    player.setCurrent(true);
                }
                players.add(player);
                if (i % 2 == 1) {
                    sb.append("y\n");
                } else {
                    sb.append("n\n");
                }
            }
            JSONObject temp = new JSONObject();
            temp.put("players", players);
            temp.put("input", sb.toString());
            result.add(temp);
        }
        return result;
    }

    @Parameterized.Parameter
    public JSONObject param;

    @Before
    public void setUp() {
        meetingLatticeUnderTest = new MeetingLattice(0);
    }

    /**
     * 没法测试，因为该run方法有多个控制台输入
     */
    @Test
    public void testRun() {
        // Setup
        String input = param.getString("input");
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<Player> players = param.getJSONArray("players").toJavaList(Player.class);

        // Run the test
        meetingLatticeUnderTest.run(players);

        // Verify the results
        List<Player> list = players.stream().filter(Player::isCurrent).collect(Collectors.toList());
        Player current = list.get(0);
        String[] splits = input.split("\n");
        int expect = prestige;
        for (int i = 1, len = splits.length; i < len; i++) {
            if ("y".equals(splits[i])) {
                expect += Game.PRESTIGE_JOIN_MEETING;
            }
        }
        Assert.assertEquals(expect, current.getPrestige());
    }
}
