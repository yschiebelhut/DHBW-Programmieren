package de.dhbwka.java.exercise.datatypes;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Round {

	public static void main(String[] args) {
		double pi = 3.1415926;
		double e = 2.7182818;

		int piInt, eInt;

		piInt = (int) pi;
		eInt = (int) e;

		System.out.println("Pi ganzzahlig: " + piInt);
		System.out.println("e ganzzahlig: " + eInt);

		piInt = round(pi);
		eInt = round(e);

		System.out.println("Pi ganzzahlig: " + piInt);
		System.out.println("e ganzzahlig: " + eInt);

		// negative Zahlen
		System.out.println("negative Zahlen");
		pi = -pi;
		e = -e;

		piInt = round(pi);
		eInt = round(e);

		System.out.println("-Pi ganzzahlig: " + piInt);
		System.out.println("-e ganzzahlig: " + eInt);

	}

	public static int round(double a) {
//		System.out.println("a: " + a);
		double out;
//		System.out.println("mod a: " + a % 1.0);
		if (a % 1.0 >= 0.5) {
			out = a + 1.0;
//			System.out.println("im here, adding 1.0 before cutting off");
			return (int) out;
		} else if (a % 1.0 <= -0.5) {
			out = a - 1.0;
//			System.out.println("figure is negative, substracting 1.0 before cutting off");
			return (int) out;
		}
//		System.out.println("no change, just cutting off");
		return (int) a;
	}

}
