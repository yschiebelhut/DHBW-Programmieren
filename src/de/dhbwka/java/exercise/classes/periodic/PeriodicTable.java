/**
 * 
 */
package de.dhbwka.java.exercise.classes.periodic;

import java.util.Arrays;

/**
 * @author Yannik Schiebelhut
 *
 */
public class PeriodicTable {
	private Element[] elements = new Element[118];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PeriodicTable p = new PeriodicTable();
		
		p.addElement(new Element("Wasserstoff", "H", 1, 'K', 3, true));
		p.addElement(new Element("Helium", "He", 2, 'k', 3, true));
		p.addElement(new Metal("Natrium", "Na", 11, 'M', 1, true, false, 21e6));
		p.addElement(new Metal("Eisen", "Fe", 26, 'N', 1, false, false, 10.02e6));
		p.addElement(new Metal("Germanium", "Ge", 32, 'N', 1, false, true, 1.45));
		p.addElement(new Element("Brom", "Br", 35, 'N', 2, true));
		p.addElement(new Metal("Tellur", "Te", 52, 'O', 1, true, true, 0.005));
		p.addElement(new Metal("Gold", "Au", 79, 'P', 1, false, false, 44.0e6));
		
		for (Element e:p.elements) {
			if(e!=null) {
				System.out.println(e);
			}
		}
		
		System.out.println();
		System.out.println(Arrays.toString(p.getMetals()));
		
		System.out.println();
		System.out.println(p.getElement(79));
	}

	public void addElement(Element e) {
		if (elements[e.getOrdinal() - 1] == null) {
			elements[e.getOrdinal() - 1] = e;
		}
	}

	public boolean hasElement(int o) {
		if (elements[o - 1] != null) {
			return true;
		}
		return false;
	}

	public Element getElement(int o) {
		return elements[o - 1];
	}

	public Element[] getMetals() {
		int anzMetalle = 0;
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] instanceof Metal) {
				anzMetalle++;
			}
		}

		Element[] out = new Element[anzMetalle];
		int index = 0;
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] instanceof Metal) {
				out[index++] = elements[i];
			}
		}

		return out;
	}

}
