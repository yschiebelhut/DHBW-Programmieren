package de.dhbwka.java.exercise.control;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import de.schiebelhut.misc.InputHelper;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Quadratics {

	public static void main(String[] args) {
		InputHelper in = new InputHelper();

		System.out.println("enter values");
		System.out.print("a: ");
		double a = in.getDoubleInput();
		System.out.print("b: ");
		double b = in.getDoubleInput();
		System.out.print("c: ");
		double c = in.getDoubleInput();

//		double a = -2;
//		double b = 0;
//		double c = 2;

		if (a == 0) {
			if (b == 0) {
				System.out.println("Die Gleichung ist degeneriert.");
			} else {
				double[] x = new double[1];
				x[0] = -(c / b);
				System.out.println(Arrays.toString(x));
			}
		} else {
			double d = b * b - 4 * a * c;

			if (d >= 0) {
				double[] x = new double[2];
				x[0] = (-b - Math.sqrt(d)) / (2 * a);
				x[1] = (-b + Math.sqrt(d)) / (2 * a);
				Arrays.sort(x);
				System.out.println(Arrays.toString(x));
			} else {
				System.out.println("Die Lösung ist konjungiert komplex.");
			}
		}
	}

}
