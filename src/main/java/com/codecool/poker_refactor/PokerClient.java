package com.codecool.poker_refactor;

import java.util.ArrayList;
import java.util.List;

public class PokerClient {

    public Card card1;
    public Card card2;
    public Card card3;
    public Card card4;
    public Card card5;

    public PokerClient(String p1, String p2, String p3, String p4, String p5) {
        this.card1 = new Card(p1.toUpperCase());
        this.card2 = new Card(p2.toUpperCase());
        this.card3 = new Card(p3.toUpperCase());
        this.card4 = new Card(p4.toUpperCase());
        this.card5 = new Card(p5.toUpperCase());
    }

    public boolean highestCardIsMine(String p1, String p2, String p3, String p4, String p5) {
        Card hc = new Card("s2");
        List<Card> o = new ArrayList<Card>();
        List<Card> m = new ArrayList<Card>();
        o.add(new Card(p1.toUpperCase()));
        o.add(new Card(p2.toUpperCase()));
        o.add(new Card(p3.toUpperCase()));
        o.add(new Card(p4.toUpperCase()));
        o.add(new Card(p5.toUpperCase()));
        m.add(card1);
        m.add(card2);
        m.add(card3);
        m.add(card4);
        m.add(card5);

        for (int i = 0; i < o.size(); i++) {
            Card mc = m.get(i);
            for (int j = 0; j < o.size(); j++) {
                Card oc = o.get(j);
                if (oc.getValue() > mc.getValue()) {
                    if (oc.getValue() > hc.getValue()) {
                        hc = oc;
                    }
                } else {
                    if (mc.getValue() > hc.getValue()) {
                        hc = mc;
                    }
                }
            }
        }

        return m.contains(hc);
    }

}