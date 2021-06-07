package de.dhbwka.java.exercise.ui.paint;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Election extends JFrame {

	private final HashMap<String, Party> data = new HashMap<>();

	public Election() {
		this.setTitle("Wahl");

		data.put("CDU", new Party(33.0f, Color.BLACK));
		data.put("SPD", new Party(20.5f, Color.RED));
		data.put("AfD", new Party(12.6f, Color.BLUE));
		data.put("FDP", new Party(10.7f, Color.YELLOW));
		data.put("Linke", new Party(9.2f, Color.PINK));
		data.put("Grüne", new Party(8.9f, Color.GREEN));
		data.put("Andere", new Party(5.1f, Color.DARK_GRAY));

		this.add(new Plot());

		this.setSize(600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class Plot extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			int width = this.getWidth();
			int height = this.getHeight();
			int partyCount = data.size();
			System.out.println(partyCount);
			int delimiter = 10;
			int hspace = width - 2 * delimiter;
			int barWidth = (hspace - (partyCount - 1) * delimiter) / partyCount;
			System.out.println("Delimiter: " + delimiter);
			System.out.println("hspace: " + hspace);
			System.out.println("barWidth: " + barWidth);
			System.out.println("im here, some data: " + width);

			g.drawLine(0, 0, width, height);
		}
	}

	public static void main(String[] args) {
		new Election();
	}
}
