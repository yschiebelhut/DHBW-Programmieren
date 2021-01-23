package de.dhbwka.java.exercise.operators;

import java.util.Scanner;

public class Easter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("enter year: ");
			int year = Integer.parseInt(sc.next());

			double a = year % 19;
			double b = year % 4;
			double c = year % 7;
			int k = year / 100;
			int p = (8 * k + 13) / 25;
			int q = k / 4;
			double m = (15 + k - p - q) % 30;
			double n = (4 + k - q) % 7;
			double d = (19 * a + m) % 30;
			double e = (2 * b + 4 * c + 6 * d + n) % 7;
			double easter = (22 + d + e);
			
			if(easter <= 31.0) {
				System.out.println(easter);
			} else {
				System.out.println(easter - 31.0);
			}
		} catch (NumberFormatException e) {
			System.out.println("not a vaild year, please try again");
		}
	}

}
