/**
 * 
 */
package de.dhbwka.java.exercise.ui;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Yannik Schiebelhut
 *
 */
public class TextfileViewer extends JFrame {

	public TextfileViewer() {
		JFileChooser fc = new JFileChooser();
		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(new File(fc.getSelectedFile().getAbsolutePath())));
				this.setTitle(fc.getSelectedFile().getName());
				JTextArea textarea = new JTextArea();
				while(br.ready()) {
					textarea.setText(textarea.getText() + br.readLine() + "\n");
				}
				this.add(textarea);
				
				JScrollPane scrollbar = new JScrollPane(textarea);
				this.add(scrollbar);
				this.setSize(500, 150);
				this.setVisible(true);
			} catch (Exception e) {
				System.out.println("error while reading file");
			}
		} else {
			System.out.println("no selection");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TextfileViewer();
	}

}
