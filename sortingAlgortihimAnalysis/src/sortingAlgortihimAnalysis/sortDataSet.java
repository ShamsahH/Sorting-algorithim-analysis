package sortingAlgortihimAnalysis;
import java.util.Random;

public class sortDataSet {

	public static void ascendingSort(int[] arr)
	{
		int n = arr.length; 
		
		for(int i = 0; i < n-1;i++)
		{
			int min_inx = i;
			for ( int j = i+1; j < n; j++)
				if(arr[j] < arr[min_inx])
					min_inx = j;
			
			int temp = arr[min_inx];
			arr[min_inx] = arr[i];
			arr[i] = temp;
			
		}
		
	}
	
	public static void descendingSort(int[] list)
	{
		ascendingSort(list);
		for(int i = 0; i < list.length - 1; i++)
		{
			list[list.length - i-1] = list[i];
		}
	}
	public static void almostOrder(int[] list)
	{
		ascendingSort(list);
		
		int numChange = (int)(list.length * 0.3);
		Random r = new Random();
		int MAX = 500, MIN = 0;
		for(int i = 0; i < numChange; i++)
		{
			list[i] = r.nextInt((MAX - MIN)+1) + MIN;
			
		}
		
	}
	
	public static void randomOrder(int[] list)
	{
		ascendingSort(list);
		
		int numChange = (int)(list.length * 0.9);
		Random r = new Random();
		int MAX = 500, MIN = 0;
		for( int i = 0; i < numChange; i++)
		{
			list[i] = r.nextInt((MAX- MIN)+1)+MIN;
		}
		
	}
	
}
