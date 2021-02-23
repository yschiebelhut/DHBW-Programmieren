/**
 * 
 */
package de.dhbwka.java.exercise.classes.vehicles;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Vehicle {

	private int anzRaeder = 0;
	protected double vmax = 0;
	private double pos;
	private double speed;

	public Vehicle(int anzRaeder, double vmax, double pos) {
		this.anzRaeder = anzRaeder;
		this.vmax = vmax;
		this.pos = pos;
	}

	public Vehicle(int anzRaeder, double vmax, double pos, double speed) {
		this.anzRaeder = anzRaeder;
		this.vmax = vmax;
		this.pos = pos;
		this.setSpeed(speed);
	}

	public void setSpeed(double speed) {
		if (speed <= this.vmax && speed >= 0) {
			this.speed = speed;
		} else if (speed > this.vmax) {
			this.speed = this.vmax;
		}
	}

	public double getSpeed() {
		return this.speed;
	}

	public double getVmax() {
		return this.vmax;
	}

	public double getPos() {
		return this.pos;
	}

	public int getAnzRaeder() {
		return this.anzRaeder;
	}

	public void drive(double minutes) {
		if (minutes > 0 && this.speed > 0) {
			pos += minutes / 60 * this.speed;
		}
	}

	public String toString() {
		return String.format("%s: AnzRäder: %d, Vmax: %5.2f, Pos: %5.2fkm, Speed: %5.2f",
				this.getClass().getSimpleName(), this.anzRaeder, this.vmax, this.pos, this.speed);
	}

}
