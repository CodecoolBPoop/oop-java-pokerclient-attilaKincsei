package com.codecool.poker_refactor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    static final String lowestCard = "s2";
    static final int lowestCardValue = 2;
    static Card testCardObject;

    @Disabled
    @BeforeAll
    static void setUp() {
        testCardObject = new Card(lowestCard);
    }

    @DisplayName("Wrong suit code: NOT c, d, h or s")
    @ParameterizedTest
    @ValueSource(strings = {"a2", "b2", "e3"})
    void constructor_ThrowsException_IfCardSuitIsInvalid(String cardCode) {
        assertThrows(IllegalArgumentException.class, () -> new Card(cardCode));
    }

    @DisplayName("Wrong rank letter code: NOT j, q, k or a")
    @ParameterizedTest
    @ValueSource(strings = {"cz", "dw", "hu", "st"})
    void constructor_ThrowsException_IfCardRankLetterIsInvalid(String cardCode) {
        assertThrows(NumberFormatException.class, () -> new Card(cardCode));
    }

    @DisplayName("Wrong rank number code: NOT between 2 and 10")
    @ParameterizedTest
    @ValueSource(strings = {"c-1", "d0", "h1", "s11"})
    void constructor_ThrowsException_IfCardRankNumberIsInvalid(String cardCode) {
        assertThrows(IllegalArgumentException.class, () -> new Card(cardCode));
    }

    @DisplayName("Correct suit and rank codes")
    @ParameterizedTest
    @ValueSource(strings = {"c5", "d2", "d3", "d4", "d5", "d5", "d7", "d8", "d9", "d10", "dj", "dq", "dk", "da", "h10", "sq"})
    void constructor_DoesNotThrowExceptions_IfCardCodeIsValid(String cardCode) {
        assertAll(() -> new Card(cardCode));
    }

    @ParameterizedTest
    @ValueSource(strings = {"c5", "d2", "d3", "d4", "d5", "d5", "d7", "d8", "d9", "d10", "dj", "dq", "dk", "da", "h10", "sq"})
    void getValue_AssertEquals_LowestCard() {
        assertEquals(lowestCardValue, testCardObject.getValue());
    }

}