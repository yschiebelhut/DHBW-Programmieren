package de.dhbwka.java.exercise.control;

import java.util.HashMap;

/**
 * @author Yannik Schiebelhut
 *
 */
public class ShoeSize {

	public static void main(String[] args) {
		int smallest = 30;
		int largest = 35;
		HashMap table = new HashMap();

		System.out.println("Zentimeter    | Größe");
		System.out.println("---------------------");
		
		for (int i = smallest - 1; i <= largest; i++) {
			table.put(i, i / 1.5);
		}
		for (int i = smallest; i <= largest; i++) {
			System.out.printf("%5.2f - %5.2f | %3d\n", table.get(i - 1), table.get(i), i);
		}
	}

}
