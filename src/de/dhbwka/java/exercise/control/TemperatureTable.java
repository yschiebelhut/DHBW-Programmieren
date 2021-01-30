package de.dhbwka.java.exercise.control;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * @author Yannik Schiebelhut
 *
 */
public class TemperatureTable {

	public static void main(String[] args) {
		System.out.println("Fahrenheit\t| Celsius");
		String hDelimiter = "-------------------------";
		System.out.println(hDelimiter);
		for (int f = 0; f <= 300; f += 20) {
			double c = (5. / 9.) * (f - 32.);
			
			System.out.printf("  %6.2f\t| %6.2f\n", (float) f, c);
		}
	}
}
