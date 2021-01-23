package de.dhbwka.java.exercise.control;

public class Deers {

	public static void main(String[] args) {
		int bestand = 200;
		int i = 1;

		while (bestand < 300) {
			bestand = (int) (bestand * 1.1 + 0.5);
			bestand -= 15;
			System.out.printf("%2d: %3d Hirsche\n", i, bestand);
			i++;
		}
	}

}
