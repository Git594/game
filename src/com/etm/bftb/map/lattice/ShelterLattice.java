package com.etm.bftb.map.lattice;

import com.etm.bftb.Player;

import java.util.Objects;
import java.util.Scanner;

public class ShelterLattice extends OwnedLattice {

    private Integer prestige;

    public ShelterLattice(int number) {
        super(number);
        this.prestige = 200;
    }

    @Override
    public void run(Player player) {
        if (Objects.isNull(this.getOwner())) {
            System.out.println(player.getName() + ", the current shelter is in a state of no owner, purchase or not?(y/n)");
            Scanner scanner = new Scanner(System.in);
            String in = scanner.next();
            if ("y".equals(in)) {
                player.buyShelter(this);
            }
        } else {
            System.out.println("Current shelter owner: " + this.owner.getName());
            System.out.println(player.getName() + ", you can choose to buy at a higher prestige or turn in your prestige.(1/2)");
            Scanner sc = new Scanner(System.in);
            String in = sc.next();
            if ("1".equals(in)) {
                System.out.println(player.getName() + ", please enter your purchase prestige.");
                this.purchaseByHigherPrestige(player);
            } else {
                int prestige = 40;
                player.reducePrestige(prestige);
                this.owner.plusPrestige(prestige);
            }
        }
    }

    private void purchaseByHigherPrestige(Player player) {
        Scanner sc = new Scanner(System.in);
        int prestige = sc.nextInt();
        if (prestige > this.getPrestige()) {
            this.setPrestige(prestige);
            player.buyShelter(this);
            this.getOwner().sellShelter(this);
        } else {
            System.out.println(player.getName() + ", please enter a higher value.");
            purchaseByHigherPrestige(player);
        }
    }

    public Integer getPrestige() {
        return prestige;
    }

    public void setPrestige(Integer prestige) {
        this.prestige = prestige;
    }

}
