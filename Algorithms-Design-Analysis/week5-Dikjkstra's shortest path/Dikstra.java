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

/*
 * 
 * answer
 * key  1  = 0
key  2  = 2971
key  3  = 2644
key  4  = 3056
key  5  = 2525
key  6  = 2818
key  7  = 2599
key  8  = 1875
key  9  = 745
key  10  = 3205
key  11  = 1551
key  12  = 2906
key  13  = 2394
key  14  = 1803
key  15  = 2942
key  16  = 1837
key  17  = 3111
key  18  = 2284
key  19  = 1044
key  20  = 2351
key  21  = 3630
key  22  = 4028
key  23  = 2650
key  24  = 3653
key  25  = 2249
key  26  = 2150
key  27  = 1222
key  28  = 2090
key  29  = 3540
key  30  = 2303
key  31  = 3455
key  32  = 3004
key  33  = 2551
key  34  = 2656
key  35  = 998
key  36  = 2236
key  37  = 2610
key  38  = 3548
key  39  = 1851
key  40  = 4091
key  41  = 2732
key  42  = 2040
key  43  = 3312
key  44  = 2142
key  45  = 3438
key  46  = 2937
key  47  = 2979
key  48  = 2757
key  49  = 2437
key  50  = 3152
key  51  = 2503
key  52  = 2817
key  53  = 2420
key  54  = 3369
key  55  = 2862
key  56  = 2609
key  57  = 2857
key  58  = 3668
key  59  = 2947
key  60  = 2592
key  61  = 1676
key  62  = 2573
key  63  = 2498
key  64  = 2047
key  65  = 826
key  66  = 3393
key  67  = 2535
key  68  = 4636
key  69  = 3650
key  70  = 743
key  71  = 1265
key  72  = 1539
key  73  = 3007
key  74  = 4286
key  75  = 2720
key  76  = 3220
key  77  = 2298
key  78  = 2795
key  79  = 2806
key  80  = 982
key  81  = 2976
key  82  = 2052
key  83  = 3997
key  84  = 2656
key  85  = 1193
key  86  = 2461
key  87  = 1608
key  88  = 3046
key  89  = 3261
key  90  = 2018
key  91  = 2786
key  92  = 647
key  93  = 3542
key  94  = 3415
key  95  = 2186
key  96  = 2398
key  97  = 4248
key  98  = 3515
key  99  = 2367
key  100  = 2970
key  101  = 3536
key  102  = 2478
key  103  = 1826
key  104  = 2551
key  105  = 3368
key  106  = 2303
key  107  = 2540
key  108  = 1169
key  109  = 3140
key  110  = 2317
key  111  = 2535
key  112  = 1759
key  113  = 1899
key  114  = 508
key  115  = 2399
key  116  = 3513
key  117  = 2597
key  118  = 2176
key  119  = 1090
key  120  = 2328
key  121  = 2818
key  122  = 1306
key  123  = 2805
key  124  = 2057
key  125  = 2618
key  126  = 1694
key  127  = 3285
key  128  = 1203
key  129  = 676
key  130  = 1820
key  131  = 1445
key  132  = 2468
key  133  = 2029
key  134  = 1257
key  135  = 1533
key  136  = 2417
key  137  = 3599
key  138  = 2494
key  139  = 4101
key  140  = 546
key  141  = 1889
key  142  = 2616
key  143  = 2141
key  144  = 2359
key  145  = 648
key  146  = 2682
key  147  = 3464
key  148  = 2873
key  149  = 3109
key  150  = 2183
key  151  = 4159
key  152  = 1832
key  153  = 2080
key  154  = 1831
key  155  = 2001
key  156  = 3013
key  157  = 2143
key  158  = 1376
key  159  = 1627
key  160  = 2403
key  161  = 4772
key  162  = 2556
key  163  = 2124
key  164  = 1693
key  165  = 2442
key  166  = 3814
key  167  = 2630
key  168  = 2038
key  169  = 2776
key  170  = 1365
key  171  = 3929
key  172  = 1990
key  173  = 2069
key  174  = 3558
key  175  = 1432
key  176  = 2279
key  177  = 3829
key  178  = 2435
key  179  = 3691
key  180  = 3027
key  181  = 2345
key  182  = 3807
key  183  = 2145
key  184  = 2703
key  185  = 2884
key  186  = 3806
key  187  = 1151
key  188  = 2505
key  189  = 2340
key  190  = 2596
key  191  = 4123
key  192  = 1737
key  193  = 3136
key  194  = 1073
key  195  = 1707
key  196  = 2417
key  197  = 3068
key  198  = 1724
key  199  = 815
key  200  = 2060

 */


/*
 * 
 *input

1	2,1	8,2

2	1,1	3,1

3	2,1	4,1

4	3,1	5,1

5	4,1	6,1

6	5,1	7,1

7	6,1	8,1

8	7,1	1,2

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
 
