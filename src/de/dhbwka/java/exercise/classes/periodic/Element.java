/**
 * 
 */
package de.dhbwka.java.exercise.classes.periodic;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Element {

	private String name;
	private String symbol;
	private int ordinal;
	private char shell;
	private int phase;
	private boolean group;

	public Element(String name, String symbol, int ordinal, char shell, int phase, boolean group) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.ordinal = ordinal;
		this.shell = shell;
		this.phase = phase;
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}

	public char getShell() {
		return shell;
	}

	public void setShell(char shell) {
		this.shell = shell;
	}

	public int getPhase() {
		return phase;
	}

	public void setPhase(int phase) {
		this.phase = phase;
	}

	public boolean isGroup() {
		return group;
	}

	public void setGroup(boolean group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Element [name=" + name + ", symbol=" + symbol + ", ordinal=" + ordinal + ", shell=" + shell + ", phase="
				+ phase + ", group=" + group + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Element) {
			Element o2 = (Element) o;
			return o2.getOrdinal() == this.ordinal;
		}
		return false;
	}

}
