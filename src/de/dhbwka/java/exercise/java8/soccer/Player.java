package de.dhbwka.java.exercise.java8.soccer;

/**
 * @author Yannik Schiebelhut
 */
public class Player {
	private final int number;
	private final String name;
	private final String position;
	private final String birthday;
	private final String club;
	private final int games;
	private final int goals;

	public Player(int number, String name, String position, String birthday, String club, int games, int goals) {
		this.number = number;
		this.name = name;
		this.position = position;
		this.birthday = birthday;
		this.club = club;
		this.games = games;
		this.goals = goals;
	}

	@Override
	public String toString() {
		return "Player{" +
				"number=" + number +
				", name='" + name + '\'' +
				", position='" + position + '\'' +
				", birthday='" + birthday + '\'' +
				", club='" + club + '\'' +
				", games=" + games +
				", goals=" + goals +
				'}';
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getClub() {
		return club;
	}

	public int getGames() {
		return games;
	}

	public int getGoals() {
		return goals;
	}
}
