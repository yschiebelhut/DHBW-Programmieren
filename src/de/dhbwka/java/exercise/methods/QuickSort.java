/**
 * 
 */
package de.dhbwka.java.exercise.methods;

import java.util.Arrays;

/**
 * @author Yannik Schiebelhut
 *
 */
public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {9,2,5,7,8,3,4,10,1,6};
		System.out.println(Arrays.toString(arr));
		quicksort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void quicksort(int[] pArr) {
		quicksort(pArr, 0, pArr.length);
	}

	private static void quicksort(int[] pArr, int lowerBound, int higherBound) {
		if (higherBound - lowerBound <= 1) {
			return;
		}

		int pivot = pArr[higherBound - 1];
		int splitIndex = lowerBound;

		for (int i = lowerBound; i < higherBound - 1; i++) {
			if (pArr[i] < pivot) {
				int tmp = pArr[i];
				pArr[i] = pArr[splitIndex];
				pArr[splitIndex] = tmp;
				splitIndex++;
			}
		}

		// pivot to split
		int tmp = pArr[splitIndex];
		pArr[splitIndex] = pArr[higherBound - 1];
		pArr[higherBound - 1] = tmp;
		
		quicksort(pArr, lowerBound, splitIndex);
		quicksort(pArr, splitIndex+1, higherBound);
	}

}
