package de.dhbwka.java.exercise.arrays;

import java.util.Random;

/**
 * @author Yannik Schiebelhut
 *
 */
public class StandardDeviation {

	public static void main(String[] args) {
		int[] values = new int[100];
		Random rand = new Random();

		for (int i = 0; i < 100; i++) {
			values[i] = rand.nextInt(11);
		}

		double average = 0;
		for (int value : values) {
			average += value;
		}
		average = average / values.length;
		System.out.println("Mittelwert: " + average);

		double standardabweichung = 0;

		for (int value : values) {
			standardabweichung += Math.pow((value - average), 2);
		}
		standardabweichung = Math.sqrt(standardabweichung / (values.length - 1));

		System.out.println("Standardabweichung: " + standardabweichung);
	}

}
