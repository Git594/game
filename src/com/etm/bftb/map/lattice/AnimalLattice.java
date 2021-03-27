package com.etm.bftb.map.lattice;

import com.etm.bftb.Player;

import java.util.List;

public class AnimalLattice extends NormalLattice {

    /**
     * 濒危动物号
     */
    private final Integer endangeredAnimalNumber;

    public AnimalLattice(int number, int endangeredAnimalNumber) {
        super(number);
        this.endangeredAnimalNumber = endangeredAnimalNumber;
    }

    @Override
    public void run(Player player) {
        if (player.getCard().getNumber().equals(this.endangeredAnimalNumber)) {
            player.plusPrestige(100);
        }
    }
}
