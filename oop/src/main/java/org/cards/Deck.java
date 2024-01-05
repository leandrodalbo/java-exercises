package org.cards;

import org.cards.cardsuits.CardSuit;

import java.util.HashSet;
import java.util.Set;

public class Deck {
    private HashSet<Card> cardspack;

    public void generateCardsPack(CardSuit[] suites, Integer total) {
        var cards = new HashSet<Card>();
        for (int i = 1; i < total; i++) {
            for (CardSuit value : suites) {
                cards.add(new Card(i, value));
            }
        }

        this.cardspack = cards;

    }

    public void shuffle() {

        var cards = this.cardspack.toArray();

        for (int i = 0; i < cards.length; i++) {
            for (int j = cards.length - 1; j >= 0; j--) {
                Card aux = (Card) cards[i];
                cards[i] = cards[j];
                cards[j] = aux;
            }
        }

    }


    public Card takeACard() {
        var removingCard = (Card) this.cardspack.toArray()[0];

        this.cardspack.remove(removingCard);

        return removingCard;

    }

    public Card checkAtIndex(Integer index){
        return (Card) this.cardspack.toArray()[index];
    }
}
