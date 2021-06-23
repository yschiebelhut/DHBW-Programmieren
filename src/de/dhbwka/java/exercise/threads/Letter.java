package de.dhbwka.java.exercise.threads;

import javax.swing.*;
import java.awt.*;

/**
 * @author Yannik Schiebelhut
 */
public class Letter extends JPanel implements Runnable {
	
	private JLabel label;
	
	public Letter(String letter) {
		super();
		label = new JLabel(letter);
		this.add(label);
	}
	
	@Override
	public void run() {
		Color previous = label.getForeground();
		Color next = new Color((int)(previous.getRed() * 0.5), (int) (previous.getGreen() * 0.5), (int) (previous.getBlue() * 0.5));
		label.setForeground(next);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
