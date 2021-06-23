package de.dhbwka.java.exercise.threads.buffer;

import java.util.Random;

/**
 * @author Yannik Schiebelhut
 */
public class ConsumerThread extends Thread {
	MyBuffer buf;

	public ConsumerThread(MyBuffer b) {
		this.buf = b;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			this.buf.get();
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
