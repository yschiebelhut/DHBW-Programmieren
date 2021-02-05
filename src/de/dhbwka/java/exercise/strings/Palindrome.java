/**
 * 
 */
package de.dhbwka.java.exercise.strings;

import de.schiebelhut.misc.InputHelper;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Palindrome {

	public static void main(String[] args) {
		System.out.print("Bitte Wort eingeben: ");
		String input = InputHelper.getStringInput();
		System.out.println(reverse(input));
		System.out.printf("%s ist %s Palindrom", input, (input.toLowerCase().equals(reverse(input).toLowerCase()) ? "ein" : "kein"));
	}

	public static String reverse(String s) {
		String output = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			output += s.charAt(i);
		}
		return output;
	}

}
