package org.cardsuits;

import org.cards.Card;
import org.cards.Deck;

import org.cards.cardsuits.SpanishCardSuite;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeckTest {

    private final Deck deck = new Deck();

    @Test
    public void shouldGenerateANewPack() {
        deck.generateCardsPack(SpanishCardSuite.values(), 40);

        assertThat(deck.takeACard()).isNotNull();
    }

    @Test
    public void shouldTakeAnewCardEverytime() {
        deck.generateCardsPack(SpanishCardSuite.values(), 40);

        var card0 = deck.takeACard();
        var card1 = deck.takeACard();
        var card2 = deck.takeACard();

        assertThat(card0).isNotEqualTo(card1);
        assertThat(card0).isNotEqualTo(card2);
        assertThat(card1).isNotEqualTo(card2);

    }

    @Test
    public void shouldShuffleTheCards() {
        deck.generateCardsPack(SpanishCardSuite.values(), 40);

        var cardAt10 = deck.checkAtIndex(10);
        deck.shuffle();

        assertThat(cardAt10).isEqualTo(deck.checkAtIndex(10));
    }
}
