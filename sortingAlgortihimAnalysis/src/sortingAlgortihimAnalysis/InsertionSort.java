package sortingAlgortihimAnalysis;

import java.util.concurrent.atomic.AtomicInteger;

public class InsertionSort 
{ public static void insertionSort(int[] list, AtomicInteger countComparisons, AtomicInteger countMovements) {
	
	countComparisons.set(0);
	countMovements.set(0);
	  
	for(int i = 1; i < list.length; i++) {
	    
	      int j = i;      
	            
	      // compare i with sorted elements and insert it
	      // sorted elements: [0..i-1]
	      while (j > 0 && list[j] < list[j - 1]) {
	        
	        int temp = list[j];
	        list[j] = list[j - 1];
	        list[j - 1] = temp;
	        
	        countMovements.incrementAndGet();
	        countComparisons.incrementAndGet();  // loop condition true
	         
	        j--;
	      }
	      countComparisons.incrementAndGet(); // checking loop condition when false
	 }
  }
}
