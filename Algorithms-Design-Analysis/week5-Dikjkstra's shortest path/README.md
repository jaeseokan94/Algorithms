<h2> Week 5 question </h2>

The file contains an adjacency list representation of an undirected weighted graph with 200 vertices labeled 1 to 200. Each row consists of the node tuples that are adjacent to that particular vertex along with the length of that edge. For example, the 6th row has 6 as the first entry indicating that this row corresponds to the vertex labeled 6. The next entry of this row "141,8200" indicates that there is an edge between vertex 6 and vertex 141 that has length 8200. The rest of the pairs of this row indicate the other vertices adjacent to vertex 6 and the lengths of the corresponding edges.

Your task is to run Dijkstra's shortest-path algorithm on this graph, using 1 (the first vertex) as the source vertex, and to compute the shortest-path distances between 1 and every other vertex of the graph. If there is no path between a vertex v and vertex 1, we'll define the shortest-path distance between 1 and v to be 1000000.



<h2> How I approached </h2>

This problem is very simply asked me to implement Dijkstra's algorithm.
There were two challenges. First, how should I implement weighted undirected graph using Java. Second, how to implement details of dijkstra's algorithm.
I implemented weighted undirected graph using Hashtable with integer number of vertex as a key, and hashtable as a value. And this 
hashtable represent connected vertex and weight between those two vertices. 
