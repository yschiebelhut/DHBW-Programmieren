/**
 * 
 */
package de.dhbwka.java.exercise.methods;

import de.schiebelhut.misc.InputHelper;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("Wie viele Fibonacci-Zahlen berechnen? ");
		int n = InputHelper.getIntegerInput();
		if (n < 1) {
			System.out.println("cannot calculate values for negative n");
		} else {
			for (int i = 1; i <= n; i++) {
				System.out.printf("F(%d) = %d\n", i, fibonacci(i));
			}
		}
	}

	public static int fibonacci(int i) {
		if (i == 1 || i == 2) {
			return 1;
		} else {
			return fibonacci(i - 1) + fibonacci(i - 2);
		}
	}

}
