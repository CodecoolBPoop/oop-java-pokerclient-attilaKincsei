package com.codecool.poker_refactor;

import java.util.ArrayList;
import java.util.List;

class PokerClient {

    private static final String LOWEST_CARD = "S2";
    private List<Card> myCardsList = new ArrayList<>();


    PokerClient(String p1, String p2, String p3, String p4, String p5) {
        myCardsList.add(new Card(p1.toUpperCase()));
        myCardsList.add(new Card(p2.toUpperCase()));
        myCardsList.add(new Card(p3.toUpperCase()));
        myCardsList.add(new Card(p4.toUpperCase()));
        myCardsList.add(new Card(p5.toUpperCase()));
    }

    boolean highestCardIsMine(String p1, String p2, String p3, String p4, String p5) {

        List<Card> opponentsCardsList = new ArrayList<>();
        opponentsCardsList.add(new Card(p1.toUpperCase()));
        opponentsCardsList.add(new Card(p2.toUpperCase()));
        opponentsCardsList.add(new Card(p3.toUpperCase()));
        opponentsCardsList.add(new Card(p4.toUpperCase()));
        opponentsCardsList.add(new Card(p5.toUpperCase()));

        Card highestCard = new Card(LOWEST_CARD);

        for (Card myCard : myCardsList) {
            for (Card opponentsCard : opponentsCardsList) {
                if (opponentsCard.getValue() > myCard.getValue()
                        && opponentsCard.getValue() > highestCard.getValue()) {
                    highestCard = opponentsCard;
                } else if (opponentsCard.getValue() < myCard.getValue()
                        && myCard.getValue() > highestCard.getValue()) {
                        highestCard = myCard;
                    }
                }
        }

        return myCardsList.contains(highestCard);
    }

}