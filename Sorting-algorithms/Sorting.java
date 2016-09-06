package dataStructures;

import java.awt.List;
import java.util.Arrays;

public class Sorting {
	
	
	public static int[] bubbleSort(int arr[]){
		boolean isSorted = false ; 
		// bubble sort implemented online use double for loop, but I believe my version is slightly more efficient way. any opinion? 
		while(isSorted==false){
			isSorted = true ; 
			for(int i = 0 ; i < arr.length -1 ; i ++){ // =1 to avoid arrayIndexOutOfBoundsException
				if(arr[i]>arr[i+1]){
					swap(arr,i,i+1);
					isSorted=false;
				}
			}			
		}
		
		return arr;
	}
	
	public static int[] selectionSort(int arr[]){
		// can this algorithm be improved?
		
		for(int i = 0 ; i < arr.length ; i ++){
			int min = arr[i];
			int minIndex = i ;
			for(int j = i+1 ; j < arr.length ; j++){
				if(min>arr[j]){
					min=arr[j];
					minIndex = j ;
				}
			}
			arr[minIndex] = arr[i];
			arr[i] = min ;
		}
		
		return arr;
	}

	public static void main(String[] args) {
		
		int arr[] = {3,7,6,1,9,5,10,2,4,8};
	//	System.out.println(Arrays.toString(bubbleSort(arr)));
	//	System.out.println(Arrays.toString(selectionSort(arr)));

		
	}
	
	/*
	 * Swap two elements
	 */
	public static void swap(int[] arr, int i , int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}

}
