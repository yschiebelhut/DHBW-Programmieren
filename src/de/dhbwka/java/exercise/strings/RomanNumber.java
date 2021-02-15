/**
 * 
 */
package de.dhbwka.java.exercise.strings;

import de.schiebelhut.misc.InputHelper;

/**
 * @author Yannik Schiebelhut
 *
 */
public class RomanNumber {

	public static void main(String[] args) {

		System.out.print("Bitte geben Sie eine rämische Zahl ein: ");
		String input = InputHelper.getStringInput().toUpperCase();
		System.out.println("Ihre eingegebene Zahl ist: " + input);

		int outNum = 0;

		String workStr = input;
		while (workStr.length() > 0) {
			if (workStr.length() >= 2) {

				// checking for occurance of substraction rule, e.g. IV, IX
				// WARNING: This implementation only allows single substractions, e.g. IIV will
				// NOT work, given example will produce 1+(5-1)=5
				boolean substraction = false;
				switch (workStr.substring(0, 2)) {
				case "IV":
					outNum += 4;
					substraction = true;
					break;
				case "IX":
					outNum += 9;
					substraction = true;
					break;
				case "XL":
					outNum += 40;
					substraction = true;
					break;
				case "XC":
					outNum += 90;
					substraction = true;
					break;
				case "CD":
					outNum += 400;
					substraction = true;
					break;
				case "CM":
					outNum += 900;
					substraction = true;
					break;
				default:
					switch (workStr.substring(0, 1)) {
					case "I":
						outNum += 1;
						break;
					case "V":
						outNum += 5;
						break;
					case "X":
						outNum += 10;
						break;
					case "L":
						outNum += 50;
						break;
					case "C":
						outNum += 100;
						break;
					case "D":
						outNum += 500;
						break;
					case "M":
						outNum += 1000;
						break;
					}
				}
				if (substraction) {
					workStr = workStr.substring(2);
				} else {
					workStr = workStr.substring(1);
				}
			}
		}

		System.out.printf("Der Wert der Zahl %s ist %d\n", input, outNum);
	}

//	private int[] substraction(String s) {
//		switch(s.charAt(0)) {
//		case 'I':
//			
//		default:
//			int[] out = {0,0};
//			return out;
//		}
//	}

}
