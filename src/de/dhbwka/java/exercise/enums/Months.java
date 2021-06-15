package de.dhbwka.java.exercise.enums;

import java.util.Calendar;

/**
 * @author Yannik Schiebelhut
 */
public class Months {

	public static void main(String[] args) {
		int curMonth = Calendar.getInstance().get(Calendar.MONTH);
		System.out.printf("Der %s hat %d Tage und hieß früher '%s'", Monate.values()[curMonth],
				Monate.values()[curMonth].numDays, Monate.values()[curMonth].names);
	}

	enum Monate {
		JANUARY(31, "Hartung, Eismond"),
		FEBRUARY(28, "Hornung, Schmelzmond, Taumond, Narrenmond, Rebmond, Hintester"),
		MARCH(31, "Lenzing, Lenzmond"),
		APRIL(30, "Launing, Ostermond"),
		MAY(31, "Winnemond, Blumenmond"),
		JUNE(30, "Brachet, Brachmond"),
		JULY(31, "Heuert, Heumond"),
		AUGUST(31, "Ernting, Erntemond, Bisemond"),
		SEPTEMBER(30, "Scheiding, Herbstmond"),
		OCTOBER(31, "Gilbhart, Gilbhard, Weinmond"),
		NOVEMBER(30, "Nebelung, Windmond, Wintermond"),
		DECEMBER(31, "Julmond, Heilmond, Christmond, Dunstermond");


		public int numDays;
		public String names;

		Monate(int numDays, String names) {
			this.numDays = numDays;
			this.names = names;
		}

		@Override
		public String toString() {
			return this.name().charAt(0) + this.name().substring(1).toLowerCase();
		}
	}
}
