package com.etm.bftb.map.lattice;

import com.etm.bftb.Player;

import java.util.List;

public class AnimalLattice extends NormalLattice {

    /**
     * 濒危动物号
     */
    private final Integer endangeredAnimalNumber;

    /**
     * 濒危动物名称
     */
    private final String endangeredAnimalName;

    public AnimalLattice(int number, int endangeredAnimalNumber, String endangeredAnimalName) {
        super(number);
        this.endangeredAnimalNumber = endangeredAnimalNumber;
        this.endangeredAnimalName = endangeredAnimalName;
    }

    @Override
    public void run(Player player) {
        System.out.println("The current lattice is the endangered animal lattice. The animal is " + endangeredAnimalName);
        if (player.getCard().getNumber().equals(this.endangeredAnimalNumber)) {
            System.out.println("Your card is the same as this lattice");
            player.plusPrestige(100);
        }
        System.out.println("Your current endangered animal card is " + player.getCard().getTitle() + ". The two are different");
    }
}
