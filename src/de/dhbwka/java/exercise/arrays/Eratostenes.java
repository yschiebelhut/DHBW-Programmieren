package de.dhbwka.java.exercise.arrays;

import java.util.Arrays;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Eratostenes {

	public static void main(String[] args) {
		int n = 100;

		int[] sieve = new int[n - 1];
		for (int i = 2; i <= n; i++) {
			System.out.println(i);
			sieve[i - 2] = i;
		}

		int[] primes = new int[n - 1];
		int primesIndex = 0;

		boolean sieveEmpty = false;

		while (!sieveEmpty) {
			int sieveIndex = 0;
			int min = sieve[sieveIndex];
			while (min == 0 && sieveIndex < sieve.length-1) {
				min = sieve[++sieveIndex];
			}

			if (min == 0) {
				sieveEmpty = true;
			} else {
				primes[primesIndex++] = min;

				for (int i = 0; i < sieve.length; i++) {
					if (sieve[i] != 0 && sieve[i] % min == 0) {
						sieve[i] = 0;
					}
				}
			}
		}
		
		System.out.println(Arrays.toString(primes));
	}

}
