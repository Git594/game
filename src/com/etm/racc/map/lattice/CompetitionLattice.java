package com.etm.racc.map.lattice;

import com.etm.racc.Player;
import com.etm.racc.map.prop.Prop;
import com.etm.racc.map.prop.QACard;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class CompetitionLattice extends ReturnableLattice {

    private static List<QACard> qaCards;

    public CompetitionLattice(int number) {
        super(number);
    }

    @Override
    public RunResult run(Player player) {
        System.out.println(player.getName() + ", congratulations on your participation in the knowledge contest!");
        if (Objects.isNull(qaCards)) {
            throw new RuntimeException("Not obtained q a card!");
        }
        Random random = new Random();
        int index = random.nextInt(Prop.getInstant().getQaCards().size());
        QACard qaCard = qaCards.get(index);
        System.out.println("Please answer the question:");
        System.out.println(qaCard.getTitle());
        boolean correct = player.answerQuestion(qaCard);
        return new RunResult(correct);
    }

    public static void setQaCards(List<QACard> qaCards) {
        CompetitionLattice.qaCards = qaCards;
    }
}
