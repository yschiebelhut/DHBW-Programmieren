package de.dhbwka.java.exercise.gson.race;

/**
 * @author Yannik Schiebelhut
 */
public class Fahrzeug {
	double position;
	double geschwindigkeit;
	double vmax;

	public Fahrzeug(double position, double geschwindigkeit, double vmax) {
		this.position = position;
		this.geschwindigkeit = geschwindigkeit;
		this.vmax = vmax;
	}
}
