package sortingAlgortihimAnalysis;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.InputMismatchException;


public class Output {

	public static void main(String[] args) {
	
			long startTime, elapsedTime;
			Random r = new Random();
			int MIN = 0, MAX = 500;
			final int SIZE = 50000; // data set size 
			
			AtomicInteger moves = new AtomicInteger(0); // counter for movements
			AtomicInteger comp = new AtomicInteger(0); // counter for comparisons

			//data sorted in 5 forms 
			int[] originalArray = new int[SIZE]; 
			int[] inOrder = new int[SIZE]; //ascending order
			int[] reverseOrder = new int[SIZE]; // flipped original
			int[] almostOrder = new int[SIZE]; // distorted by 30%
			int[] randomOrder = new int[SIZE]; // distorted by 90%
			
			//create original data set of 50000
			for(int i=0; i< SIZE-1;i++)
			{
				originalArray[i] = r.nextInt((MAX - MIN) + 1) + MIN;
			}
			
			//create 4 identical arrays to sort 
			for( int i = 0; i < SIZE - 1; i++)
			{
				inOrder[i] = reverseOrder[i] = almostOrder[i] = randomOrder[i]= originalArray[i];
				
			}
		
		// sort each array 
		sortDataSet.ascendingSort(inOrder);
		sortDataSet.descendingSort(reverseOrder);
		sortDataSet.almostOrder(almostOrder);
		sortDataSet.randomOrder(randomOrder);
		
		Scanner input = new Scanner(System.in);
		int choice = -1; 
		
		System.out.println("choose an array to test");
		System.out.println("1 - ascending array");
		System.out.println("2 - descending array");
		System.out.println("3 - partially ordered array");
		System.out.println("4 - Randomized array");
		
		System.out.println("enter number of choice");
		
		try
		{
			choice = input.nextInt();
		}
		catch (InputMismatchException exception)
		{
			System.out.println("not a valid input");
		}
			
		
		
	if ( choice == 1)
	{
		//ascending
		startTime = System.currentTimeMillis();
		InsertionSort.insertionSort(inOrder.clone(), comp, moves);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%17s\n","InsertionSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: " + moves);
		System.out.println("Comparisons: " + comp);
		System.out.println();
		
		startTime = System.currentTimeMillis();
		SelectionSort.selectionSort(inOrder.clone(), comp, moves);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%17s\n","SelectionSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: " + moves);
		System.out.println("Comparisons: " + comp);
		System.out.println();
		
		startTime = System.currentTimeMillis();
		QuickSort.quickSort(inOrder.clone(), comp, moves);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%15s\n", "QuickSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: " + moves);
		System.out.println("Comparisons: " + comp);
		System.out.println();
		
		moves.set(0);
		comp.set(0);
		startTime = System.currentTimeMillis();
		MergeSort.mergeSort(inOrder.clone(), comp, moves);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%15s\n","MergeSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: " + moves);
		System.out.println("Comparisons: " + comp);
		System.out.println();
		
		startTime = System.currentTimeMillis();
		HeapSort.heapSort(inOrder.clone(), comp, moves);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%14s\n","HeapSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: " + moves);
		System.out.println("Comparisons: " + comp);
		System.out.println();
		
		startTime = System.currentTimeMillis();
		RadixSort.radixsort(inOrder.clone(), SIZE);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%15s\n","RadixSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: 0");
		System.out.println("Comparisons: 0");
		System.out.println();
	}
	
	else if (choice == 2) {
		// descending sorts
		startTime = System.currentTimeMillis();
		InsertionSort.insertionSort(reverseOrder.clone(), comp, moves);	
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%17s\n","InsertionSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: " + moves);
		System.out.println("Comparisons: " + comp);
		System.out.println();
		
		startTime = System.currentTimeMillis();
		SelectionSort.selectionSort(reverseOrder.clone(), comp, moves);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%17s\n","SelectionSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: " + moves);
		System.out.println("Comparisons: " + comp);
		System.out.println();
		
		startTime = System.currentTimeMillis();
		QuickSort.quickSort(reverseOrder.clone(), comp, moves);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%15s\n", "QuickSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: " + moves);
		System.out.println("Comparisons: " + comp);
		System.out.println();

		moves.set(0);
		comp.set(0);
		startTime = System.currentTimeMillis();
		MergeSort.mergeSort(reverseOrder.clone(), comp, moves);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%15s\n","MergeSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: " + moves);
		System.out.println("Comparisons: " + comp);
		System.out.println();
		
		startTime = System.currentTimeMillis();
		HeapSort.heapSort(reverseOrder.clone(), comp, moves);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%14s\n","HeapSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: " + moves);
		System.out.println("Comparisons: " + comp);
		System.out.println();

		startTime = System.currentTimeMillis();
		RadixSort.radixsort(reverseOrder.clone(), SIZE);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%15s\n","RadixSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: 0");
		System.out.println("Comparisons: 0");
		System.out.println();
	}
	
	else if (choice == 3) {
		// makeNoiseBy20 sorts
		startTime = System.currentTimeMillis();
		InsertionSort.insertionSort(almostOrder.clone(), comp, moves);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%17s\n","InsertionSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: " + moves);
		System.out.println("Comparisons: " + comp);
		System.out.println();
		
		startTime = System.currentTimeMillis();
		SelectionSort.selectionSort(almostOrder.clone(), comp, moves);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%17s\n","SelectionSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: " + moves);
		System.out.println("Comparisons: " + comp);
		System.out.println();

		startTime = System.currentTimeMillis();
		QuickSort.quickSort(almostOrder.clone(), comp, moves);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%15s\n", "QuickSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: " + moves);
		System.out.println("Comparisons: " + comp);
		System.out.println();

		moves.set(0);
		comp.set(0);
		startTime = System.currentTimeMillis();
		MergeSort.mergeSort(almostOrder.clone(), comp, moves);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%15s\n","MergeSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: " + moves);
		System.out.println("Comparisons: " + comp);
		System.out.println();
		
		startTime = System.currentTimeMillis();
		HeapSort.heapSort(almostOrder.clone(), comp, moves);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%14s\n","HeapSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: " + moves);
		System.out.println("Comparisons: " + comp);
		System.out.println();

		startTime = System.currentTimeMillis();
		RadixSort.radixsort(almostOrder.clone(), SIZE);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%15s\n","RadixSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: 0");
		System.out.println("Comparisons: 0");
		System.out.println();
	}
	else if (choice == 4) {
		// makeNoiseBy80 sorts
		startTime = System.currentTimeMillis();
		InsertionSort.insertionSort(randomOrder.clone(), comp, moves);	
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%17s\n","InsertionSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: " + moves);
		System.out.println("Comparisons: " + comp);
		System.out.println();
		
		
		startTime = System.currentTimeMillis();
		SelectionSort.selectionSort(randomOrder.clone(), comp, moves);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%17s\n","SelectionSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: " + moves);
		System.out.println("Comparisons: " + comp);
		System.out.println();

		startTime = System.currentTimeMillis();
		QuickSort.quickSort(randomOrder.clone(), comp, moves);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%15s\n", "QuickSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: " + moves);
		System.out.println("Comparisons: " + comp);
		System.out.println();

		moves.set(0);
		comp.set(0);
		startTime = System.currentTimeMillis();
		MergeSort.mergeSort(randomOrder.clone(), comp, moves);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%15s\n","MergeSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: " + moves);
		System.out.println("Comparisons: " + comp);
		System.out.println();
		
		startTime = System.currentTimeMillis();
		HeapSort.heapSort(randomOrder.clone(), comp, moves);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%14s\n","HeapSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: " + moves);
		System.out.println("Comparisons: " + comp);
		System.out.println();
		
		startTime = System.currentTimeMillis();
		RadixSort.radixsort(randomOrder.clone(), SIZE);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.printf("%15s\n","RadixSort");
		System.out.println("Time Elapsed: " + elapsedTime + "ms");
		System.out.println("Movements: 0");
		System.out.println("Comparisons: 0");
		System.out.println();
	}	
	
	input.close();
	}

}
