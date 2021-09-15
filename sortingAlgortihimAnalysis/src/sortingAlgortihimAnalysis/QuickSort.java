package sortingAlgortihimAnalysis;

import java.util.concurrent.atomic.AtomicInteger;

public class QuickSort
{
	public static void quickSort(int[] list, AtomicInteger comp, AtomicInteger moves) {
		// reset the counters for swaps and comparisons
		comp.set(0);
		moves.set(0);
	
		// call the recursive quicksort method
		quickSort(list,0,list.length-1, comp, moves);
	}
	
	static void quickSort(int[] a, int p, int r, AtomicInteger comp, AtomicInteger moves) {
	    while (r - p > 1) {
	        int q = partition(a, p, r, comp, moves);

	        if (q - p <= (r - p) / 2) {
	            // the left-hand partition is smaller; sort it recursively
	            quickSort(a, p, q - 1, comp, moves);
	            // update p so as to sort the right-hand partition iteratively
	            p = q + 1;
	        } else {
	            // the right-hand partition is smaller; sort it recursively
	            quickSort(a, q + 1, r, comp, moves);
	            // update r so as to sort the left-hand partition iteratively
	            r = q - 1;
	        }
	    }
	}
	
	
	private static int partition(int[] list, int low, int high, AtomicInteger comp, AtomicInteger moves) {
		// The pivot point is the first item in the subarray
		int pivot = list[low];
		moves.incrementAndGet();
		
		// Loop through the array.  Move items up or down the array so that they
		// are in the proper spot with regards to the pivot point.
		do {
			// can we find a number smaller than the pivot point?
			while (low < high && list[high] >= pivot) {
					high--;
					comp.incrementAndGet();  
			}
			if (low < high) {
				// found a smaller number; swap it into position
				list[low] = list[high];
				moves.incrementAndGet();
				//System.out.print("Swapping "+list[low]+" and "+list[high]+":  ");
				//print(list);
	
				// now look for a number larger than the pivot point
				while (low < high && list[low] <= pivot) {
		 		  	low++;
					comp.incrementAndGet();
				}
				if (low < high) {
					// found one!  move it into position
					list[high] = list[low];
					moves.incrementAndGet();
				}
			}   
		} while (low < high);
	
		// move the pivot back into the array
		list[low] = pivot;
		moves.incrementAndGet();
		return low;
		}
}
