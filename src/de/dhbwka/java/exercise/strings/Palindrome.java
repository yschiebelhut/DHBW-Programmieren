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
		System.out.printf("%s ist %s Palindrom", input, (input.equalsIgnoreCase(reverse(input)) ? "ein" : "kein"));
	}

	public static String reverse(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
	}

}
