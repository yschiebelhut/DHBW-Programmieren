/**
 * 
 */
package de.dhbwka.java.exercise.classes.vehicles;

/**
 * @author Yannik Schiebelhut
 *
 */
public class RacingCar extends Car {

	public RacingCar(double pos) {
		super(pos);
		this.vmax = 220;
	}

	public RacingCar(double pos, double speed) {
		super(pos);
		this.vmax = 220;
		this.setSpeed(speed);
	}
}
