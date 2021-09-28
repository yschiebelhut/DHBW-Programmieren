package de.dhbwka.java.exercise.classes.wechselspiel;

import java.util.Arrays;

/**
 * @author Yannik Schiebelhut
 */
public class Wechselspiel {

	public static void main(String[] args) {
		Board b = new Board();
		System.out.println(arrToString(b.getFields()));
	}

	private static String arrToString(int[][] arr) {
		StringBuilder sb = new StringBuilder();
		for (int[] line : arr) {
			sb.append(Arrays.toString(line));
			sb.append("\n");
		}
		return sb.toString();
	}
}
