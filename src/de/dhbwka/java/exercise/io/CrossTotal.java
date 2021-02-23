/**
 * 
 */
package de.dhbwka.java.exercise.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
		for (int i = 0; i < num.length(); i++) {
			crosstotal += Integer.parseInt(num.substring(i, i + 1));
		}

		String output = String.format("Die Quersumme von %s ist %d", num, crosstotal);
		System.out.println(output);

		File out = new File("src/de/dhbwka/java/exercise/io/crosstotal.txt");
		while (!out.exists()) {
			try {
				out.createNewFile();
			} catch (IOException e1) {
				System.out.println("file could not be created");
				System.out.println(e1.getMessage());
			}
		}

		try {
			FileWriter writer = new FileWriter(out, true);
			writer.write(output + System.lineSeparator());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
