/**
 * 
 */
package de.dhbwka.java.exercise.methods;

import de.schiebelhut.misc.InputHelper;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Exponentation {
	
	public static void main(String[] args) {
		System.out.print("Geben Sie bitte die Basis ein: ");
		double x = InputHelper.getDoubleInput();
		System.out.print("geben Sie bitte den positiven ganzzahligen Exponenten ein: ");
		int i = InputHelper.getIntegerInput();
		System.out.println(xPowerN(x, i));
	}
	
	public static double xPowerN(double x, int n) {
		if (n==0) {
			return 1;
		} else {
			return x * xPowerN(x, n-1);
		}
	}

}
