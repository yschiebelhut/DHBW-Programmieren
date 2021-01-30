package de.dhbwka.java.exercise.control;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Babylon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Wurzel aus welcher Zahl ziehen? ");

		try {
			double a = sc.nextDouble();
			double xn = 1;
			double xna = 1;

			do {
				xna = xn;
				xn = (xn + (a / xn)) / 2;
				System.out.println("xn: " + xn);
			} while (Math.abs(xn - xna) > 1e-6);
			
			System.out.printf("\n\nDie wurzel aus %f is %.6f\n", a, xn);
		} catch (InputMismatchException e) {
			System.out.println("input is not a valid number");
		}
	}

}
