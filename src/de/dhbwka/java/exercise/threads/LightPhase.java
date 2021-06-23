package de.dhbwka.java.exercise.threads;

/**
 * @author Yannik Schiebelhut
 */
public enum LightPhase {

	RED(true, false,false),
	RED_YELLOW(true, true, false),
	GREEN(false,false,true),
	YELLOW(false,true,false);

	private boolean red;
	private boolean yellow;
	private boolean green;

	LightPhase(boolean red, boolean yellow, boolean green) {
		this.red = red;
		this.yellow = yellow;
		this.green = green;
	}

}
