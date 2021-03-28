package com.etm.racc.map.lattice;

import com.etm.racc.Player;
import com.etm.racc.constant.Game;

import java.util.Objects;
import java.util.Scanner;

public class ShelterLattice extends OwnedLattice {

    private Integer prestige;

    public ShelterLattice(int number) {
        super(number);
        this.prestige = Game.PRESTIGE_INIT_SHELTER;
    }

    @Override
    public void run(Player player) {
        if (Objects.isNull(this.getOwner())) {
            System.out.println(player.getName() + ", the current shelter is in a state of no owner, purchase or not?" +
                    " Your current prestige is " + player.getPrestige() + " (y/n)");
            Scanner scanner = new Scanner(System.in);
            String in = scanner.next();
            if ("y".equals(in)) {
                player.buyShelter(this);
            }
        } else {
            System.out.println("Current shelter owner: " + this.owner.getName());
            if (player.equals(this.owner)) {
                System.out.println("You're in your own shelter");
            } else {
                System.out.println(player.getName() + ", you can choose to buy at a higher prestige or turn in your" +
                        " prestige. Your current prestige is " + player.getPrestige() + " (1/2)");
                Scanner sc = new Scanner(System.in);
                String in = sc.next();
                if ("1".equals(in)) {
                    System.out.println(player.getName() + ", please enter your purchase prestige.");
                    this.purchaseByHigherPrestige(player);
                } else {
                    int prestige = Game.PRESTIGE_ENTER_SHELTER;
                    player.reducePrestige(prestige);
                    if (this.owner.isJailed()) {
                        System.out.println(this.owner.getName() + ", because you re in jail confiscating shelter gains: " + prestige);
                    }
                    this.owner.plusPrestige(prestige);
                }
            }
        }
    }

    private void purchaseByHigherPrestige(Player player) {
        Scanner sc = new Scanner(System.in);
        int prestige = sc.nextInt();
        if (prestige > this.getPrestige()) {
            if (prestige > player.getPrestige()) {
                System.out.println(player.getName() + " , you don't have enough prestige. current prestige: "
                        + player.getPrestige());
                purchaseByHigherPrestige(player);
            } else {
                this.setPrestige(prestige);
                this.getOwner().sellShelter(this);
                player.buyShelter(this);
            }
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
