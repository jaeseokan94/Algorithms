package roundA;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*
 * Problem

The Constitution of a certain country states that the leader is the person with the name containing the greatest number of different alphabet letters. (The country uses the uppercase English alphabet from A through Z.) For example, the name GOOGLE has four different alphabet letters: E, G, L, and O. The name APAC CODE JAM has eight different letters. If the country only consists of these 2 persons, APAC CODE JAM would be the leader.

If there is a tie, the person whose name comes earliest in alphabetical order is the leader.

Given a list of names of the citizens of the country, can you determine who the leader is?
Input

The first line of the input gives the number of test cases, T. T test cases follow. Each test case starts with a line with an interger N, the number of people in the country. Then N lines follow. The i-th line represents the name of the i-th person. Each name contains at most 20 characters and contains at least one alphabet letter.

Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the name of the leader.

https://code.google.com/codejam/contest/11274486/dashboard

 * 
 */


public class ConutryLeader {
	
	public static int countLetters(String name) {
	    boolean[] isUnique = new boolean[10000000];
	    int numOfLetters = 0;
	    char space = ' ';

	    for (int i = 0 ; i < name.length() ; i++) {
	    	if(name.charAt(i)==space){
		    	isUnique[name.charAt(i)] = false;
	    	}else{
		    	isUnique[name.charAt(i)] = true;
	    	}
	    }

	    for (int i = 0 ; i < isUnique.length ; i++) {
	        if (isUnique[i] == true){
	        	numOfLetters++;
	        }}

	    return numOfLetters;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		FileInputStream fis = new FileInputStream("src/roundA/A-large.in.txt");
        DataInputStream in = new DataInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        
        PrintStream out = new PrintStream(new FileOutputStream("src/roundA/output.txt"));
        
        Scanner sc = new Scanner(System.in);


        int N = Integer.parseInt(br.readLine());
        int x = 1;
        

        
        while(x <= N)
        {	           
        	int y = 1 ;
        	int T = Integer.parseInt(br.readLine());
            String arr;
    		int max = 0 ;
    		String thisMax="";
            List<String> list = new ArrayList<>();
            Stack<String> stack = new Stack<String>();

    		
        	while(y <= T){
        		arr = br.readLine();
        		int tmp = countLetters(arr);
        		
        		if(tmp>max){
        			max=tmp;
        			thisMax = arr;
        			stack.push(arr);

        		}else if(tmp==max){
        			//do sth
        			String old = stack.pop();
        			if(arr.compareTo(old)<0){
        				stack.push(arr);
        				thisMax = arr;

        			}else{
        				stack.push(old);

        			}
        			
        			
        		}
                
                y++;
        	}
        	
            
            
            
            System.out.println("Case #"+x+": "+thisMax);
            out.println("Case #"+x+": "+thisMax);
            x++;
        }
        br.close();
        System.setOut(out);

	}
	}


