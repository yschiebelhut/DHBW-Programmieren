package de.dhbwka.java.exercise.control;

import java.util.Scanner;

/**
 * @author Yannik Schiebelhut
 *
 */
public class LeapYear {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("(Programm kann mit der Eingabe von \"exit\" beendet werden.)\n");

		while (true) {
			System.out.print("Welches Jahr soll auf Schaltjahr geprüft werden? ");
			String input = sc.next();
			if (input.equals("exit")) {
				return;
			} else {
				try {
					int year = Integer.parseInt(input);
					boolean isLeapYear = false;

					if ((year % 4) == 0) {
						isLeapYear = true;
					}
					if ((year % 100) == 0) {
						isLeapYear = false;
						if ((year % 400) == 0) {
							isLeapYear = true;
						}
					}

					String output = year + " ist ";
					if (isLeapYear) {
						output += "ein Schaltjahr";
					} else {
						output += "kein Schaltjahr";
					}
					System.out.println(output);
					System.out.println();
				} catch (Exception e) {
					System.out.println("Input is not a year. Please try again");
					System.out.println();
				}
			}
		}
	}

}
