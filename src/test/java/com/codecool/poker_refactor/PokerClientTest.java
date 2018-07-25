package com.codecool.poker_refactor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PokerClientTest {

    private static PokerClient pokerClientInstance;

    @BeforeAll
    private static void setUp() {
         pokerClientInstance = new PokerClient("c2", "d4", "d7", "h10", "cj");
    }

    @DisplayName("The highest card is always mine")
    @ParameterizedTest
    @ValueSource(strings = {"c5", "d2", "d3", "d4", "d5", "d5", "d7", "d8", "d9", "d10", "h10"})
    void highestCardIsMine_True_IfJackIsHighest(String riverCard) {
        assertTrue(pokerClientInstance.highestCardIsMine("s3", "h5", "d6", "c8", riverCard));
    }

    @DisplayName("The highest card is never mine")
    @ParameterizedTest
    @ValueSource(strings = {"dj", "dq", "dk", "da", "hj", "sq"})
    void highestCardIsMine_True_IfQueenisLowest(String riverCard) {

        assertFalse(pokerClientInstance.highestCardIsMine("s3", "h5", "d7", "h9", riverCard));
    }


}