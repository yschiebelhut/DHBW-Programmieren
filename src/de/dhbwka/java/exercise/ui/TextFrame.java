/**
 * 
 */
package de.dhbwka.java.exercise.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * @author Yannik Schiebelhut
 *
 */
public class TextFrame extends JFrame {

	public TextFrame(String filename, int width, int height) {
		try {
			File f = new File(filename);
			this.setTitle(f.getName());
			System.out.println(f.getName());
			System.out.println(f.getAbsolutePath());
			System.out.println(f.exists());

			JTextArea textarea = new JTextArea();

			BufferedReader br = new BufferedReader(new FileReader(f));
			while (br.ready()) {
				textarea.setText(textarea.getText() + br.readLine() + "\n");
			}

			this.add(textarea);
			this.setSize(width, height);
			this.setVisible(true);
		} catch (Exception e) {
			System.out.println("error");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TextFrame("src/de/dhbwka/java/exercise/ui/textfile.txt", 700, 500);
	}

}
