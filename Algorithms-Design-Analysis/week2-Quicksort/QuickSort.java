package algorithms;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuickSort {
	
	/*
	 * 
	 *  Your task is to compute the total number of comparisons used to sort the given input file by QuickSort. As you know,
	 *  the number of comparisons depends on which elements are chosen as pivots, 
	 *  so we'll ask you to explore three different pivoting rules. ( First element , Last element, Median of three elements) 
	 * 
	 */
	
	private static int counter=0;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		String input = "src/algorithms/input/quicksort.txt";
		String inputTest = "src/algorithms/input/quicksorttest.txt";
		
		FileInputStream fis = new FileInputStream(input);
        DataInputStream in = new DataInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
        int count=0;
        int inputSize = 10000;
        String arr;
        int [] x = new int[inputSize];

        while((arr=br.readLine()) != null){
        	
        	int a = Integer.parseInt(arr);
        	x[count] = a ;
        	count++;
        }

        
		System.out.println(Arrays.toString(x));
 
		int low = 0;
		int high = x.length - 1;
		//counter = counter + (high-low);
		//System.out.println("Initial compare= "+(high-low));
		quicksort(x, low, high);
		System.out.println(Arrays.toString(x));
		System.out.println("counter = "+ counter);
	}
	
	
	public static int partition(int[] arr, int left , int right){
		
		
		//swap(arr,left,right); //uncomment this to choose pivot with the last element
		
		
		//int median =(left+right)/2;                             //uncomment following three lines to choose pivot according to three-median law
		//int pivotMedian = medianPivot(arr,left,median,right);
		//swap(arr,left,pivotMedian);
		
		
		int pivot = arr[left];						// by default, this program will calculate number of swaps choosing first element in sub array.
		
		int i = left+1;
		for(int j = left+1; j <= right ; j++){
			if(arr[j]<pivot){
				swap(arr,i,j);
				i++;
			}
		}
		
		swap(arr,left,i-1);
		
		
		return i-1;
		
		
	}
 
	
	/*
	 * Swap two elements
	 */
	public static void swap(int[] arr, int i , int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	
	
	public static void quicksort(int[] arr, int left , int right){
		if(arr.length==1)
			return;
		
		
		int pivotIndex;
		if (right > left) {
			  counter = counter + (right-left);
		      pivotIndex = partition(arr, left, right);
		     // System.out.println("Pivot index =" +  pivotIndex);
		     // System.out.println("first "+ Arrays.toString(arr));
		      quicksort(arr, left, pivotIndex - 1);
		     // System.out.println("second "+ Arrays.toString(arr));
		      quicksort(arr, pivotIndex + 1, right);
		    }
		
		
	}
	
	/*
	 * Finding median of pivot. Need to return pivot position, not pivot value. 
	 * Median defined in the question is following
	 * Choose three elemets to choose median pivot of each partition (first, middle, last) element 
	 * pick the median value out of this three values. 
	 * 
	 * eg ) if (1,7,3) is given -> 3 is the median value.
	 */
	public static int medianPivot(int arr[], int left, int median, int right){
		int pivotSet [] = {arr[left],arr[median],arr[right]};
		Arrays.sort(pivotSet);
		int pivot = pivotSet[1];
		int pivotPosition;
		
		if(pivot==arr[left]){
			pivotPosition = left ;
		} else if (pivot == arr[right] ){
			pivotPosition = right ;
		} else{
			pivotPosition = median;
		}
		return pivotPosition;
	}

	

}