/**
 * 
 */
package de.dhbwka.java.exercise.classes.vehicles;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Bicycle extends Vehicle {
	
	public Bicycle (double pos) {
		super(2,30.0,pos);
	}
	
	public Bicycle (double pos, double speed) {
		super(2,30.0,pos,speed);
	}

}
