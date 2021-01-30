package de.dhbwka.java.exercise.arrays;

import de.schiebelhut.misc.InputHelper;

/**
 * @author Yannik Schiebelhut
 *
 */
public class DotProduct {

	public static void main(String[] args) {
		int length;
		do {
			System.out.print("Bitte Anzahl der Elemente n eingeben: ");
			length = InputHelper.getIntegerInput();
		} while (length <= 0);
		double[] x = new double[length];
		double[] y = new double[length];

		for (int i = 0; i < x.length; i++) {
			System.out.printf("Bitte x_%d eingeben: ", i);
			x[i] = InputHelper.getDoubleInput();
		}

		for (int i = 0; i < y.length; i++) {
			System.out.printf("Bitte y_%d eingeben: ", i);
			y[i] = InputHelper.getDoubleInput();
		}

		double dotP = 0;
		for (int i = 0; i < x.length; i++) {
			dotP += x[i] * y[i];
		}
		System.out.println("Das Skalarprodukt von x und y ist " + dotP);
	}

}
