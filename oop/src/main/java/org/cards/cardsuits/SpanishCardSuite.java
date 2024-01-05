package org.cards.cardsuits;

public enum SpanishCardSuite implements CardSuit{
    CLUBS, COINS, CUPS, SWORDS;

    @Override
    public String variety() {
        return "Spanish";
    }
}
