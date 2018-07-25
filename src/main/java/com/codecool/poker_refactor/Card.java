package com.codecool.poker_refactor;

import java.util.HashMap;

public class Card {

    String cardCode;

    public Card(String cardCode) throws IllegalArgumentException {
        this.cardCode = cardCode;

        String cardColor = this.cardCode.substring(0, 1).toUpperCase();

        if (!cardColor.contentEquals("S") &&
            !cardColor.contentEquals("C") &&
            !cardColor.contentEquals("D") &&
            !cardColor.contentEquals("H"))
        {
            throw new IllegalArgumentException("card color isn't valid: " + cardColor);
        }

        String cardValue = cardCode.substring(1).toUpperCase();
        Integer intCardValue;

        HashMap<String, Integer> alphabeticCardValue = new HashMap<>();
        alphabeticCardValue.put("J", 11);
        alphabeticCardValue.put("Q", 12);
        alphabeticCardValue.put("K", 13);
        alphabeticCardValue.put("A", 14);

        if (alphabeticCardValue.get(cardCode.substring(1).toUpperCase()) == null) {
            // raises exception if cardValue is a letter, but not J/Q/K/A
            intCardValue = Integer.parseInt(cardValue);
            if (intCardValue > 10) {
                throw new IllegalArgumentException("card number isn't valid: " + intCardValue);
            }
            if (intCardValue < 2) {
                throw new IllegalArgumentException("card number isn't valid: " + intCardValue);
            }

        }
    }

    public int getValue() {
        HashMap<String, Integer> alphabeticCardValue = new HashMap<>();
        alphabeticCardValue.put("J", 11);
        alphabeticCardValue.put("Q", 12);
        alphabeticCardValue.put("K", 13);
        alphabeticCardValue.put("A", 14);

        String cardValue = cardCode.substring(1).toUpperCase();
        Integer intCardValue;

        if (alphabeticCardValue.get(cardCode.substring(1).toUpperCase()) == null) {
            intCardValue = Integer.parseInt(cardValue);
        } else {
            intCardValue = alphabeticCardValue.get(cardCode.substring(1).toUpperCase());
        }

        return intCardValue;
    }
}
