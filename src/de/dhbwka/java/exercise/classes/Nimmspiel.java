/**
 * 
 */
package de.dhbwka.java.exercise.classes;

import java.util.Random;

import de.schiebelhut.misc.InputHelper;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Nimmspiel {
	private class Player {
		private String name;

		public Player(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}
	}

	private class Haufen {
		private int kugeln;

		public Haufen(int kugeln) {
			this.kugeln = kugeln;
		}

		public int getAnzKugeln() {
			return this.kugeln;
		}

		public void nehmeKugeln(int anz) throws Exception {
			if (anz <= this.kugeln) {
				this.kugeln -= anz;
			} else {
				throw new Exception("NotEnoughKugeln");
			}
		}
	}

	private Player playerA, playerB, currentPlayer;
	private Haufen haufen1, haufen2;

	public Nimmspiel(String namePlayerA, String namePlayerB, int maxKugeln) {
		this.playerA = new Player(namePlayerA);
		this.playerB = new Player(namePlayerB);
		this.currentPlayer = this.playerA;

		Random rand = new Random();
		haufen1 = new Haufen(rand.nextInt(maxKugeln) + 1);
		haufen2 = new Haufen(rand.nextInt(maxKugeln) + 1);
		
		this.spielen();
	}

	@Override
	public String toString() {
		return String.format("Spieler %s und %s, Haufen 1: %d Kugel(n), Haufen 2: %d Kugel(n)", this.playerA.getName(),
				this.playerB.getName(), this.haufen1.getAnzKugeln(), this.haufen2.getAnzKugeln());
	}

	public boolean haufenAreEmpty() {
		return this.haufen1.getAnzKugeln() == 0 && this.haufen2.getAnzKugeln() == 0;
	}

	public void spielen() {
		System.out.println(this);
		Haufen selectedHaufen;
		do {
			System.out.printf("Spieler %s: Von welchem Haufen ziehen Sie Kugeln? ", currentPlayer.getName());
			switch (InputHelper.getIntegerInput()) {
			case 1:
				selectedHaufen = haufen1;
				break;
			case 2:
				selectedHaufen = haufen2;
				break;
			default:
				selectedHaufen = null;
			}

			if (selectedHaufen == null) {
				System.out.println("Dies ist kein gültiger Haufen!");
			} else if (selectedHaufen.getAnzKugeln() == 0) {
				System.out.println(
						"Auf dem gewählten Haufen liegen keine Kugeln, weshalb kein gültiger Zug möglich wäre.");
			}
		} while (selectedHaufen == null || selectedHaufen.getAnzKugeln() == 0);

		int anzKugeln = 0;
		do {
			System.out.printf("Spieler %s: Wie viele Kugeln ziehen Sie? ", currentPlayer.getName());
			anzKugeln = InputHelper.getIntegerInput();
			if (anzKugeln > selectedHaufen.getAnzKugeln()) {
				System.out.println("Auf dem gewählten Haufen liegen nicht genügend Kugeln");
				anzKugeln = 0;
			}
		} while (anzKugeln == 0);

		try {
			selectedHaufen.nehmeKugeln(anzKugeln);
		} catch (Exception e) {
			System.out.println("Auf dem gewählten Haufen lagen nicht genug Kugeln!");
			System.exit(1);
		}

		if (this.haufenAreEmpty()) {
			System.out.printf("Spiel beendet.\nGewonnen hat Spieler %s!", currentPlayer.getName());
		} else {
			if (currentPlayer == playerA)
				currentPlayer = playerB;
			else
				currentPlayer = playerA;
			this.spielen();
		}
	}

	public static void main(String[] args) {
		Nimmspiel spiel = new Nimmspiel("Peter", "Silie", 25);
	}
}
