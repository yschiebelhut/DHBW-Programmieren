package de.dhbwka.java.exercise.ui.paint;

import java.awt.*;

/**
 * @author Yannik Schiebelhut
 */
public class Party {

	private float percentage;
	private Color color;

	public Party(float percentage, Color color) {
		this.percentage = percentage;
		this.color = color;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
