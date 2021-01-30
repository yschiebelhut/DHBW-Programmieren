package de.dhbwka.java.exercise.classes;

import java.util.Random;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Complex {
	private double real, imag;

	public Complex(double real, double imag) {
		super();
		this.real = real;
		this.imag = imag;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}

	public Complex add(Complex comp) {
		return new Complex(this.getReal() + comp.getReal(), this.getImag() + comp.getImag());
	}

	public Complex sub(Complex comp) {
		return new Complex(this.getReal() - comp.getReal(), this.getImag() - comp.getImag());
	}

	public Complex mult(Complex comp) {
		return new Complex((this.getReal() * comp.getReal()) - (this.getImag() * comp.getImag()),
				(this.getReal() * comp.getImag()) + (this.getImag() * comp.getReal()));
	}

	public Complex div(Complex comp) {
		double a = this.getReal();
		double b = this.getImag();
		double c = comp.getReal();
		double d = comp.getImag();
		return new Complex(((a * c) + (b * d)) / ((c * c) + (d * d)), ((b * c) - (a * d)) / ((c * c) + (d * d)));
	}

	public double getMagnitude() {
		return Math.sqrt(Math.pow(getReal(), 2) + Math.pow(getImag(), 2));
	}

	public boolean isLess(Complex comp) {
		return this.getMagnitude() < comp.getMagnitude();
	}

	@Override
	public String toString() {
		return String.format("%f + %fi", this.getReal(), this.getImag());
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Complex c1 = new Complex(1, 2);
		Complex c2 = new Complex(2, 1);
		System.out.println("C1+C2: " + c1.add(c2));
		System.out.println("C1-C2: " + c1.sub(c2));
		System.out.println("C1*C2: " + c1.mult(c2));
		System.out.println("C1/C2: " + c1.div(c2));
		System.out.println("C1<C2?: " + c1.isLess(c2));

		System.out.println("Unsortiert:");
		Complex[] arr = new Complex[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Complex(rand.nextDouble() * 10, rand.nextDouble() * 10);
			System.out.printf("%s\tBetrag: %.4f\n", arr[i], arr[i].getMagnitude());
		}

		// bubble sort
		for (int i = arr.length; i > 0; i--) {
			for (int j = 1; j < i; j++) {
				if (arr[j].isLess(arr[j - 1])) {
					Complex tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
				}
			}
		}

		System.out.println("Sortiert:");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%s\tBetrag: %.4f\n", arr[i], arr[i].getMagnitude());
		}
	}
}
