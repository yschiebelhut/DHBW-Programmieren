package de.dhbwka.java.exercise.collections;

import java.util.ArrayList;
import java.util.Random;

public class Lottery {

	public static void main(String[] args) {
		Random r = new Random();
		ArrayList<Integer> nums = new ArrayList<>(7);
		for (int i = 0; i < 6; i++) {
			boolean added = false;
			do {
				int rand = r.nextInt(49) + 1;
				if (!nums.contains(rand)) {
					nums.add(rand);
					added = true;
				}
			} while (!added);
		}
		nums.sort(null);
		for (int x :
				nums) {
			System.out.printf("%d ", x);
		}

		{
			boolean added = false;
			do {
				int rand = r.nextInt(49) + 1;
				if (!nums.contains(rand)) {
					nums.add(rand);
					added = true;
					System.out.printf("Zusatzzahl: %d\r", rand);
				}
			} while (!added);
		}


	}
}
