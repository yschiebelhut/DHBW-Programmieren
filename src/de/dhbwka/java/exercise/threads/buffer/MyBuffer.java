package de.dhbwka.java.exercise.threads.buffer;

import java.util.LinkedList;

/**
 * @author Yannik Schiebelhut
 */
public class MyBuffer {

	private final int MAXSIZE = 3;
	private LinkedList<Integer> values = new LinkedList<>();

	public synchronized void put(int v) {
		if (this.values.size() >= this.MAXSIZE) {
			try {
				System.out.println("Puffer voll - warten!");
				this.wait();
			} catch (InterruptedException e) {
			}
		}

		this.values.add(v);
		this.notify();
		System.out.println("Put: " + v);
		System.out.println("Fill level after put: " + values.size());
	}

	public synchronized int get() {
		int v;
		if (this.values.isEmpty()) {
			try {
				System.out.println("Puffer leer - warten!");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		v = this.values.get(0);
		this.values.remove(0);
		this.notify();
		System.out.println("Get: " + v);
		System.out.println("Fill level after get: " + values.size());
		return v;
	}
}
