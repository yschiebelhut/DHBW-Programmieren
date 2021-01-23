package de.dhbwka.java.exercise.control;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGuess {

	public static void main(String[] args) {
		int min = 1;
		int max = 100;
		int geheimeZahl = ThreadLocalRandom.current().nextInt(min, max + 1);
		int versuche = 0;
		boolean abort = false;

		System.out.print("Wie ist Dein Name? ");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();

		while (!abort) {
			System.out.printf("%s, rate eine Zahl [1-100]: ", name);
			try {
				int input = sc.nextInt();
				versuche++;
				if (input < geheimeZahl) {
					System.out.printf("Versuch %d: %d ist zu niedrig.\n", versuche, input);
				} else if (input > geheimeZahl) {
					System.out.printf("Versuch %d: %d ist zu hoch.\n", versuche, input);
				} else {
					System.out.printf("Versuch %d: %d ist korrekt.\n", versuche, input);
					System.out.println("Was möchtest Du tun?");
					System.out.println("0 - Das Spiel beenden");
					System.out.println("1 - Das Spiel fortsetzen");
					int choice = 2;
					while (!(choice == 0 || choice == 1)) {
						try {
							choice = sc.nextInt();
						} catch (InputMismatchException e) {
							System.out.println("bitte gebe entweder 0 oder 1 ein");
						}
					}
					if (choice == 0) {
						abort = true;
					} else {
						versuche = 0;
						geheimeZahl = ThreadLocalRandom.current().nextInt(min, max + 1);
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("bitte gebe eine positive Ganzzahl ein");
			}
		}
	}

}
