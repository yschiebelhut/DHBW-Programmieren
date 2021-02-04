/**
 * 
 */
package de.dhbwka.java.exercise.classes;

import java.util.Arrays;
import java.util.Random;

import de.schiebelhut.misc.InputHelper;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Lotto {

	private int m, n;
	private int[] tipp, gezZahlen;

	public Lotto(int m, int n) {
		this.m = m;
		this.n = n;
	}

	public void tippen() {
		this.tipp = new int[m];
		for (int i = 0; i < tipp.length; i++) {
			int newNum = 0;
			while (numInArr(tipp, newNum) | (newNum > n || newNum <= 0)) {
				System.out.printf("Geben Sie bitte Ihren Tipp für die %d. Zahl ein: ", i + 1);
				newNum = InputHelper.getIntegerInput();
				if (newNum > n || newNum <= 0) {
					System.out.printf("Ungültige Eingabe, bitte wählen Sie Werte zwischen 1 und %d.\n", n);
				} else if (numInArr(tipp, newNum)) {
					System.out.printf(
							"%d befindet sich bereits unter Ihren Tipps. Bitte wählen Sie einen anderen Wert.\n", newNum);
				}
			}
			tipp[0] = newNum;
		}
		Arrays.sort(tipp);
	}

	public void tippen(int[] tipp) {
		this.tipp = tipp;
	}

	public void ziehen() {
		gezZahlen = new int[m];
		Random rand = new Random();
		for (int i = 0; i < gezZahlen.length; i++) {
			int random;
			do {
				random = rand.nextInt(49) + 1;
			} while (!(Arrays.binarySearch(gezZahlen, random) < 0));
			gezZahlen[0] = random;
			Arrays.sort(gezZahlen);
		}
	}

	private boolean numInArr(int[] arr, int n) {
		Arrays.sort(arr);
		return Arrays.binarySearch(arr, n) >= 0;
	}

	public int richtige() {
		int richtige = 0;
		for (int i = 0; i<tipp.length;i++) {
			if (numInArr(gezZahlen, tipp[i])) {
				richtige++;
			}
		}
//		System.out.println("Tipp " + Arrays.toString(tipp));
//		System.out.println("GezZahlen " + Arrays.toString(gezZahlen));
		return richtige;
	}
	
	@Override
	public String toString() {
		String output = "";
		
		if (tipp != null) {
			output += "Tipp: ";
			output += Arrays.toString(tipp);
		}
		
		if (gezZahlen != null) {
			output += "\t gezogene Zahlen: ";
			output += Arrays.toString(gezZahlen);
		}
		
		return output += "\n";
	}

	public static void main(String[] args) {
		Lotto l = new Lotto(6,49);
		System.out.println(l);
		l.tippen();
		System.out.println(l);
		l.ziehen();
		System.out.println(l);
		System.out.println("Richtige: " + l.richtige());
		System.out.println(l);
	}

}
