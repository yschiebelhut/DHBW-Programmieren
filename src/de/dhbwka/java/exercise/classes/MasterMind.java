/**
 * 
 */
package de.dhbwka.java.exercise.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import de.schiebelhut.misc.InputHelper;

/**
 * @author Yannik Schiebelhut
 *
 */
public class MasterMind {

	ArrayList<Character> compColor;
	ArrayList<Character> tipp;
	ArrayList<String> versuche;
	int anzVersuche;
	int curVersuch = 0;
	int colorLength = 5;

	public MasterMind(int anzVersuche) {
		this.anzVersuche = anzVersuche;
		versuche = new ArrayList<String>();

		this.genCompColor();

		this.play();
	}

	private void play() {
		System.out.println();
		if (curVersuch == anzVersuche) {
			System.out.println("You exceeded the maximum number of tries. MISSION FAILED SUCCESSFULLY");
			System.out.println("The solution was: " + compColor);
		} else {
			curVersuch++;
			System.out.printf("Versuch %d:\n", curVersuch);

			if (!this.auswerten(this.getTipp())) {
				System.out.println("Bisherige Versuche:");
				this.printTrys();
				this.play();
			} else {
				System.out.println("Sie haben gewonnen. Herzlichen Glückwunsch!");
			}

		}
	}

	private boolean auswerten(String curTippAsString) {
		// richtige an richtiger Stelle
		int richtigAnRichtigerStelle = 0;
		ArrayList<Integer> indices = new ArrayList<Integer>();
		for (int i = 0; i < compColor.size(); i++) {
			if (compColor.get(i) == tipp.get(i)) {
				richtigAnRichtigerStelle++;
			} else {
				indices.add(i);
			}
		}

		// indices contains all numbers except matching pairs
		// if there are only matching pairs, game has been won
		if (indices.size() == 0)
			return true;

		int richtigAnFalscherStelle = 0;
		HashMap<Character, Integer> countTipp = new HashMap<Character, Integer>();
		HashMap<Character, Integer> countComp = new HashMap<Character, Integer>();
		for (int i : indices) {
			countTipp.put(tipp.get(i), countTipp.getOrDefault(tipp.get(i), 0) + 1);
			countComp.put(compColor.get(i), countComp.getOrDefault(compColor.get(i), 0) + 1);
		}
		for (char c : countTipp.keySet()) {
			if (countComp.containsKey(c)) {
				richtigAnFalscherStelle += Math.min(countTipp.get(c), countComp.get(c));
			}
		}

		curTippAsString += " " + richtigAnRichtigerStelle + "  " + richtigAnFalscherStelle;
		versuche.add(curTippAsString);

		return false;
	}

	private void printTrys() {
		versuche.forEach((x) -> System.out.println(x));
	}

	private void genCompColor() {
		compColor = new ArrayList<Character>();
		for (int i = 0; i < colorLength; i++) {
			Random rand = new Random();
			compColor.add(intToChar(rand.nextInt(8)));
		}
//		System.out.println("DEBUG: compColor: " + compColor);
	}

	public String getTipp() {
		boolean valid = false;
		System.out.print("Please enter your tipp (String with form ^[a-hA-H]{5}$): ");
		String input;
		do {
			input = InputHelper.getStringInput().toUpperCase();
			if (input.matches("^[A-H]{" + colorLength + "}$"))
				valid = true;
			else
				System.out.print("Tipp has invalid format. Please enter again: ");
		} while (!valid);

		tipp = new ArrayList<Character>();
		for (char c : input.toCharArray()) {
			tipp.add(c);
		}

		return input;
	}

	private char intToChar(int x) {
		switch (x) {
		case 0:
			return 'A';
		case 1:
			return 'B';
		case 2:
			return 'C';
		case 3:
			return 'D';
		case 4:
			return 'E';
		case 5:
			return 'F';
		case 6:
			return 'G';
		case 7:
			return 'H';
		default:
			return 'x';
		}
	}

	public static void main(String[] args) {
		MasterMind mind = new MasterMind(20);
	}

}
