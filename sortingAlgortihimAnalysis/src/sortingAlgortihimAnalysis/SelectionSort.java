package sortingAlgortihimAnalysis;

import java.util.concurrent.atomic.AtomicInteger;

public class SelectionSort {
	/** The method for sorting the numbers */
	  public static void selectionSort(int[] list, AtomicInteger comp, AtomicInteger moves) {
	    
		comp.set(0);
		moves.set(0);
		for (int i = 0; i < list.length - 1; i++) {
	      // Find the minimum in the list[i..list.length-1]
	      int currentMin = list[i];
	      int currentMinIndex = i;

	      for (int j = i + 1; j < list.length; j++) {
	        if (currentMin > list[j]) {
	          currentMin = list[j];
	          currentMinIndex = j;
	          comp.incrementAndGet();
	        }
	      }

	      // Swap list[i] with list[currentMinIndex] if necessary;
	      if (currentMinIndex != i) {
	        list[currentMinIndex] = list[i];
	        list[i] = currentMin;
	        moves.incrementAndGet();
	      }
	      
	    }
	  }

}
