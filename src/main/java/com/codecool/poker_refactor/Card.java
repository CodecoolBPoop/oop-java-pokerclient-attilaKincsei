package com.codecool.poker_refactor;

import java.util.HashMap;

class Card {

    private String cardCode;
    private String cardRank;
    private HashMap<String, Integer> abcCardRank = new HashMap<>();
    private static final String DECK_SUITS = "CDHS";
    private static final String DECK_ABC_RANKS = "JQKA";

    Card(String cardCode) throws IllegalArgumentException {
        this.cardCode = cardCode;

        abcCardRank.put("J", 11);
        abcCardRank.put("Q", 12);
        abcCardRank.put("K", 13);
        abcCardRank.put("A", 14);

        String cardSuit = this.cardCode.substring(0, 1).toUpperCase();
        cardRank = this.cardCode.substring(1).toUpperCase();
        Integer numericCardRank;

        if (!DECK_SUITS.contains(cardSuit))
        {
            throw new IllegalArgumentException("Alphabetic card suit isn't valid: " + cardSuit);
        } else if (!DECK_ABC_RANKS.contains(cardRank)) {
            try {
                numericCardRank = Integer.parseInt(cardRank);
                if (numericCardRank > 10 || numericCardRank < 2) {
                    throw new IllegalArgumentException("Numeric card rank isn't valid: " + numericCardRank);
                }
            } catch (NumberFormatException NFE) {
                System.out.println("Card rank is not a number or J, Q, K, A\n" + NFE);
                throw new NumberFormatException("Card rank is not a number or J, Q, K, A\n" + NFE);
            }
        }
    }

    int getValue() {
        return (DECK_ABC_RANKS.contains(cardRank)) ? abcCardRank.get(cardRank) : Integer.parseInt(cardRank);
    }
}

