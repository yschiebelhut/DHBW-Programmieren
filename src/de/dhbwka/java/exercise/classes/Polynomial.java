package de.dhbwka.java.exercise.classes;

import java.util.ArrayList;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Polynomial {
	private double a, b, c;

	public Polynomial(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public String toString() {
		return String.format("%+5.4fx\u00b2 %+5.4fx %+5.4f", a, b, c);
	}

	public double f(double x) {
		return (this.a * Math.pow(x, 2)) + (this.b * x) + this.c;
	}

	public Polynomial add(Polynomial p2) {
		return new Polynomial(this.a + p2.a, this.b + p2.b, this.c + p2.c);
	}

	public Polynomial subtract(Polynomial p2) {
		return new Polynomial(this.a - p2.a, this.b - p2.b, this.c - p2.c);
	}

	public Polynomial scalarMult(double scalar) {
		return new Polynomial(this.a * scalar, this.b * scalar, this.c * scalar);
	}

	public ArrayList<Double> nst() {
		ArrayList<Double> output = new ArrayList<Double>();
		double p = this.b / this.a;
		double q = this.c / this.a;
		output.add(-(p / 2) + Math.sqrt(Math.pow(p / 2, 2) - q));
		output.add(-(p / 2) - Math.sqrt(Math.pow(p / 2, 2) - q));
		return output;
	}

	public static void main(String[] args) {
		Polynomial p1 = new Polynomial(2, 0, 0);
		System.out.println("P1: " + p1);
		Polynomial p2 = new Polynomial(0, -4, 1);
		System.out.println("P2: " + p2);
		Polynomial p3 = p1.add(p2);
		System.out.println("P3 = P1 + P2: " + p3);
		p3 = p3.scalarMult(2);
		System.out.println("P3 = 2.0 * P3: " + p3);
		System.out.println("NST von P3 (" + p3 + "):");
		System.out.println(p3.nst());
		
		System.out.println();
		Polynomial p4 = new Polynomial(2,0,2);
		System.out.println(p4);
		System.out.println(p4.nst());
	}
}
