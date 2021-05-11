/**
 * 
 */
package de.dhbwka.java.exercise.io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Files {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String basepath = "src/de/dhbwka/java/exercise/io/";
		File myDir = new File(basepath, "myDir");
//		System.out.println(myDir.getAbsolutePath());
		myDir.mkdir();

		File foo1 = new File(basepath, "myDir/foo1");
		File foo2 = new File(basepath, "myDir/foo2");
		File foo3 = new File(basepath, "myDir/foo3");

		try {
			foo1.createNewFile();
			foo2.createNewFile();
			foo3.createNewFile();
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}

		System.out.println(myDir.getAbsolutePath());
		System.out.println(Arrays.toString(myDir.list()));

		foo1.delete();
		foo2.delete();
		foo3.delete();
		myDir.delete();
	}

}
