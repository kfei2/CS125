//UIUC CS125 FALL 2013 MP. File: MolecularSort.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2013-11-12T11:50:16-0600.415914391
//@author yangli15
public class MolecularSort {

	/** Sorts each xyz coordinate using it's Z value (coord[i][2] <= coord[j][2] for i<j). */
	static void sortCoordsByZ(double[][] coords) {
		recursiveSort(coords, 0, coords.length-1);
	}

	/**
	 * recursively sorts coordinates entries by their z value. Entries between
	 * lo and hi inclusive are considered.
	 */
	static void recursiveSort(double[][] coords, int lo, int hi) {
		if(lo < hi)
		{
			swap(coords, lo,findIndexOfZMinimum(coords, lo, hi));
			recursiveSort(coords, lo+1, hi);
		}
		// TODO: write the four lines of a recursive selection sort here.
	}

	/**
	 * returns the index of the entry with the lowest Z value. Entries between
	 * lo and hi inclusive are considered.
	 */
	static int findIndexOfZMinimum(double[][] coords, int lo, int hi) {
		if(lo < hi)
		{
			int index = findIndexOfZMinimum(coords, lo+1, hi);
			if(coords[index][2] < coords[lo][2])
				return index;
			return lo;
		}
		return lo;
	}
	

	/* Swaps the (x,y and z) values of the i-th and j-th coordinates.*/
	static void swap(double[][] coords, int i, int j) {
		double[] temp = coords[i];
		coords[i] = coords[j];
		coords[j] = temp;
	}
}
