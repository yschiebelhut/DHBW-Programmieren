package coronawarn;

import java.awt.*;

/**
 * @author Matrikel-Nr. 3354235
 */
public enum WarnStatus {
	UNKNOWN("Unknown", new Color(175, 175, 175)),
	OK("Ok", new Color(100, 200, 100)),
	ALARM("Possible encounter", new Color(255, 100, 100)),
	INFECTED("In quarantine", new Color(150, 150, 255));

	private String text;
	private Color color;

	WarnStatus(String text, Color color) {
		this.text = text;
		this.color = color;
	}

	public String getText() {
		return text;
	}

	public Color getColor() {
		return color;
	}
}
