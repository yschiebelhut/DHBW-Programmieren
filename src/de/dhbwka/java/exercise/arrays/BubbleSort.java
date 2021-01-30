package de.dhbwka.java.exercise.arrays;

import java.util.Arrays;

import de.schiebelhut.misc.InputHelper;

/**
 * @author Yannik Schiebelhut
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int anz;
		do {
			System.out.print("Biite Anzahl der Elemente n eingeben: ");
			anz = InputHelper.getIntegerInput();
		} while (anz <=0);
		
		int[] values = new int[anz];
		
		for (int i =0; i<values.length;i++) {
			System.out.printf("Zahl %d eingeben: ", i);
			values[i] = InputHelper.getIntegerInput();
		}
		
//		int[] values = { 15, 0, -2, 100, 50, 5, 3, 1, 2, 200 };

		System.out.println(Arrays.toString(values));

		for (int j = values.length; j > 1; j--) {
			for (int i = 1; i < j; i++) {
				if (values[i] < values[i - 1]) {
					int tmp = values[i];
					values[i] = values[i-1];
					values[i-1] = tmp;
				}
//				System.out.println(Arrays.toString(values));
			}
		}

		System.out.println(Arrays.toString(values));
	}

}
