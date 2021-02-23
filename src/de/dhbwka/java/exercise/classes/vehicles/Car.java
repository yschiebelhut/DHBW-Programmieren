/**
 * 
 */
package de.dhbwka.java.exercise.classes.vehicles;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Car extends Vehicle {
	
	public Car (double pos) {
		super(4,140.0,pos);
	}
	
	public Car (double pos, double speed) {
		super(4,140.0,pos,speed);
	}


}
