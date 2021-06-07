package de.theo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Hashing {

	static class Figure {
		int num;
		int hash;

		public Figure() {
			Random r = new Random();
			num = r.nextInt(Integer.MAX_VALUE);
			hash = hash(num, 10000);
		}

		public int hashCode() {
//			return hash(num, Integer.MAX_VALUE);
//			return hash(num, 10000);
			return hash;
		}

		public String toString() {
			return String.format("num: %d -> hash: %d", this.num, this.hashCode());
		}
	}

	static int hash(int n, int m) {
		final int a = 256;
		int h = 0;
		String s = Integer.toString(n);
		for (int i = 0; i < s.length(); i++) {
			h = (h * a + s.charAt(i)) % m;
		}
		return h;
	}

	public static void main(String[] args) {

		Figure[] f = new Figure[100000];
		for (int i = 0; i < f.length; i++) {
			f[i] = new Figure();
		}
		System.out.println(Arrays.toString(f));

		for (int i = 0; i < f.length; i++) {
			for (int j = 1; j < f.length - i; j++) {
				if (f[j].hashCode() < f[j - 1].hashCode()) {
					Figure tmp = f[j - 1];
					f[j - 1] = f[j];
					f[j] = tmp;
				}
			}
		}

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		for (int i = 0; i < f.length; i++) {
			if (f[i] != null) {
				int tmphash = f[i].hashCode();
				if (map.containsKey(tmphash)) {
					if (!map.get(tmphash).contains(f[i].num)) {
						ArrayList<Integer> tmp = map.get(tmphash);
						tmp.add(f[i].num);
						map.put(tmphash, tmp);
					}
				} else {
					ArrayList<Integer> tmp = new ArrayList<>();
					tmp.add(f[i].num);
					map.put(tmphash, tmp);
				}
			}
		}

		int collisions = 0;

		for (ArrayList<Integer> l : map.values()) {
			if (l.size() > 1) collisions++;
		}

		System.out.println(Arrays.toString(f));
		System.out.println(map);
		System.out.println(collisions);
	}
}
