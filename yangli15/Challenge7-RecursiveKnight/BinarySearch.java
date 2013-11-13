//UIUC CS125 FALL 2013 MP. File: BinarySearch.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2013-11-12T11:50:16-0600.415914391
//@author yangli15

public class BinarySearch {
	/** Wrapper method. Just runs the recursive search method below for the entire array*/
	public static boolean search(int[] array, int key) {
		return search(array, key, 0, array.length - 1);
	}

	/**
	 * Recursive search using Divide and Conquer approach:
	 * The given array is already sorted so we can very quickly discover if the key is in the array or not.
	 * Hint: For the recursive case check the value at (lo+hi)/2
	 * and proceed accordingly.
	 */
	static boolean search(int[] array, int key, int lo, int hi) {
		if(lo > hi)
			return false;
		int mid = (lo + hi) / 2;
		int valMid = array[mid];
		if(key == valMid)
			return true;
		if(key < valMid)
			return search(array, key, lo, mid-1);
		return search(array, key, mid+1, hi);
	}
}
