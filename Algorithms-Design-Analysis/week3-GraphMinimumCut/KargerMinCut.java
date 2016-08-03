package algorithms;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class KargerMinCut {
	
	public static Integer[] convertStringToInt(String array[]){
		Integer[] intArr = new Integer[array.length];
		for(int i = 0 ; i < array.length; i++) 
			intArr[i] = Integer.parseInt(array[i]);
		
		return intArr;
			
	}
	
	public static Integer[] extractEdges(Integer arr[]){
	
		Integer edgesArr[] = new Integer[arr.length-1];
		for(int i = 1 ; i < arr.length ; i ++ ){ // ignore first value of array since it represents vertex not edges
			edgesArr[i-1] = arr[i];
		}
		
		return edgesArr;
	}
	
	public HashMap<Integer,Integer[]> input() throws IOException{
		String input = "src/algorithms/input/mincut.txt";
		String inputTest = "src/algorithms/input/test.txt";
		
		FileInputStream fis = new FileInputStream(input);
        DataInputStream in = new DataInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		
		
		//int vertices[];
		//int[] edges[];

		ArrayList vertices = new ArrayList();
		ArrayList<Integer[]> edges = new ArrayList<Integer[]>();
		
		HashMap<Integer,Integer[]> graph = new HashMap<Integer,Integer[]>();  
		
		String v;
		int count = 1;
		int N = 200;
		
		while(count<=N){
			Integer arr[];

           arr = convertStringToInt(br.readLine().split("	"));
           edges.add(extractEdges(arr));
           vertices.add(arr[0]);
           
           graph.put(arr[0],extractEdges(arr));
           
           count++;
		}
		
		return graph;
		
	}
			
	public static void main(String[] args) throws IOException {
		
		
		
		int ans=100000;
        for(int i = 0 ; i < 2000 ; i++){
        	KargerMinCut k = new KargerMinCut();
    		int tmp = k.karger(k.input());
        	if(tmp<ans){
        		ans=tmp;
        	}
        }
		
		
    System.out.println("ans!!   "+ans);
        
	}
	
	public int karger(HashMap<Integer,Integer[]> graph){
		
        Random r = new Random();

		int counter = 0 ;
		while(graph.size()>2){
			
			
	        for (Map.Entry<Integer,Integer[]> entry : graph.entrySet()) {
	        	  Integer key = entry.getKey();
	        	  Integer[] value = entry.getValue();
	        	  
	        	  int d = 0 ;
	        	  for(int val : value){
	        		 if(key==val){
	        			  graph.get(key)[d]=1000;
	        			 // System.out.println("key = value");
	        			 // System.out.println("key = "+key+"   d = "+d);
	        		  }
	        		  
	        		  d++;
	        	  }
	        	}
	        
			
			List<Integer> keys      = new ArrayList<Integer>(graph.keySet());
			int u = keys.get( r.nextInt(keys.size()) ); // picking up random u 
			
			Integer[] keysOfkeys     ;
			keysOfkeys = graph.get(u);
			
			int idx = new Random().nextInt(keysOfkeys.length);

			int v = (keysOfkeys[idx]);
			// to avoid self-loop
		//	System.out.println("enter");
		//System.out.println(Arrays.toString(keysOfkeys));
			 while(v==1000){
				int idx2 = new Random().nextInt(keysOfkeys.length);
				v = (keysOfkeys[idx2]);

			 }
			
			
	       // int u = r.nextInt(graph.size());      
	       // int v =r.nextInt(graph.get(u).length);   // picking up random v 
	     //  System.out.println("u = "+u +"   v = "+v);
	      //  System.out.print("edge in while loop : ");
	        	        
	        for (Map.Entry<Integer,Integer[]> entry : graph.entrySet()) {
	        	  Integer key = entry.getKey();
	        	  Integer[] value = entry.getValue();
	        	  //System.out.print("key : "+ key + " value : "+Arrays.toString(value)+"    ");
	        	}
	        
			
		
		//	System.out.println("");
	        Integer[] uG,vG = new Integer[400];
	        uG = graph.get(u);
	        vG = graph.get(v);
	        
	        
	        
			//System.out.println("uG = "+Arrays.toString(uG));
			//System.out.println("vG = "+Arrays.toString(vG));

	        // we just picked random edge (u,v)  -> need to merge edges.get(u) and edges.get(v) need to be merged. 
	        // now need to merge 
	        int mergeLength =uG.length+vG.length;
	        Integer[] toMerge = new Integer[mergeLength];
	        System.arraycopy(uG, 0, toMerge, 0, graph.get(u).length);
	        System.arraycopy(vG, 0, toMerge, graph.get(u).length, graph.get(v).length);
	        
	        
	      //after merge , every elements in edge, that pointing to uV need to be changed to uG
	        int a = 1 ;
	        graph.put(u,toMerge);

	        for (Map.Entry<Integer,Integer[]> entry : graph.entrySet()) {
	        	  Integer key = entry.getKey();
	        	  Integer[] value = entry.getValue();
	        	  
	        	  int b = 0 ;
	        	  for(int val : value){
	        		  if(val==v){
	        			  graph.get(key)[b]=u;
	        //			  System.out.println("key = "+key + " b = "+b);
	        	//		  System.out.println("val v "+v+" to "+ u);
	        			  
	        		  }if(key==val){
	        			  graph.get(key)[b]=1000;
	        			//  System.out.println("key = value");
	        		//	  System.out.println("key = "+key+"   b = "+b);
	        		  }
	        		  
	        		  b++;
	        	  }
	        	  a++;
	        	}
	        
	        graph.remove(v);
	        counter++;
			//System.out.println(a);	
		}
		
		//System.out.println("ended");
		

		
		//System.out.println("");
		
      	int mincutCount=0;
		int trick = 0 ;
		for (Map.Entry<Integer,Integer[]> entry : graph.entrySet()) {
      	  Integer key = entry.getKey();
      	  Integer[] value = entry.getValue();
      	  


      	if(trick==0){
      		for(int val : value){
      			if(val!=1000&&val!=key){
      				mincutCount++;
      			}
      		}      		
      	}

      	trick++;
      	}
		
		System.out.println(mincutCount+"!!!");
      	
      	
      	
      	return mincutCount;
		
		
	}
	

}
