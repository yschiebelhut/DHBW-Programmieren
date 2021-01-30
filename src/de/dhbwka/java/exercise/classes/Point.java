package de.dhbwka.java.exercise.classes;

/**
 * @author Yannik Schiebelhut
 *
 */
public class Point {

	private double x, y;

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String toString() {
		return String.format("X: %f Y %f", x, y);
	}

	public double distanceToOrigin() {
		return Math.sqrt((Math.pow(this.x, 2) + Math.pow(this.y, 2)));
	}

	public Point mirrorOnX() {
		return new Point(this.x, this.y * -1);
	}

	public Point mirrorOnY() {
		return new Point(this.x * -1, this.y);
	}

	public Point mirrorOnOrigin() {
		return new Point(this.x * -1, this.y * -1);
	}

	public double distanceToPoint(Point p) {
		return Math.sqrt(Math.pow((this.x - p.getX()), 2) + Math.pow((this.y - p.getY()), 2));
	}

	public static void main(String[] args) {
		Point pointA = new Point(4.0, 2.0);
		System.out.println("A: " + pointA);
		Point pointB = new Point(-1.0, -1.0);
		System.out.println("B: " + pointB);
		System.out.println("AbstandA-B: " + pointA.distanceToPoint(pointB));
		pointA = pointA.mirrorOnOrigin();
		System.out.println("A': " + pointA);
		System.out.println("AbstandA’-B: " + pointA.distanceToPoint(pointB));

	}

}
