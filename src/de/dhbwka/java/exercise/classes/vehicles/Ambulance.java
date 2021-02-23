/**
 * 
 */
package de.dhbwka.java.exercise.classes.vehicles;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Ambulance extends Car {
	
	private boolean blaulicht;
	
	public Ambulance(double pos) {
		super(pos);
		this.blaulicht=false;
	}
	
	public Ambulance (double pos, boolean blaulicht) {
		super(pos);
		this.blaulicht=blaulicht;
	}

	public Ambulance (double pos, double speed, boolean blaulicht) {
		super(pos, speed);
		this.blaulicht=blaulicht;
	}

	public boolean istBlaulichtAn() {
		return blaulicht;
	}

	public void blaulichtAn() {
		this.blaulicht = true;
	}
	
	public void blaulichtAus() {
		this.blaulicht = false;
	}
	
	@Override
	public String toString() {
		String out = super.toString();
		out += ", Blaulicht: " + (this.blaulicht ? "an" : "aus");
		return out;
	}
	
}
