package de.dhbwka.java.exercise.gson.race;

/**
 * @author Yannik Schiebelhut
 */
public class Einsatzfahrzeug extends Fahrzeug {
	boolean blaulicht;

	public Einsatzfahrzeug(double position, double geschwindigkeit, double vmax, boolean blaulicht) {
		super(position, geschwindigkeit, vmax);
		this.blaulicht = blaulicht;
	}
}
