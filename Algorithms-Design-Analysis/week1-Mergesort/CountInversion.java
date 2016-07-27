package algorithms;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * Programming Assignment #1
 * Stanford - Algorithms Design 
 * Input - 100,000 integers 
 * Output - Number of total inversion 
 * Method - Should use Divide and conquer method (NlogN)
 */

public class CountInversion {
	
	private static long counter = 0 ; 	

	public static void mergeSort(Comparable [ ] a)
	{	
		Comparable[] tmp = new Comparable[a.length];
		mergeSort(a, tmp,  0,  a.length - 1);

	}


	private static void mergeSort(Comparable [ ] a, Comparable [ ] tmp, int left, int right)
	{
		
		if( left < right )
			
		{	
		/*
			System.out.println("a = "+Arrays.toString(a));
			System.out.println("tmp = "+Arrays.toString(tmp));
			System.out.println("left = "+left);
			System.out.println("right = "+right);
			*/

			
			int center = (left + right) / 2;
			mergeSort(a, tmp, left, center);
			//System.out.println("mergesort");
			mergeSort(a, tmp, center + 1, right);
			//System.out.println("mergesort");
			merge(a, tmp, left, center + 1, right);
			//System.out.println("merge");
		}else{
		}
	}


    private static void merge(Comparable[ ] a, Comparable[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;
        
      //  System.out.println("a[left] = " + a[left]+"  a[right] = " + a[right]);

        while(left <= leftEnd && right <= rightEnd)
            if(a[left].compareTo(a[right]) <= 0){
          		// System.out.println("tmp = "+Arrays.toString(tmp));
            	tmp[k++] = a[left++];
           	 //System.out.println("-------------moved---------without counting");
        	 //System.out.println("tmp = "+Arrays.toString(tmp));

            }
                
            else{
       		 	// System.out.println("k = "+k);
       		 	// System.out.println("left position ="+left+"   right position ="+right);
       		 	// System.out.println("tmp = "+Arrays.toString(tmp));
            	 tmp[k++] = a[right++];
            	 //System.out.println("-------------moved---------");
            	 //System.out.println("tmp = "+Arrays.toString(tmp));
           		 //System.out.println("left position ="+left+"   right position ="+right);
           		 counter = counter+(right-k) ;
            	 //System.out.println("Count inversion   "+counter);
            	 }
               
        
        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];
        	//System.out.println("tmp = "+Arrays.toString(tmp));
        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];
        //System.out.println("tmp = "+Arrays.toString(tmp));
    	//counter++;
        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
        //counter++;
       // System.out.println("Copy tmp to actual array ");
       // System.out.println("tmp = "+Arrays.toString(tmp));
        
    }


	public static void main(String[] args) throws IOException {
		//Integer [] a = {6,3,5,4,2,1};
		//Integer [] a = {4,5,6,1,2,3};

		//mergeSort(a);
		//System.out.println(Arrays.toString(a));
		//System.out.println("Number of inversions = "+counter);

		
		String inputDirectory = "src/algorithms/input/IntegerArray.txt";
		String inputTest = "src/algorithms/input/IntegerArrayTest.txt";
		
		FileInputStream fis = new FileInputStream(inputDirectory);
        DataInputStream in = new DataInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
        int count=0;
        String arr;
        Integer [] beans = new Integer[100000];
        while((arr=br.readLine()) != null){
        	
        	int x = Integer.parseInt(arr);
        	beans[count] = x ;
        	count++;
        }

        //System.out.println(Arrays.toString(beans));
        
       
        //mergeSort(intArr);
        mergeSort(beans);
        br.close();
        System.out.println(counter);
        
	}

}

/* 
 * int to char 
for(int i = 0 ; i < tmp.length() ; i++){
	   
     intArr[i] = (int) tmp.charAt(i)-'0'; // By simply subtracting 0, char correctly converted to int. (Need to investigate why)
     
}*/
