package de.theo.hashing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Hashing {

	private static int m;
	private static int n;

	static class Figure {
		private final int num;
		private final int hash;

		public Figure() {
			Random r = new Random();
			num = r.nextInt(Integer.MAX_VALUE);
			hash = hash(num, m);
		}

		public int getNum() {
			return num;
		}

		public int hashCode() {
			return hash;
		}

		public String toString() {
			return String.format("num: %d -> hash: %d", this.num, this.hashCode());
		}

		private int hash(int n, int m) {
			final int a = 256;
			int h = 0;
			String s = Integer.toString(n);
			for (int i = 0; i < s.length(); i++) {
				h = (h * a + s.charAt(i)) % m;
			}
			return h;
		}
	}

	private static float measure(int n, int m, int rounds) {
		int totalCollisions = 0;

		for (int run = 0; run < rounds; run++) {
			int collisions = 0;
			ArrayList<Integer>[] f = new ArrayList[m];
			for (int i = 0; i < n; i++) {
				Figure tmpf = new Figure();
				if (f[tmpf.hashCode()] == null) {
					f[tmpf.hashCode()] = new ArrayList<>();
					f[tmpf.hashCode()].add(tmpf.getNum());
				} else if (!f[tmpf.hashCode()].contains(tmpf.getNum())) {
					f[tmpf.hashCode()].add(tmpf.getNum());
					collisions++;
				}
			}

			totalCollisions += collisions;
		}
		return (float) totalCollisions / rounds;
	}

	public static void main(String[] args) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(new File("src/de/theo/hashing.csv")))) {
			char delimiter = ';';
			pw.println("a" + delimiter + "collisions" + delimiter + "n" + delimiter + "m");

			int repititions = 1000;
			m = 100 * 1000;
			float a = 0.0f;
			float bound = 3.5f;
			float diff = 0.05f;

			System.out.printf("Doing a measurement from 0.0 to %.2f with stepsize %.3f\n", bound, diff);
			System.out.printf("Size of hashmap: %d", m);
			while (a <= bound) {
				n = (int) (a * m);
				System.out.println("a: " + a);
				pw.printf("%.3f%c%f%c%d%c%d", a, delimiter, measure(n, m, repititions), delimiter, n, delimiter, m);
				a += diff;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

//			System.out.printf("n: %6d\nm: %6d\nalpha: %.3f\n", n, m, (float) n / m);
//			System.out.printf("collisions: %.5f\n\n", measure(n, m, 1000));
	}
}
