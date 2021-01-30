package de.dhbwka.java.exercise.classes;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Account {

	private int kontonr;
	private String name;
	private double kontostand, limit;

	public Account(int kontonr, String name, double limit) {
		super();
		this.kontonr = kontonr;
		this.name = name;
		this.kontostand = 0;
		this.limit = limit;
	}

	public Account(int kontonr, String name) {
		super();
		this.kontonr = kontonr;
		this.name = name;
		this.kontostand = 0;
		this.limit = 0;
	}
	
	

	public void einzahlen(double betrag) {
		if (betrag >= 0) {
			kontostand += betrag;
		}
	}

	public double auszahlen(double betrag) {
		if (betrag >= 0) {
			if (betrag <= kontostand - limit) {
				kontostand -= betrag;
				return betrag;
			} else {
				double out = kontostand - limit;
				kontostand = limit;
				System.out.println("Kontostand nicht ausreichend. Zahle nur " + out + " aus.");
				return out;
			}
		}
		return 0;
	}

	public double getKontostand() {
		return this.kontostand;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	public String toString() {
		return String.format("Kontonr: %d, Inhaber: %s, Saldo: %f, Limit: %f", this.kontonr, this.name, this.kontostand,
				this.limit);
	}

	public static void main(String[] args) {
		Account account = new Account(4711, "Donald Duck", -1000);
		System.out.println(account);
		account.einzahlen(500);
		System.out.println(account);
		account.einzahlen(200);
		System.out.println(account);
		account.auszahlen(400);
		System.out.println(account);
		account.auszahlen(2000);
		System.out.println(account);
		

	}

}
