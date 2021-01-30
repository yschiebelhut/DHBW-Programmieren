package de.dhbwka.java.exercise.classes;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Radio {

	private boolean on;
	private int volume;
	private double frequency;

	public Radio() {
		this.on = false;
		this.volume = 3;
		this.frequency = 94.8;
	}

	public Radio(boolean on, int volume, double frequency) {
		this.on = on;
		this.volume = volume;
		this.frequency = frequency;
	}

	public void incVolume() {
		if (this.volume < 10) {
			this.volume++;
		}
	}

	public void decVolume() {
		if (this.volume > 0) {
			this.volume--;
		}
	}

	public void turnOn() {
		this.on = true;
	}

	public void turnOff() {
		this.on = false;
	}

	public void setFrequency(double frequency) {
		if (frequency >= 85.0 && frequency <= 110.0) {
			this.frequency = frequency;
		} else {
			this.frequency = 99.9;
		}
	}
	
	public String toString() {
		return "Radio " + (this.on ? "an" : "aus") + ": Freq=" + this.frequency + ", Vol=" + this.volume;
	}
	
	public static void main(String[] args) {
		Radio radio = new Radio(false, 7, 93.5);
		System.out.println(radio);
		radio.turnOn();
		System.out.println(radio);
		radio.incVolume();
		radio.incVolume();
		System.out.println(radio);
		radio.incVolume();
		radio.incVolume();
		System.out.println(radio);
		radio.decVolume();
		System.out.println(radio);
		radio.setFrequency(97.8);
		System.out.println(radio);
		radio.setFrequency(112.7);
		System.out.println(radio);
		radio.turnOff();
		System.out.println(radio);
	}

}