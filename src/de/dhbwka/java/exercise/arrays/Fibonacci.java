package de.dhbwka.java.exercise.arrays;

import java.util.Arrays;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
		int numFields = 20;
		int[] sequence = new int[numFields];

		for (int i = 0; i < numFields; i++) {
			sequence[i] = fibonacci(i);
		}

		System.out.println(Arrays.toString(sequence));
	}

	public static int fibonacci(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

}
