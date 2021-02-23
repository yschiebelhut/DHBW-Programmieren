/**
 * 
 */
package de.dhbwka.java.exercise.classes.periodic;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Metal extends Element {

	private boolean metalloid;
	private double conductivity;

	public Metal(String name, String symbol, int ordinal, char shell, int phase, boolean group, boolean metalloid,
			double conductivity) {
		super(name, symbol, ordinal, shell, phase, group);
		this.metalloid = metalloid;
		this.conductivity = conductivity;
	}

	public boolean isMetalloid() {
		return metalloid;
	}

	public void setMetalloid(boolean metalloid) {
		this.metalloid = metalloid;
	}

	public double getConductivity() {
		return conductivity;
	}

	public void setConductivity(double conductivity) {
		this.conductivity = conductivity;
	}

	@Override
	public String toString() {
		return "Metal [metalloid=" + metalloid + ", conductivity=" + conductivity + ", getName()=" + getName()
				+ ", getSymbol()=" + getSymbol() + ", getOrdinal()=" + getOrdinal() + ", getShell()=" + getShell()
				+ ", getPhase()=" + getPhase() + ", isGroup()=" + isGroup() + "]";
	}
	
	

}
