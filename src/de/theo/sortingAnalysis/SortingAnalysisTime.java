package de.theo.sortingAnalysis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Random;

/**
 * @author Yannik Schiebelhut
 */
public class SortingAnalysisTime {

	private static Integer[] a;

	public static void genRandomArray(Integer length) {
		int range = 9;
		Random r = new Random();
		a = new Integer[length];
		for (int i = 0; i < length; i++) {
			a[i] = r.nextInt((int) Math.pow(10, range));
		}
	}

	public static void genSortedArray(Integer length) {
		a = new Integer[length];
		for (int i = 0; i < length; i++) {
			a[i] = i;
		}
	}

	public static void genInverseArray(Integer length) {
		a = new Integer[length];
		for (int i = 0; i < length; i++) {
			a[i] = length - i;
		}
	}

	/**
	 * Verifies the given array is sorted in ascending order.
	 *
	 * @param a array to check
	 * @return true if array is correctly sorted otherwise false
	 */
	public static boolean verify(Integer[] a) {
		if (a == null) return false;
		if (a.length == 1) return true;
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1] > a[i]) return false;
		}
		return true;
	}

	/**
	 * Verifies if the elements in both given arrays match. In case this applies, order of candidate is checked with
	 * verify method.
	 *
	 * @param reference reference array to match elements against
	 * @param candidate array to check
	 * @return true if array content matches and is correctly sorted
	 */
	public static boolean verifyWithReference(Integer[] reference, Integer[] candidate) {
		if (reference.length != candidate.length) return false;

		HashMap<Integer, Integer> countReference = new HashMap<>();
		for (Integer x : reference) {
			countReference.put(x, countReference.getOrDefault(x, 0) + 1);
		}
		HashMap<Integer, Integer> countCandidate = new HashMap<>();
		for (Integer x : candidate) {
			countCandidate.put(x, countCandidate.getOrDefault(x, 0) + 1);
		}
		for (Integer x : countReference.keySet()) {
			if (!countCandidate.containsKey(x) || !countReference.get(x).equals(countCandidate.get(x))) return false;
		}

		return verify(candidate);
	}

	public static void quickSort(Integer[] a, Integer low, Integer high) {
		if (high - low <= 0) return;

		int pivotIndex = low + (high - low) / 2;
		int pivot = a[pivotIndex];
		int split = low;
		for (int i = low; i <= high; i++) {
			if (i != pivotIndex) {
				if (a[i] < pivot) {
					int tmp = a[split];
					a[split] = a[i];
					a[i] = tmp;
					if (split == pivotIndex) pivotIndex = i;
					split++;
				}
			}
		}
		a[pivotIndex] = a[split];
		a[split] = pivot;

		quickSort(a, low, split - 1);
		quickSort(a, split + 1, high);
	}

	public static void quickSort(Integer[] a) {
		quickSort(a, 0, a.length - 1);
	}

	public static void measure(int cycles, int numElements) {
//		genRandomArray(numElements);
//		genSortedArray(numElements);
		genInverseArray(numElements);
		quickSort(a);

		String csv = "src/de/theo/sortingAnalysis/time-result.csv";
		try (PrintWriter p = new PrintWriter(new FileWriter(new File(csv), true))) {
//			p.println("Algorithm;Sample Size;Number Elements;avg Time(ms);avg Time(ns)");

			p.print("quicksort middle pivot;");
			p.print(cycles);
			p.print(";");
			p.print(numElements);
			p.print(";");

			Duration[] durations = new Duration[cycles];
			for (int i = 0; i < cycles; i++) {
				genRandomArray(numElements);
//				genSortedArray(numElements);
//				genInverseArray(numElements);
				Instant start = Instant.now();
				quickSort(a);
				Instant stop = Instant.now();
				durations[i] = Duration.between(start, stop);
			}

			long sumMillis = 0L;
			long sumNanos = 0L;
			for (int i = 0; i < cycles; i++) {
				sumMillis += durations[i].toMillis();
				sumNanos += durations[i].toNanos();
			}
			p.print((float) sumMillis / cycles);
			p.print(";");
			p.print((float) sumNanos / cycles);

			p.println();
			p.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		measure(1 * 1000 * 1000, 1000);
		measure(10 * 1000, 10 * 1000);
		measure(10 * 1000, 20 * 1000);
		measure(1000, 30 * 1000);
		measure(1000, 40 * 1000);
		measure(1000, 50 * 1000);
		measure(1000, 60 * 1000);
		measure(1000, 70 * 1000);
		measure(1000, 80 * 1000);
		measure(1000, 90 * 1000);
		measure(1000, 100 * 1000);
		measure(500, 200 * 1000);
		measure(250, 300 * 1000);
		measure(150, 400 * 1000);
		measure(150, 500 * 1000);
		measure(75, 600 * 1000);
		measure(75, 700 * 1000);
		measure(50, 800 * 1000);
		measure(50, 900 * 1000);
		measure(50, 1 * 1000 * 1000);
		measure(25, 2 * 1000 * 1000);
		measure(10, 3 * 1000 * 1000);
		measure(10, 4 * 1000 * 1000);
		measure(10, 5 * 1000 * 1000);
		measure(10, 6 * 1000 * 1000);
		measure(10, 7 * 1000 * 1000);
		measure(10, 8 * 1000 * 1000);
		measure(10, 9 * 1000 * 1000);
		measure(10, 10 * 1000 * 1000);
		measure(5, 20 * 1000 * 1000);
		measure(5, 30 * 1000 * 1000);
		measure(5, 40 * 1000 * 1000);
		measure(5, 50 * 1000 * 1000);
	}
}
