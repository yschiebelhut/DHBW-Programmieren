package de.dhbwka.java.exercise.classes;

import java.util.ArrayList;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Horner {

	private double[] coffs;

	public Horner(double... coffs) {
		this.coffs = coffs;
	}

	public double getValue(double x) {
		double output = coffs[coffs.length - 1];

		for (int i = coffs.length - 1; i > 0; i--) {
			output = output * x + coffs[i - 1];
		}

		return output;
	}

	public String toString() {
		String output = "";
		for (int i = coffs.length - 1; i >= 0; i--) {
			output += String.format("%+.2f*x^%d ", coffs[i], i);
		}
		return output;
	}

	public static void main(String[] args) {
		Horner h = new Horner(1, -2, 3, 4.5, 8, -10, 3, 4, 2, -3, 0.5);
		System.out.println("f(x)=" + h);
		System.out.println("f(1.5) = " + h.getValue(1.5));
	}

}
