package de.uni_hannover.hci.shape;

import java.util.*;

public class MergeSort {
	public static <T extends Comparable<T>> List<Shape> mergeSort(List<Shape> ls) {
		if (ls.size() == 1)
			return ls;

		int mid = ls.size() / 2;
		List<Shape> left = new ArrayList<Shape>();
		List<Shape> right = new ArrayList<Shape>();

		for (int i = 0; i < ls.size(); i++) {
			if (i < mid) {
				left.add(ls.get(i));
			} else {
				right.add(ls.get(i));
			}
		}

		left = mergeSort(left);
		right = mergeSort(right);

		return merge(left, right);
	}

	public static <T extends Comparable<T>> List<Shape> merge(List<Shape> left, List<Shape> right) {
		List<Shape> merge = new ArrayList<Shape>();

		int i = 0;
		int j = 0;

		for (int k = 0; i < left.size() || j < right.size(); k++) {
			if (i < left.size() && j < right.size()) {
				if (left.get(i).compareTo(right.get(j)) < 0) {
					merge.add(left.get(i));
					i++;
				} else {
					merge.add(right.get(j));
					j++;
				}
			} else if (i < left.size()) {
				merge.add(left.get(i));
				i++;
			} else if (j < right.size()) {
				merge.add(right.get(j));
				j++;
			}
		}
		return merge;
	}
}