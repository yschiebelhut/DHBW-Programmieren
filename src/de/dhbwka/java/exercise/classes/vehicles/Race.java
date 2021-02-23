/**
 * 
 */
package de.dhbwka.java.exercise.classes.vehicles;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Race {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vehicle[] vehicles = new Vehicle[4];
		vehicles[0] = new Bicycle(0, 20);
		vehicles[1] = new Car(0, 150);
		vehicles[2] = new RacingCar(0, 200);
		vehicles[3] = new Ambulance(0, 80, true);

		// vier Stunden Vorsprung für Fahrrad
		vehicles[0].drive(240);

		// alle fahren eine Stunde
		for (int i = 0; i < vehicles.length; i++) {
			vehicles[i].drive(60);
		}

		// output
		for (int i = 0; i < vehicles.length; i++) {
			System.out.println(vehicles[i].toString());
		}

	}

}
