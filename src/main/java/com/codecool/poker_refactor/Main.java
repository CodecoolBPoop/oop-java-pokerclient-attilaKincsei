package com.codecool.poker_refactor;


public class Main {

    public static void main(String[] args) {
        PokerClient pokerClient = new PokerClient("h3", "d2", "s3", "s4", "cq");
        System.out.println("the highest card is mine: " + pokerClient.highestCardIsMine("s3", "h4", "s5", "d6", "sj"));
        System.out.println("the highest card is mine: " + pokerClient.highestCardIsMine("s3", "h4", "s5", "d6", "sk"));
    }

}
