package de.dhbwka.java.exercise.control;

import java.util.Scanner;

/**
 * @author Yannik Schiebelhut
 *
 */
public class AddUp {

	public static void main(String[] args) {
//		withWhile();
		withDoWhile();
	}

	public static void withWhile() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;

		System.out.print("Zahl eingeben (<0 für Abbruch): ");

		try {
			String inputStr = sc.next();
			int input = Integer.parseInt(inputStr);

			while (input >= 0) {
				sum += input;

				try {
					System.out.print("Zahl eingeben (<0 für Abbruch): ");
					inputStr = sc.next();
					input = Integer.parseInt(inputStr);
				} catch (NumberFormatException e) {
					System.out.println("entered number cannot be converted to int");
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("entered number cannot be converted to int");
		}

		System.out.println("Summe: " + sum);
	}

	public static void withDoWhile() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		String inputStr;
		int input = 0;

		do {
			System.out.print("Zahl eingeben (<0 für Abbruch): ");
			try {
				inputStr = sc.next();
				input = Integer.parseInt(inputStr);

				if (input >= 0) {
					sum += input;
				}
			} catch (NumberFormatException e) {
				System.out.println("entered number cannot be converted to int");
			}
		} while (input >= 0);

		System.out.println("Summe: " + sum);
	}

}
