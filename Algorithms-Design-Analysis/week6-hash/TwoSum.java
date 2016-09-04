package algorithm_design;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Set;

public class TwoSum {
	
	private static int counter = 0 ;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		String test = "test.txt";
		String input ="input_twosum.txt";
		FileInputStream fis = new FileInputStream("src/algorithm_design/"+input);
        DataInputStream in = new DataInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        PrintStream out = new PrintStream(new FileOutputStream("src/algorithm_design/output.txt"));

     

        int n = 1000000; 
    	//int n = 15;
        long arr[] = new long[n];
        Hashtable w = new Hashtable();
        
        for(int i = 0 ; i < n ; i ++){
        	long tmp = Long.parseLong(br.readLine());
        	arr[i] = tmp;
        //	G.put(tmp, i);
        }
       Arrays.sort(arr);
       System.out.println(Arrays.toString(arr));
       
       for(int i = 0 ; i < n ; i ++){
    	   for(int j = i ; j < n ; j ++){
    		   long sum = arr[j]+arr[i];
    		   
       	if(sum<=10000&&sum>=-10000&&arr[j]!=arr[i]){
       		if(!w.containsKey(sum)){
       			w.put(sum,arr[i]);
           		//System.out.println(arr[j]+" + "+arr[i]+" ="+ sum);
       		}
           }
    	   
    	   }
       }
       
       System.out.println("hashtable size  = "+ w.size());  
  
   
        
        br.close();
        
          System.setOut(out);

	}

}
