package de.dhbwka.java.exercise.threads.buffer;

/**
 * @author Yannik Schiebelhut
 */
public class BufferTest {

	public static void main(String[] args) {
		MyBuffer buf = new MyBuffer();

		ProducerThread t1 = new ProducerThread(buf);
		t1.start();

		ConsumerThread t2 = new ConsumerThread(buf);
		t2.start();
	}
}
