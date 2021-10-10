package de.dhbwka.java.exercise.classes.vehicles.interfaces;

/**
 * @author Yannik Schiebelhut
 */
public class Bicycle implements Vehicle {
	private int wheels = 2;
	private double vmax = 30;
	private double speed = 0;
	private double position = 0;

	@Override
	public void setSpeed(double speed) {
		if (speed >= 0) {
			this.speed = speed;
		}
		if (this.speed > this.vmax) {
			this.speed = this.vmax;
		}
	}

	@Override
	public void drive(double minutes) {
		if (minutes > 0) {
			this.position = (minutes / 60) * this.speed;
		}
	}

	@Override
	public String toString() {
		return "Bicycle{" +
				"wheels=" + wheels +
				", vmax=" + vmax +
				", speed=" + speed +
				", position=" + position +
				'}';
	}

	public static void main(String[] args) {
		Bicycle b = new Bicycle();
		b.setSpeed(20);
		b.drive(30);
		System.out.println(b);
	}
}
