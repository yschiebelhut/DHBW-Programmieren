package de.dhbwka.java.exercise.gson.cities;

/**
 * @author Yannik Schiebelhut
 */
public class City {
	String fcodeName, toponymName, countrycode, fcl, fclName, name, wikipedia, fcode;
	double lng, lat;
	int geonameId, population;

	public City(String fcodeName, String toponymName, String countrycode, String fcl, String fclName, String name,
				String wikipedia, String fcode, double lng, double lat, int geonameId, int population) {
		this.fcodeName = fcodeName;
		this.toponymName = toponymName;
		this.countrycode = countrycode;
		this.fcl = fcl;
		this.fclName = fclName;
		this.name = name;
		this.wikipedia = wikipedia;
		this.fcode = fcode;
		this.lng = lng;
		this.lat = lat;
		this.geonameId = geonameId;
		this.population = population;
	}

	@Override
	public String toString() {
		return "City{" +
				"fcodeName='" + fcodeName + '\'' +
				", toponymName='" + toponymName + '\'' +
				", countrycode='" + countrycode + '\'' +
				", fcl='" + fcl + '\'' +
				", fclName='" + fclName + '\'' +
				", name='" + name + '\'' +
				", wikipedia='" + wikipedia + '\'' +
				", lng='" + lng + '\'' +
				", fcode='" + fcode + '\'' +
				", geonameId='" + geonameId + '\'' +
				", lat='" + lat + '\'' +
				", population='" + population + '\'' +
				'}';
	}
}
