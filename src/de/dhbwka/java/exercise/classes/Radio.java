package de.dhbwka.java.exercise.classes;

/**
 * A simple class to practice both basic object orientation and documentation in
 * Java.
 * 
 * @author Yannik Schiebelhut
 *
 */
public class Radio {
	
	/**
	 * Minimum frequency allowed to set
	 */
	private final double lowFreq = 85.0;
	
	/**
	 * Maximum frequency allowed to set
	 */
	private final double highFreq = 110.0;


	/**
	 * The current power state of the Radio
	 */
	private boolean on;
	
	/**
	 * The current volume of the Radio
	 */
	private int volume;
	
	/**
	 * The current station the Radio is set to
	 */
	private double frequency;

	/**
	 * Constructs a new Radio with default values.
	 */
	public Radio() {
		this.on = false;
		this.volume = 3;
		this.frequency = 94.8;
	}

	/**
	 * Constructs a new Radio with given parameters.
	 * 
	 * @param on initial power state of the Radio
	 * @param volume initial volume of the Radio
	 * @param frequency initial station of the Radio
	 */
	public Radio(boolean on, int volume, double frequency) {
		this.on = on;
		this.volume = volume;
		this.frequency = frequency;
	}

	/**
	 * Method to increase the volume of the Radio. Makes sure that the volume never exceeds the maximum threshold.
	 */
	public void incVolume() {
		if (this.volume < 10) {
			this.volume++;
		}
	}

	/**
	 * Method to decrease the volume of the Radio. Makes sure that the volume never exceeds the minimum threshold.
	 */
	public void decVolume() {
		if (this.volume > 0) {
			this.volume--;
		}
	}

	/**
	 * Sets the power state of the Radio to on.
	 */
	public void turnOn() {
		this.on = true;
	}

	/**
	 * Sets the power state of the Radio to off.
	 */
	public void turnOff() {
		this.on = false;
	}

	/**
	 * Change the station of the Radio. (Only if in valid range {@value Radio#lowFreq} - {@value Radio#highFreq})
	 * 
	 * @param frequency new frequency to set
	 */
	public void setFrequency(double frequency) {
		if (frequency >= lowFreq && frequency <= highFreq) {
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