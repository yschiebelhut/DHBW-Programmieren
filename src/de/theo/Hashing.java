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

//		quickSort(f);
//		for (int i = 0; i < f.length; i++) {
//			for (int j = 1; j < f.length - i; j++) {
//				if (f[j].hashCode() < f[j - 1].hashCode()) {
//					Figure tmp = f[j - 1];
//					f[j - 1] = f[j];
//					f[j] = tmp;
//				}
//			}
//		}

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

//		System.out.println(Arrays.toString(f));
		System.out.println(map);
		System.out.println(collisions);
	}

//	public static Figure[] quickSort(Figure[] pArr) {
//		quickSort(pArr, 0, pArr.length);
//		return pArr;
//	}
//
//	public static void quickSort(Figure[] pArr, int low, int high) {
//		if ((high - low) <= 1) // when there is only one element, it's already sorted
//			return;
//		int pivot = pArr[high - 1].hashCode(); // set the pivot to the value of the last index in the range, given by the
//		// parameters
//		int split = low; // set the splitting point to the very first index; variable used to mark the
//		// end of the section containing elements smaller than the pivot
//
//		for (int i = low; i < high - 1; i++) { // rush through each element in the given range
//			// if the current element is smaller than the pivot element, swap it to the end
//			// of the splitting area and increase the latter by one
//			if (pArr[i].hashCode() < pivot) {
//				Figure tmp = pArr[i];
//				pArr[i] = pArr[split];
//				pArr[split] = tmp;
//				split++;
//			}
//		}
//
//		// swap the pivot element to the end of the section of smaller elements than the
//		// pivot
//		Figure tmp = pArr[split];
//		pArr[split] = pArr[high - 1];
//		pArr[high - 1] = tmp;
//
//		// recursion
//		quickSort(pArr, low, split); // call the quick sort on the elements before the pivot
//		quickSort(pArr, ++split, high); // call the quick sort on the elements behind the pivot
//	}
}
