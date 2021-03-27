package com.etm.bftb.map.lattice;

import com.etm.bftb.Player;

import java.util.List;
import java.util.stream.Collectors;

public class MeetingLattice extends SpecialLattice {

    public MeetingLattice(int number) {
        super(number);
    }

    @Override
    public void run(List<Player> players) {
        System.out.println("The current lattice is the meeting lattice");
        List<Player> current = players.stream().filter(Player::isCurrent).collect(Collectors.toList());
        if (current.size() == 1) {
            current.get(0).makeAComments();
        } else {
            throw new RuntimeException("The current number of players exceeded expectations!");
        }
        int prestige = 0;
        for (Player player : players) {
            if (!player.isCurrent() && player.agreeOrNot()) {
                prestige += 100;
            }
        }
        if (prestige > 0) {
            current.get(0).plusPrestige(prestige);
        }
    }
}
