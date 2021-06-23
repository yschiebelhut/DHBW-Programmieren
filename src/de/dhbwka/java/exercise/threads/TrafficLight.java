package de.dhbwka.java.exercise.threads;

import javax.swing.*;
import java.awt.*;

/**
 * @author Yannik Schiebelhut
 */
public class TrafficLight extends JFrame implements Runnable {

	private LightPhase phase = LightPhase.RED;

	public TrafficLight() {
//		this.setTitle
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("Traffic Light");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		TrafficLight t = new TrafficLight();
		f.add(t);

		f.setSize(120, 330);
		f.setVisible(true);

	}

	protected void paintComponent(Graphics g) {
		if (phase == LightPhase.RED || phase == LightPhase.RED_YELLOW) {
			g.setColor(Color.RED);
			g.fillOval(60, 60, 50, 50);
		}
		if (phase == LightPhase.YELLOW || phase == LightPhase.RED_YELLOW) {
			g.setColor(Color.YELLOW);
			g.fillOval(60, 165, 50, 50);
		}
		if (phase == LightPhase.GREEN) {
			g.setColor(Color.GREEN);
			g.fillOval(60, 270, 50, 50);
		}
	}

	@Override
	public void run() {
		while (true) {
			this.repaint();
			phase = LightPhase.values()[(phase.ordinal()+1)%4];

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
