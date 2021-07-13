package de.dhbwka.java.exercise.gson.cities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Yannik Schiebelhut
 */
public class Cities {
	ArrayList<City> geonames;

	public static void main(String[] args) throws MalformedURLException {
		URL src = new URL("https://www.iai.kit.edu/javavl/data/static/cities.json");
		try (Reader reader = new InputStreamReader(src.openConnection().getInputStream())) {
			Cities results = new Gson().fromJson(reader, Cities.class);

			System.out.println("prior sorting:");
			System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(results));

			results.geonames.sort(Comparator.comparingInt(o -> o.population));

			System.out.println();
			System.out.println("===========================");
			System.out.println("after sorting:");
			System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(results));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
