package de.dhbwka.java.exercise.classes.wechselspiel;

import java.util.Random;

/**
 * @author Yannik Schiebelhut
 */
public class Board {

	private int width = 9;
	private int height = 9;
	private int numColors = 7;
	private int[][] fields;

	public Board() {
		init();
	}

	public Board(int width, int height, int numColors) {
		this.width = width;
		this.height = height;
		this.numColors = numColors;

		init();
	}

	private void init() {
		fields = new int[width][height];
		Random rand = new Random();
		for (int i = 0; i < fields.length; i++) {
			for (int j = 0; j < fields[i].length; j++) {
				boolean inserted;
				do {
					inserted = true;
					int newColor = rand.nextInt(numColors);
					if (j >= 2) {
						if (fields[i][j - 1] == newColor && fields[i][j - 2] == newColor) {
							inserted = false;
						}
					}
					if (i >= 2) {
						if (fields[i - 1][j] == newColor && fields[i - 1][j] == newColor) {
							inserted = false;
						}
					}
					if (inserted) {
						fields[i][j] = newColor;
					}
				} while (!inserted);
			}
		}
	}

	public int[][] getFields() {
		return fields;
	}
}
