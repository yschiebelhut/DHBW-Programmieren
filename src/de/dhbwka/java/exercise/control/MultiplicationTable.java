package de.dhbwka.java.exercise.control;

public class MultiplicationTable {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			String output = "";
			for (int j = 1; j <= 10; j++) {
				output += String.format("%4d", i*j);
			}
			System.out.println(output);
		}
	}

}
