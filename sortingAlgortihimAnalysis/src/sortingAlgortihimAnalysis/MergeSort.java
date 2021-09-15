package sortingAlgortihimAnalysis;
import java.util.concurrent.atomic.AtomicInteger;

public class MergeSort {
	public static void mergeSort(int[] list, AtomicInteger comp, AtomicInteger moves) {
	    if (list.length > 1) {
	      // Merge sort the first half
	      int[] firstHalf = new int[list.length / 2];
	      System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
	      mergeSort(firstHalf, comp, moves);

	      // Merge sort the second half
	      int secondHalfLength = list.length - list.length / 2;
	      int[] secondHalf = new int[secondHalfLength];
	      System.arraycopy(list, list.length / 2,
	        secondHalf, 0, secondHalfLength);
	      mergeSort(secondHalf, comp, moves);

	      // Merge firstHalf with secondHalf into list
	      merge(firstHalf, secondHalf, list, comp, moves);
	    }
	  }

	  /** Merge two sorted lists */
	  public static void merge(int[] list1, int[] list2, int[] temp, AtomicInteger comp, AtomicInteger moves) {
	    int current1 = 0; // Current index in list1
	    int current2 = 0; // Current index in list2
	    int current3 = 0; // Current index in temp

	    while (current1 < list1.length && current2 < list2.length) {
	    	comp.incrementAndGet();
	    	if (list1[current1] < list2[current2]) {
	    		temp[current3++] = list1[current1++];
	    		moves.incrementAndGet();
	    	}  
	    	else
	    		temp[current3++] = list2[current2++];
	    		moves.incrementAndGet();
	    }

	    while (current1 < list1.length)
	      temp[current3++] = list1[current1++];
	    	moves.incrementAndGet();

	    while (current2 < list2.length)
	      temp[current3++] = list2[current2++];
	    	moves.incrementAndGet();
	  }
}
