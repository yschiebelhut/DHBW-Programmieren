package de.dhbwka.java.exercise.threads;

import javax.swing.*;
import java.awt.*;

/**
 * @author Yannik Schiebelhut
 */
public class DancingText extends JFrame implements Runnable {

	private String text = "Dancing Text :-)";

	public DancingText() {
		this.setTitle("Dancing Text");
		this.setLayout(new GridLayout(1, text.length(), 5, 5));

		Letter[] letters = new Letter[text.length()];
		for (int i = 0; i < text.length(); i++) {
			letters[i] = new Letter(String.valueOf(text.charAt(i)));
			this.add(letters[i]);
			letters[i].run();
		}

		this.setSize(text.length()*20,100);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void run() {
		this.repaint();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DancingText dt = new DancingText();
		dt.run();
	}
}
