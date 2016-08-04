package algorithms;

import java.util.*;
import java.io.*;

public class KargerMinCut {
	
	public static void main(String[] args) throws IOException {
    	double a1,a2;
		a1 = System.nanoTime();
		
    	KargerMinCut k = new KargerMinCut();
    	
		int ans=100000;
        for(int i = 0 ; i < 500 ; i++){
    		int tmp = k.karger(k.input());
        	if(tmp<ans){
        		ans=tmp;
        	}
        }
		
		a2 = System.nanoTime();

    System.out.println("Minimum cut =  "+ans);
    System.out.println("time taken " + (a2-a1));
        
	}
	
	public int karger(HashMap<Integer,Integer[]> graph){
		
        Random r = new Random();

		while(graph.size()>2){
			
			// check if there are self loop
			for (Map.Entry<Integer,Integer[]> entry : graph.entrySet()) {
	        	  Integer key = entry.getKey();
	        	  Integer[] value = entry.getValue();
	        	  
	        	  int d = 0 ;
	        	  for(int val : value){
	        		  
	        		 if(key==val){
	        			  graph.get(key)[d]=1000;
	        		  }	        		  
	        		  d++;
	        	  }
	        	}
			
			
			List<Integer> keys = new ArrayList<Integer>(graph.keySet());
			int u = keys.get( r.nextInt(keys.size()) ); // picking up random u 
			
			Integer[] keysOfkeys;
			keysOfkeys = graph.get(u);
			
			int idx = new Random().nextInt(keysOfkeys.length); // picking up another vertex from u

			int v = (keysOfkeys[idx]);
			// to avoid self-loop
			 while(v==1000){
				int idx2 = new Random().nextInt(keysOfkeys.length);
				v = (keysOfkeys[idx2]);
			 }
			
	        Integer[] uG,vG = new Integer[200];
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
	        graph.put(u,toMerge);
	        graph.remove(v);

	        // This algorithm need to be improved
	        for (Map.Entry<Integer,Integer[]> entry : graph.entrySet()) {
	        	  Integer key = entry.getKey();
	        	  Integer[] value = entry.getValue();
	        	  
	        	  int b = 0 ;
	        	  for(int val : value){
	        		  if(val==v){
	        			  graph.get(key)[b]=u;
	        		  }
	        			  
	        		  b++;
	        	  }
	        	}
	        
		} // end of while loop
		
      	int mincutCount=0;
		int firstHashMap = 0; // to count first hashmap only
		for (Map.Entry<Integer,Integer[]> entry : graph.entrySet()) {
      	Integer key = entry.getKey();
      	Integer[] value = entry.getValue();
      	if(firstHashMap==0){
      		for(int val : value){
      			if(val!=1000&&val!=key){ // dont count self-loop 
      				mincutCount++;
      			}
      		}      		
      	}
      	firstHashMap++;
      	}
		
		//System.out.println("Mincut = "+mincutCount);
      	return mincutCount;
		
		
	}
	
	/*
	 * Handeling input
	 */
	public HashMap<Integer,Integer[]> input() throws IOException{
		String input = "src/algorithms/input/mincut.txt";
		String inputTest = "src/algorithms/input/test.txt";
		
		FileInputStream fis = new FileInputStream(input);
        DataInputStream in = new DataInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

		ArrayList<Integer[]> edges = new ArrayList<Integer[]>();
		HashMap<Integer,Integer[]> graph = new HashMap<Integer,Integer[]>();  
		
		int count = 1;
		int N = 200;
		
		while(count<=N){
			Integer arr[];
           arr = convertStringToInt(br.readLine().split("	"));
           edges.add(extractEdges(arr));
           graph.put(arr[0],extractEdges(arr));
           
           count++;
		}
		
		return graph;
		
	}
	
	/*
	 * Convert an array of String input to array of Integer
	 */
	public static Integer[] convertStringToInt(String array[]){
		Integer[] intArr = new Integer[array.length];
		for(int i = 0 ; i < array.length; i++) 
			intArr[i] = Integer.parseInt(array[i]);
		
		return intArr;
			
	}
	
	/*
	 * Disregard first element of an array
	 */
	public static Integer[] extractEdges(Integer arr[]){
	
		Integer edgesArr[] = new Integer[arr.length-1];
		for(int i = 1 ; i < arr.length ; i ++ ){ // ignore first value of array since it represents vertex not edges
			edgesArr[i-1] = arr[i];
		}
		
		return edgesArr;
	}

}
