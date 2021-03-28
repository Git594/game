package com.etm.racc.map.lattice;

import com.etm.racc.Player;
import com.etm.racc.constant.Game;

import java.util.Objects;
import java.util.Scanner;

public class BlankLattice extends OwnedLattice {

    public BlankLattice(int number) {
        super(number);
    }

    @Override
    public void run(Player player) {
        System.out.println("The current lattice is the blank lattice");
        if (Objects.isNull(this.getOwner())) {
            System.out.println(player.getName() + ", do you establish your animal habitat? Your current prestige is "
                    + player.getPrestige() + " (y/n)");
            Scanner sc = new Scanner(System.in);
            String in = sc.next();
            if ("y".equals(in)) {
                // 建立栖息地
                player.establishHabitat(this);
            }
        } else if (!this.owner.equals(player)) {
            int prestige = Game.PRESTIGE_TURN_IN_HABITAT;
            player.reducePrestige(prestige);
            if (this.owner.isJailed()) {
                System.out.println(this.owner.getName() + ", because you re in jail confiscating habitat gains: " + prestige);
            } else {
                this.owner.plusPrestige(prestige);
            }
        } else {
            System.out.println("You're in your own habitat");
        }
    }

}
