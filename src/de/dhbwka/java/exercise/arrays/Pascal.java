package de.dhbwka.java.exercise.arrays;

import java.util.Arrays;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Pascal {

	public static void main(String[] args) {
		int lines = 12;
		int[][] triangle = new int[lines][0];
		for (int i = 0; i < triangle.length; i++) {
			triangle[i] = new int[i + 1];
		}

		triangle[0][0] = 1;

		for (int line = 1; line < triangle.length; line++) {
			triangle[line][0] = 1;
			triangle[line][triangle[line].length - 1] = 1;
			for (int i = 1; i < triangle[line].length - 1; i++) {
				triangle[line][i] = triangle[line - 1][i - 1] + triangle[line - 1][i];
			}
		}


		int max = 0;
		for (int val : triangle[lines - 1]) {
			if (val > max)
				max = val;
		}
		int maxLength = Integer.toString(max).length();
		int figureWidth = maxLength % 2 == 0 ? maxLength + 2 : maxLength + 3;
		int lineLength = figureWidth * triangle[lines - 1].length;

		String testOutput = "";
		for (int val : triangle[lines - 1]) {
			testOutput += String.format("%" + (maxLength + 2) + "d", val);
		}

		for (int i = 0; i < triangle.length; i++) {
			String output = "";
			String whitespace = " ".repeat((lineLength - triangle[i].length * figureWidth) / 2);

			output += whitespace;

			for (int val : triangle[i]) {
				output += String.format("%" + figureWidth + "d", val);
			}

			output += whitespace;
			System.out.println(output);
		}

	}

}
