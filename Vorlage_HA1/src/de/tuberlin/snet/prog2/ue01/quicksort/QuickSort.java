package de.tuberlin.snet.prog2.ue01.quicksort;

import java.util.LinkedList;

/**
 * itarative quicksort algorithm
 * @author prog2-team
 *
 */
public class QuickSort
{
	
	
	/**
	 * internal class for ranges 
	 */
	private static class QuickRange {
		public int left;
		public int right;
		
		public QuickRange(int left, int right) {
			this.left = left;
			this.right = right;
		}
		
		public String toString() {
			return "[" + left + "," + right + "]";
		}
	}
	
	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	private static int partition(int[] list, int left, int right) {
		int pivot = list[left + (right-left)/2];
		while (left <= right) {
			while (list[left] < pivot) {
				left++;
			}
			while (list[right] > pivot) {
				right--;
			}
			if (left <= right) {
				swap(list, left, right);
				left++;
				right--;
			}
		}

		return left;
	}

	private static void quickSort(int[] list, int left, int right) {
		LinkedList<QuickRange> rangeList = new LinkedList<QuickRange>();
		if (left >= right)
			return;

		rangeList.add(new QuickRange(left, right));

		while (true) {
			if (rangeList.size() == 0)
				break;
			left = rangeList.get(0).left;
			right = rangeList.get(0).right;
			rangeList.remove(0);

			int pivot = partition(list, left, right);
			
			if (pivot - 1 > left) {
				rangeList.add(new QuickRange(left, pivot - 1));
			}

			if (pivot < right) {
				rangeList.add(new QuickRange(pivot, right));
			}
		}
	}

	public static void sort(int[] list) {
		quickSort(list, 0, list.length-1);
	}
	
	
	public static void main (String[] args) {
		int[] newList = {5, 7, 23, 87, 11, 0, 5, 33, 30};
		for(int i: newList) {
			System.out.print(i + " ");
		}
		System.out.println();
		sort(newList);
		for(int i: newList) {
			System.out.print(i + " ");
		}
	}
}
