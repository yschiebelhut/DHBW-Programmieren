package de.dhbwka.java.exercise.gson.race;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

/**
 * @author Yannik Schiebelhut
 */
public class Wettrennen {
	ArrayList<Fahrzeug> fz = new ArrayList<>();

	public Wettrennen() {
		fz.add(new Fahrzeug(80.0, 20.0, 30.0));
		fz.add(new Fahrzeug(0.0, 140.0, 140.0));
		fz.add(new Fahrzeug(0.0, 200.0, 220.0));
		fz.add(new Einsatzfahrzeug(0.0, 80.0, 140.0, false));
	}

	public static void main(String[] args) {
		String wettrennen = new GsonBuilder().setPrettyPrinting().create().toJson(new Wettrennen());
		System.out.println(wettrennen);
	}
}
