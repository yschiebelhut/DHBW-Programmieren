package de.theo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Turm {

	public static void main(String[] args) {
		ArrayList<Integer>[] bar = new ArrayList[3];
		for (int i = 0; i < bar.length; i++) {
			bar[i] = new ArrayList<Integer>();
		}

		int count = 5;
		
		for (int i = 1; i <= count; i++) {
			bar[1].add(i);
		}
		
		output(bar);

		destroy(bar, count, 1, 0, 2);

		output(bar);
	}

	public static void output(ArrayList[] pArr) {
		System.out.println("A: " + pArr[0]);
		System.out.println("B: " + pArr[1]);
		System.out.println("C: " + pArr[2]);
	}

	public static void destroy(ArrayList[] pArr, int amount, int from, int to, int buffer) {
		System.out.println("----------------------");
		output(pArr);
		System.out.println("amout: " + amount);
		System.out.println("from: " + from);
		System.out.println("to: " + to);
		System.out.println("buffer: " + buffer);
		System.out.println("----------------------");
		System.out.println();
		System.out.println();
		if (amount == 1) {
			pArr[to].add(0, pArr[from].get(0));
			pArr[from].remove(0);
		} else {
			destroy(pArr, amount - 1, from, buffer, to);
			
			pArr[to].add(0, pArr[from].get(0));
			pArr[from].remove(0);
			
			destroy(pArr, amount - 1, buffer, to, from);
		}
	}

}
