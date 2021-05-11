/**
 * 
 */
package de.dhbwka.java.exercise.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import de.schiebelhut.misc.InputHelper;

/**
 * @author Yannik Schiebelhut
 *
 */
public class PalindromeFile {

	public static void main(String[] args) {
		System.out.print("Bitte Wort eingeben: ");
		String input = InputHelper.getStringInput();
		System.out.println(reverse(input));
		String output = String.format("%s ist %s Palindrom", input, (isPalindrome(input)) ? "ein" : "kein");
		System.out.println(output);
		
		if (isPalindrome(input)) {
			try (PrintWriter pr = new PrintWriter(new FileWriter("src/de/dhbwka/java/exercise/io/palindromes.txt", true))) {
				pr.println(output);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader("src/de/dhbwka/java/exercise/io/palindromes.txt"))) {
			while (br.ready()) {
				System.out.println(br.readLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String reverse(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
	}
	
	public static boolean isPalindrome(String s) {
		return s.equalsIgnoreCase(reverse(s));
	}

}
