package de.dhbwka.java.exercise.arrays;

import java.util.Arrays;
import java.util.Random;

import de.schiebelhut.misc.InputHelper;

/**
 * @author Yannik Schiebelhut
 *
 */
public class MatrixSubtraction {

	public static void main(String[] args) {
		int zeilenN;
		do {
			System.out.print("Bitte Anzahl der Zeilen n eingeben: ");
			zeilenN = InputHelper.getIntegerInput();
		} while (zeilenN <= 0);

		int spaltenM;
		do {
			System.out.print("Bitte Anzahl der Spalten m eingeben: ");
			spaltenM = InputHelper.getIntegerInput();
		} while (spaltenM <= 0);

		Random rand = new Random();
		int[][] x = new int[zeilenN][spaltenM];
		for (int n = 0; n < x.length; n++) {
			for (int m = 0; m < x[n].length; m++) {
				x[n][m] = rand.nextInt(100);
			}
		}

		int[][] y = new int[zeilenN][spaltenM];
		for (int n = 0; n < y.length; n++) {
			for (int m = 0; m < y[n].length; m++) {
				y[n][m] = rand.nextInt(100);
			}
		}

		System.out.println("X:");
		toString(x);
		System.out.println("Y:");
		toString(y);

		System.out.println("X-Y:");
		toString(subtract(x, y));
	}

	public static void toString(int[][] pArr) {
		for (int n = 0; n < pArr.length; n++) {
			for (int m = 0; m < pArr[n].length; m++) {
				System.out.printf("%4d", pArr[n][m]);
			}
			System.out.println();
		}
	}

	public static int[][] subtract(int[][] a, int[][] b) {
		int[][] c = new int[a.length][a[0].length];

		for (int n = 0; n < a.length; n++) {
			for (int m = 0; m < a[n].length; m++) {
				c[n][m] = a[n][m] - b[n][m];
			}
		}
		return c;
	}

}
