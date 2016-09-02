package algorithm_design;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Dikstra {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String test = "test_dijkstra.txt";
		String input ="input_dikstra.txt";
		FileInputStream fis = new FileInputStream("src/algorithm_design/"+input);
        DataInputStream in = new DataInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        PrintStream out = new PrintStream(new FileOutputStream("src/algorithm_design/output.txt"));

        
        int N = Integer.parseInt(br.readLine());
        int x = 1;
        
        Hashtable G = new Hashtable();
        
        while(x <= N)
        {

        	String arr[] = br.readLine().split("	"); 
        	G.put(Integer.parseInt(arr[0]), convertStringToHash(arr));
        	
            x++;
        }
        br.close();
        
        dijkstra(G,0);
        
        
        out.println("Case #"+x+": "+"sth");
        System.setOut(out);

        
	}
	/*
	 * for each vertex v in Graph:             // Initialization
          dist[v] ← INFINITY                  // Unknown distance from source to v
          prev[v] ← UNDEFINED                 // Previous node in optimal path from source
          add v to Q                          // All nodes initially in Q (unvisited nodes)
     dist[source] ← 0                        // Distance from source to source
      
	 */
	
	public static int[] dijkstra(Hashtable G, int s){
		
		
		 
			 
			   int size = G.size();
		       // getting key
		       
		       int dist[] = new int[size];   // dist[i] will hold shortest distance from source to i 
		       Boolean sptSet[] = new Boolean[size];  // a set of shortest path tree. It is ture if the vertex is included in shortest path. 
		       
		       for (int i = 0; i < size; i++)
		        {
		            dist[i] = Integer.MAX_VALUE;
		            sptSet[i] = false;
		        }
		       
		       dist[s] = 0; // distance from source to itself should always be zero.
				
		       Set<Integer> keys = G.keySet();
				Iterator<Integer> itr = keys.iterator();
				//System.out.println("G = "+G);
				//System.out.println("set " + keys ) ;
		       while (itr.hasNext()) { 
			       
		    	   int key = itr.next();
		    	   int minIndex = minDistance(dist,sptSet);
		    	   int minKeyVertex = minIndex+1;
		    	   sptSet[minIndex] = true;
		    	   
		    	   // minIndex's vertex search adjacent vertecies 
		    	  // System.out.println(minIndex);
		    	   // anything related to minIndex and hastable , I need to manipulate the numeber. because of the difference between array Index and key value. 
		    	   Hashtable cur = (Hashtable) G.get(minKeyVertex);  // because if minIndex indicate n-1 that means it indicates the key n 
		    	   Set<Integer> keyOfCurrentVertex = cur.keySet(); 
		    	  // System.out.println("Key Set : " +keyOfCurrentVertex );

				   Iterator<Integer> itr2 = keyOfCurrentVertex.iterator();
				   /*
				    * update dist[minIndex]
				    * should only iterate adjacent vertecies
				    */
		    	   while(itr2.hasNext()){
		    		   int keyIn = itr2.next();
		    		   keyIn = keyIn; // difference between array Index and key value. (key value of 1 will be allocated in array[0])
		    		  //System.out.println("keyIn = "+keyIn+" minIndex= "+minIndex+"    and current vertex is "+ cur);
		    		  // System.out.println(keyIn);
		    		   // total weight of path from src to
		                // v through u is smaller than current value of dist[v]
		    		   if(dist[keyIn-1] >= dist[minIndex]+Integer.parseInt(cur.get(keyIn).toString())&&
			    						  sptSet[keyIn-1]==false
			    						  && dist[minIndex]!=Integer.MAX_VALUE 
		    				  ){
			    		  // System.out.println("weight of "+keyIn+" is : "+  Integer.parseInt(cur.get(keyIn).toString()));

		    			   dist[keyIn-1] = dist[minIndex]+Integer.parseInt(cur.get(keyIn).toString());
		    		   }
		    		   
		    	   }
		    	   
		    	   
		    	   
		    	   

		       //System.out.println("Key: "+key +" & Value: "+G.get(key));
		    } 
		       
		       //printing answer
		      int ans[] = {7,37,59,82,99,115,133,165,188,197};
		      for(int i = 0 ; i < ans.length ; i ++ ){
		    	  //int k = i+1;
		    	 int k = ans[i];
		    	 k= k-1;
		  		System.out.print(dist[k]+",");
		  		//System.out.println("trace );
		      }
		      
		return dist;
	}
	
	/*
	 * 
	 * return the index(Vertex) of the optimum vertex 
	 */
	public static int minDistance(int[] dist , Boolean[] sptSet){
		
		int minDist = Integer.MAX_VALUE ;
		int minIndex = 0 ;
		
		for(int i = 0 ; i < sptSet.length ; i ++ ){
			
			if(sptSet[i]==false&&minDist>=dist[i]){
				minDist = dist[i];  // need to figure this out.... i'm coding in the plane and mind may not be at the clearest
				minIndex = i;
			}
			
		}
		
		
		return minIndex;
	}
	
	
	
	
	public static Hashtable convertStringToHash(String array[]){
		//System.out.println(Arrays.toString(array)+array.length);
    	Hashtable edges = new Hashtable();

		for(int i = 1 ; i < array.length; i++) {
			String[] a = array[i].split(",");
			int e = Integer.parseInt(a[0]);
			int weight = Integer.parseInt(a[1]);
			//System.out.println("v = "+ e+ " weight = "+weight);
			edges.put(e, weight);
		}
		
		
		return edges;
			
	}

}
/* test case

output:

1 0 []

2 1 [2]

3 2 [2, 3]

4 3 [2, 3, 4]

5 4 [2, 3, 4, 5]

6 4 [8, 7, 6]

7 3 [8, 7]

8 2 [8] 
 * 
 * 
 * 
 *
 */
 
