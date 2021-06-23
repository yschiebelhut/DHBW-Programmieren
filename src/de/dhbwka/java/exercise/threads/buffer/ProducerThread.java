package de.dhbwka.java.exercise.threads.buffer;

import java.util.Random;

/**
 * @author Yannik Schiebelhut
 */
public class ProducerThread extends Thread {
	MyBuffer buf;

	public ProducerThread(MyBuffer b) {
		this.buf = b;
	}
	public void run() {
//		this.buf.put(5);
//		this.buf.put(6);
		for (int i = 0; i < 10; i++) {
			this.buf.put(i);
			randomWait();
		}
	}

	public void randomWait() {
		Random r = new Random();
		try {
			Thread.sleep(r.nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
