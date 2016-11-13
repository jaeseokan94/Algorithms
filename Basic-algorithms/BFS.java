import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static class Graph {
        
        private int V; // size
        private LinkedList<Integer> adj[];
        
        public Graph(int size) {
            V = size ; 
            adj = new LinkedList[size];
            for(int i = 0 ; i < size ; i ++){
                adj[i] = new LinkedList();
            }
            
            
        }

        public void addEdge(int first, int second) {
            adj[first].add(second);
            adj[second].add(first);
        }
        
        public int[] shortestReach(int startId) { // 0 indexed
            
            boolean[] visited = new boolean[V];
            int[] dist = new int[V] ; 
            for(int i = 0 ; i < V ; i ++){
                if(i==startId){
                    dist[i] = 0 ;
                }else{
                dist[i] = -1;
                }
            }
            
            LinkedList<Integer> queue = new LinkedList<Integer>();
            
            visited[startId] = true ;
            queue.add(startId);
            
            int distance = 0 ; 
            
            while(queue.size() != 0)
            {
                
                Integer cur = queue.poll();
                Iterator<Integer> i = adj[cur].listIterator();
               
                while(i.hasNext())
                    {
                    int n = i.next();
                    if(!visited[n])
                        {
                        
                        visited[n] = true ;
                        queue.add(n);
                        dist[n] = dist[cur] + 6 ; 
                    }
                    
                }
                
            }
            
           
            
            
            return dist ;
        }
        
        
        
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int queries = scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();
            
            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                
                // add each edge to the graph
                graph.addEdge(u, v);
            }
            
            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);
 
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();            
        }
        
        scanner.close();
    }
}
