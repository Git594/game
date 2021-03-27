package com.etm.bftb.map;

import com.etm.bftb.map.prop.Card;
import com.etm.bftb.map.prop.CardFactory;
import com.etm.bftb.map.prop.EndangeredAnimalCard;
import com.etm.bftb.map.prop.QACard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.etm.bftb.constant.Prop.ENDANGERED_ANIMAL_CARDS;
import static com.etm.bftb.constant.Prop.Q_A_CARD_COUNT;

public class Prop {

    /**
     * 濒危动物卡
     */
    private final List<EndangeredAnimalCard> animalCards;

    /**
     * 问答卡
     */
    private final List<QACard> qaCards;

    public Prop() throws IOException {
        CardFactory cardFactory = new CardFactory();
        this.animalCards = new ArrayList<>();
        this.qaCards = new ArrayList<>();
        for (int i = 0, len = ENDANGERED_ANIMAL_CARDS.size(); i < len; i++) {
            EndangeredAnimalCard card = cardFactory.createAnimalCard(i);
            this.animalCards.add(card);
        }
        for (int i = 0; i < Q_A_CARD_COUNT; i++) {
            QACard qaCard = cardFactory.createQACard(i);
            this.qaCards.add(qaCard);
        }
    }

//    /**
//     * 测试用
//     * @param args 入参
//     * @throws IOException 文件未找到
//     */
//    public static void main(String[] args) throws IOException {
//        Prop prop = new Prop();
//        for (EndangeredAnimalCard item : prop.animalCards) {
//            System.out.println(item);
//        }
//        for (QACard item : prop.qaCards) {
//            System.out.println(item);
//        }
//    }

}