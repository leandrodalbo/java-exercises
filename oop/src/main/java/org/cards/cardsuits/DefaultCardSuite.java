package org.cards.cardsuits;

public enum DefaultCardSuite implements CardSuit {
    SPADES, HEARTS, DIAMONDS, CLUBS;

    @Override
    public String variety() {
        return "Default";
    }
}
