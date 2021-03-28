package com.etm.bftb.map.lattice;

import com.etm.bftb.Player;
import com.etm.bftb.map.prop.EndangeredAnimalCard;
import com.etm.bftb.map.prop.Prop;

import java.util.List;

public class AnimalLattice extends NormalLattice {

    /**
     * 实例计数器
     */
    private static Integer instantCount = 0;

    private final EndangeredAnimalCard card;

    public AnimalLattice(int number) {
        super(number);
        List<EndangeredAnimalCard> cards = Prop.getInstant().getAnimalCards();
        int index = instantCount ++ % cards.size();
        this.card = cards.get(index);
        instantCount++;
    }

    @Override
    public void run(Player player) {
        System.out.println("The current lattice is the endangered animal lattice. The animal is " + this.card.getTitle());
        if (player.getCard().equals(this.card)) {
            System.out.println("Your card is the same as this lattice");
            player.plusPrestige(100);
        } else {
            System.out.println("Your current endangered animal card is " + player.getCard().getTitle() + ". The two are different");
        }
    }
}
