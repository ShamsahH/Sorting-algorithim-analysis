package sortingAlgortihimAnalysis;

import java.util.concurrent.atomic.AtomicInteger;

//Java program for implementation of Heap Sort 
public class HeapSort 
{ 
public static void heapSort(int arr[], AtomicInteger comp, AtomicInteger moves) 
{ 
   comp.set(0);
   moves.set(0);
	 int n = arr.length; 

   // Build heap (rearrange array) 
   for (int i = n / 2 - 1; i >= 0; i--) 
       heapify(arr, n, i, comp, moves); 

   // One by one extract an element from heap 
   for (int i=n-1; i>=0; i--) 
   { 
       // Move current root to end 
       int temp = arr[0]; 
       arr[0] = arr[i]; 
       arr[i] = temp; 
       moves.incrementAndGet();
       
       // call max heapify on the reduced heap 
       heapify(arr, i, 0, comp, moves); 
   } 
} 

// To heapify a subtree rooted with node i which is 
// an index in arr[]. n is size of heap 
static void heapify(int arr[], int n, int i, AtomicInteger comp, AtomicInteger moves) 
{ 
   int largest = i;  // Initialize largest as root 
   int l = 2*i + 1;  // left = 2*i + 1 
   int r = 2*i + 2;  // right = 2*i + 2 

   // If left child is larger than root 
   if (l < n && arr[l] > arr[largest]) {
       largest = l; 
       comp.incrementAndGet();
   }

   // If right child is larger than largest so far 
   if (r < n && arr[r] > arr[largest]) {
       largest = r; 
       comp.incrementAndGet();
   }

   // If largest is not root 
   if (largest != i) 
   { 
       int swap = arr[i]; 
       arr[i] = arr[largest]; 
       arr[largest] = swap; 
       moves.incrementAndGet();
       // Recursively heapify the affected sub-tree 
       heapify(arr, n, largest, comp, moves); 
   } 
} 
}