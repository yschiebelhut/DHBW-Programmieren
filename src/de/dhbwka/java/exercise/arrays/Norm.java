package de.dhbwka.java.exercise.arrays;

import de.schiebelhut.misc.InputHelper;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Norm {

	public static void main(String[] args) {
		System.out.print("Bitte Anzahl der Elemente n eingeben: ");
		double[] vector = new double[InputHelper.getIntegerInput()];
		for (int i = 0; i<vector.length;i++) {
			System.out.printf("Bitte x_%d eingeben: ", i);
			vector[i] = InputHelper.getDoubleInput();
		}
		
		double betrag = 0;
		for (double val:vector) {
			betrag += val*val;
		}
		betrag = Math.sqrt(betrag);
		
		System.out.println("Der Betrag von x ist " + betrag);
	}

}
