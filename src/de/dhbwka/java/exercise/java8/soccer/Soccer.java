package de.dhbwka.java.exercise.java8.soccer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author Yannik Schiebelhut
 */
public class Soccer {
	private static final ArrayList<Player> players = new ArrayList<>();

	public static void main(String[] args) {
		Path path = Paths.get("src/de/dhbwka/java/exercise/java8/soccer/33_Java8_Aufgaben_TeamDE.csv");
		try {
			Files.readAllLines(path).stream()
					.map(l -> l.split(";"))
					.filter(l -> l.length == 7)
					.map(Soccer::parsePlayer)
					.forEach(players::add);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Players sorted by number:");
		players.stream().sorted(Soccer::comparePlayerByNumber).forEach(System.out::println);
		System.out.println("-----");

		System.out.println("Players with more than 50 games, sorted by name:");
		players.stream()
				.filter(p -> p.getGames() > 50)
				.sorted(Soccer::comparePlayerByName)
				.forEach(System.out::println);
		System.out.println("-----");

		System.out.println("All clubs of the players:");
		players.stream()
				.map(Player::getClub)
				.distinct()
				.forEach(System.out::println);
		System.out.println("-----");

		System.out.print("Count of players with less than 5 goals: ");
		System.out.println(players.stream()
				.mapToInt(Player::getGoals)
				.filter(x -> x < 5)
				.count());
		System.out.print("Count of goals of all players: ");
		System.out.println(players.stream()
				.mapToInt(Player::getGoals)
				.sum());
	}

	private static Player parsePlayer(String[] l) {
		return new Player(Integer.parseInt(l[0]), l[1], l[2], l[3], l[4], Integer.parseInt(l[5]),
				Integer.parseInt(l[6]));
	}

	public static int comparePlayerByNumber(Player p1, Player p2) {
		return p1.getNumber() - p2.getNumber();
	}

	public static int comparePlayerByName(Player p1, Player p2) {
		return p1.getName().compareToIgnoreCase(p2.getName());
	}
}
