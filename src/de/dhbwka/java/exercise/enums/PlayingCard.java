package de.dhbwka.java.exercise.enums;

/**
 * @author Yannik Schiebelhut
 */
public class PlayingCard {

	enum Suit {
		DIAMONDS,
		HEART,
		SPADE,
		CLUBS;

		@Override
		public String toString() {
			return this.name().charAt(0) + this.name().substring(1).toLowerCase();
		}
	}

	enum CardValue {
		ACE,
		KING,
		QUEEN,
		JACK,
		TEN,
		NINE,
		EIGHT,
		SEVEN;

		@Override
		public String toString() {
			return this.name().charAt(0) + this.name().substring(1).toLowerCase();
		}
	}

	private Suit suit;
	private CardValue value;

	@Override
	public String toString() {
		return "'";
	}
}
