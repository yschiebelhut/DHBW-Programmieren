package de.dhbwka.java.exercise.datatypes;

/**
 * @author Yannik Schiebelhut
 *
 */
public class ShortValue {

	public static void main(String[] args) {
		short a = 32767;
		System.out.println(a);
		a++;
		System.out.println(a);

		/*
		 * Wird "a" inkrementiert, so wird nun der -32768 gespeichert. Dies liegt daran,
		 * dass der Wertebereich eines shorts nur von -32768 bis 32767 reicht.
		 */
	}

}
