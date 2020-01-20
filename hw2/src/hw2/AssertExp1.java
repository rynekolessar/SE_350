package hw2;

import java.util.*; // for comparing arrays in main() tests only

class AssertExp1 {

	/*
	 * minValue returns the minimum value in an array of doubles. You can assume the
	 * array is nonempty and has no duplicates. Your solution must go through the
	 * array exactly once. Your solution must not call any other functions. Here are
	 * some examples (using "==" informally):
	 * 
	 * -7 == minValue(new double[] { -7 }) -7 == minValue(new double[] { 1, -4, -7,
	 * 7, 8, 11 }) -13 == minValue(new double[] { -13, -4, -7, 7, 8, 11 }) -9 ==
	 * minValue(new double[] { 1, -4, -7, 7, 8, 11, -9 })
	 */
	public static double minValue(double[] list) {
		double min = list[0];
		for (double v : list) {
			if (v < min) {
				min = v;
			}
		}
		return min;
	}

	/*
	 * minPosition returns the position of the minimum value in an array of doubles.
	 * The first position in an array is 0 and the last is the array.length-1. You
	 * can assume the array is nonempty and has no duplicates. Your solution must go
	 * through the array exactly once. Your solution must not call any other
	 * functions. Here are some examples (using "==" informally):
	 * 
	 * 0 == minPosition(new double[] { -7 }) 2 == minPosition(new double[] { 1, -4,
	 * -7, 7, 8, 11 }) 0 == minPosition(new double[] { -13, -4, -7, 7, 8, 11 }) 6 ==
	 * minPosition(new double[] { 1, -4, -7, 7, 8, 11, -9 })
	 */
	public static int minPosition(double[] list) {
		double min = list[0];
		int x = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i] < min) {
				x = i;
			}
		}
		return x;
	}

	/*
	 * numUnique returns the number of unique values in an array of doubles. Unlike
	 * the previous questions, the array may be empty and it may contain duplicate
	 * values. Also unlike the previous questions, you can assume the array is
	 * sorted.
	 * 
	 * Your solution must go through the array exactly once. Your solution must not
	 * call any other functions. Here are some examples (using "==" informally):
	 * 
	 * 0 == numUnique(new double[] { }) 1 == numUnique(new double[] { 11 }) 1 ==
	 * numUnique(new double[] { 11, 11, 11, 11 }) 8 == numUnique(new double[] { 11,
	 * 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 }) 8 ==
	 * numUnique(new double[] { 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88
	 * })
	 */
	public static int numUnique(double[] list) {
		if (list.length == 0) {
			return 0;
		} else if (list.length == 1) {
			return 1;
		} else {
			int c = 1;
			for (int i = 1; i < list.length; i++) {
				if (list[i] != list[i - 1]) {
					c++;
				}
			}
			return c;
		}
	}

	/*
	 * removeDuplicates returns the number of unique values in an array of doubles.
	 * You may assume that the list is sorted, as you did for numUnique.
	 * 
	 * Your solution may call numUnique, but should not call any other functions.
	 * After the call to numUnique, you must go through the array exactly one more
	 * time. Here are some examples (using "==" informally):
	 * 
	 * new double[] { } == removeDuplicates(new double[] { }) new double[] { 11 } ==
	 * removeDuplicates(new double[] { 11 }) == removeDuplicates(new double[] { 11,
	 * 11, 11, 11 }) new double[] { 11, 22, 33, 44, 55, 66, 77, 88 } ==
	 * removeDuplicates(new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44,
	 * 55, 55, 66, 77, 88, 88 }) == removeDuplicates(new double[] { 11, 22, 33, 44,
	 * 44, 44, 44, 44, 55, 55, 66, 77, 88 })
	 */
	public static double[] removeDuplicates(double[] list) {
		int c = numUnique(list);
		double[] new_list = new double[c];
		if (c != 0) {
			int index = 0;
			double element = list[0];
			new_list[index++] = element;
			for (int i = 1; i < list.length; i++) {
				if (element != list[i]) {
					element = list[i];
					new_list[index++] = element;
				}
			}
		}
		return new_list;
	}
}
