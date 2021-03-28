package com.etm.racc.map.prop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Prop {
    /**
     * 实例
     */
    private static Prop prop;

    /**
     * 濒危动物卡
     */
    private final List<EndangeredAnimalCard> animalCards;

    /**
     * 问答卡
     */
    private final List<QACard> qaCards;

    public List<EndangeredAnimalCard> getAnimalCards() {
        return animalCards;
    }

    public static Prop getInstant() {
        if (Objects.isNull(prop)) {
            try {
                prop = new Prop();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return prop;
    }

    private Prop() throws IOException {
        CardFactory cardFactory = new CardFactory();
        animalCards = new ArrayList<>();
        this.qaCards = new ArrayList<>();
        for (int i = 0, len = CardFactory.getAnimalList().size(); i < len; i++) {
            EndangeredAnimalCard card = cardFactory.createAnimalCard(i);
            animalCards.add(card);
        }
        for (int i = 0, len = CardFactory.getQaList().size(); i < len; i++) {
            QACard qaCard = cardFactory.createQACard(i);
            this.qaCards.add(qaCard);
        }
    }

    public EndangeredAnimalCard drawAnimalCards() {
        Random random = new Random();
        int randomIndex = random.nextInt(animalCards.size());
        return animalCards.remove(randomIndex);
    }

    public List<QACard> getQaCards() {
        return qaCards;
    }

}
