package de.dhbwka.java.exercise.ui.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Scribble extends JFrame implements MouseListener, MouseMotionListener {
	private int lastX, lastY;
	Graphics g;
	Color c;
	Color[] opts = {Color.BLACK, Color.BLUE, Color.RED};
	JComboBox<Color> box = new JComboBox<>(opts);

	public Scribble() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		this.add(box, BorderLayout.NORTH);

		this.setSize(300, 300);
		this.setVisible(true);

		this.g = this.getGraphics();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.lastX = e.getX();
		this.lastY = e.getY();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		this.g.setColor((Color) box.getSelectedItem());
		this.g.drawLine(this.lastX, this.lastY, x, y);
		this.lastX = x;
		this.lastY = y;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	public static void main(String[] args) {
		new Scribble();
	}
}
