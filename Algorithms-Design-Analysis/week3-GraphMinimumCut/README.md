< h2> The question was basically using a randomisation contraction algorithm to find a minimum nubmer of cuts in a given graph. (200 vertices) 

</h2>

<h3>
How I approached this probelm? 

1. I implemented adjacency list in Java using hashmap<Integer,Integer[]> . Key : vertex , Value : vertecies that are connected to the key. 
2. I implemented Karger's algorithm. It is a randomisation contraction algorithm. I will explain detail below. 
3. There are 3 main steps in this algorith.  First, randomly choose one edge. (u,v) Second, merge (u,v) into one vertex. Third, Remove self-loops

- randomly choosing one edge 
I first randomly choosed a key from a hashmap I implemented, and that key denotes one of the vertex in the graph. code : keys.get( r.nextInt(keys.size()) )
And then, randomly choose an element from an array of corresponding value. 

- merge 
This was the easiest part. Merge two arrays. It could have been easier and more effective if I used a list to store values. 

- remove self loop 
My code is a little bit messy and it is not the best way, but I solved a problem. 
I used a double for loop to check all the values if that value matching with corresponding key. If key == value, value changed to
1000. I didnt want to bother to remove elements from array at that time.. 

Then, repeat this a large number of times, since a probabilty of not finding the minimum from n repetition is 1/n. 

</h3>

<QS>
Your task is to code up and run the randomized contraction algorithm for the min cut problem and use it on the above graph 
to compute the min cut. (HINT: Note that you'll have to figure out an implementation of edge contractions. 
Initially, you might want to do this naively, creating a new graph from the old every time there's an edge contraction.
But you should also think about more efficient implementations.) 
(WARNING: As per the video lectures, please make sure to run the algorithm many times with different random seeds,
and remember the smallest cut that you ever find.) Write your numeric answer in the space provided.
So e.g., if your answer is 5, just type 5 in the space provided.

Input : The file contains the adjacency list representation of a simple undirected graph. There are 200 vertices labeled 1 to 200. The first column in the file represents the vertex label, and the particular row (other entries except the first column) tells all the vertices that the vertex is adjacent to. So for example, the 6th row looks like : "6	155	56	52	120	......". 
This just means that the vertex with label 6 is adjacent to (i.e., shares an edge with) 
the vertices with labels 155,56,52,120,......,etc





https://en.wikipedia.org/wiki/Karger%27s_algorithm
