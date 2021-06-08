package de.dhbwka.java.exercise.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BinaryTree<T extends Comparable<T>> {
	private T value;
	private BinaryTree<T> left, right;

	public BinaryTree() {
	}

	public boolean isEmpty() {
		return this.value == null;
	}

	public boolean add(T x) {
		if (this.isEmpty()) {
			this.value = x;
			return true;
		}
		if (x.compareTo(this.value) < 0) {
			if (left == null) {
				left = new BinaryTree<>();
			}
			this.left.add(x);
			return true;
		}
		if (x.compareTo(this.value) > 0) {
			if (right == null) {
				right = new BinaryTree<>();
			}
			this.right.add(x);
			return true;
		}
		return false;
	}

	public T getValue() {
		return this.value;
	}

	public List<T> traverse() {
		List<T> out = new LinkedList<>();
		if(this.left != null) {
			out.addAll(left.traverse());
		}
		out.add(this.getValue());
		if(this.right != null) {
			out.addAll(right.traverse());
		}
		return out;
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		{
			Random r = new Random();
			for (int i = 0; i<10; i++) {
				int rand = r.nextInt(100);
				System.out.println(rand);
				tree.add(rand);
			}
		}
		System.out.println(tree.traverse());
	}
}
