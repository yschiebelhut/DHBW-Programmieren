/**
 * 
 */
package de.dhbwka.java.exercise.strings;

import de.schiebelhut.misc.InputHelper;

/**
 * @author Yannik Schiebelhut
 *
 */
public class CrossTotal {
	
	public static void main(String[] args) {
		System.out.print("Bitte Zahl für Quersumme eingeben: ");
		String num = InputHelper.getStringInput();
		
		int crosstotal = 0;
		for (int i = 0; i<num.length();i++) {
			crosstotal += Integer.parseInt(num.substring(i, i+1));
		}
		System.out.printf("Die Quersumme von %s ist %d", num, crosstotal);
	}

}
