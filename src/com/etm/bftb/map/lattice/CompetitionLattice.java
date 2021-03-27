package com.etm.bftb.map.lattice;

import com.etm.bftb.Player;
import com.etm.bftb.constant.Prop;
import com.etm.bftb.map.prop.QACard;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class CompetitionLattice extends ReturnableLattice {

    private static List<QACard> qaCards;

    public CompetitionLattice(int number) {
        super(number);
    }

    @Override
    public RunResult run(Player player) {
        System.out.println("Congratulations on your participation in the knowledge contest!");
        if (Objects.isNull(qaCards)) {
            throw new RuntimeException("Not obtained q a card!");
        }
        Random random = new Random();
        int index = random.nextInt(Prop.Q_A_CARD_COUNT);
        QACard qaCard = qaCards.get(index);
        boolean correct = player.answerQuestion(qaCard);
        return new RunResult(correct);
    }

    public static void setQaCards(List<QACard> qaCards) {
        CompetitionLattice.qaCards = qaCards;
    }
}
