package de.schiebelhut.misc;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Yannik Schiebelhut, Johannes Peters
 *
 */
public class InputHelper {


	public static double getDoubleInput() {
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				return sc.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("Please enter a valid value of type double.");
			} catch (Exception a) {
				System.out.println("different error");
			}
		}
	}

	public static int getIntegerInput() {
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				return sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Please enter a valid value of type int.");
			}
		}
	}

	public static String getStringInput() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

}
