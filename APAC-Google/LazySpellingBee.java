package practiceRound2016;

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
import java.util.HashSet;
import java.util.List;



/*
 * Problem

In the Lazy Spelling Bee, a contestant is given a target word W to spell.
 The contestant's answer word A is acceptable if it is the same length as the target word, and the i-th letter of A is either
  the i-th, (i-1)th, or (i+1)th letter of W, for all i in the range of the length of A. (The first letter of A must match either 
  the first or second letter of W, since the 0th letter of W doesn't exist. Similarly, the last letter of A must match either 
  the last or next-to-last letter of W.) Note that the target word itself is always an acceptable answer word.

You are preparing a Lazy Spelling Bee, and you have been asked to determine, for each target word,
 how many distinct acceptable answer words there are. Since this number may be very large, please output it modulo 1000000007 (109 + 7).

Input

The first line of the input gives the number of test cases, T. T test cases follow; each consists of one line with a string consisting only of lowercase English letters (a through z).

Output

For each test case, output one line containing "Case #x: y", where x is the test case number (starting from 1) and y is the number of distinct acceptable answer words, modulo 109 + 7.
 */


public class LazySpellingBee {

	public static void main(String[] args) throws NumberFormatException, IOException {
		FileInputStream fis = new FileInputStream("src/practiceRound2016/A-large.in.txt");
        DataInputStream in = new DataInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        PrintStream out = new PrintStream(new FileOutputStream("src/practiceRound2016/output.txt"));

        int N = Integer.parseInt(br.readLine());
        int x = 1 ;
        String arr;
        char[] sub;
        char first,second,third;
        List<Character> list = new ArrayList<>();
        BigInteger sum;

        while(x <= N){
            arr = br.readLine();
            char[] charArray = arr.toCharArray();
            int prob;
            
            sum= new BigInteger("1");

            
            for(int i = 0 ; i < charArray.length ; i ++){
                HashSet noDupSet = new HashSet();

            	if((i-1)>=0){
                	first = charArray[i-1];
                	noDupSet.add(first);
            	}
            	if((i+1)<charArray.length){
                	third = charArray[i+1];
                	noDupSet.add(third);
            	}
            	
            	second = charArray[i];
            	noDupSet.add(second);
            	
            	prob=noDupSet.size();
                sum = sum.multiply(BigInteger.valueOf(prob));

            	//System.out.print(prob+" ");
            }
        	System.out.println("Case #"+x+": "+sum);
            out.println("Case #"+x+": "+sum);

        	
            x++;
        }
        br.close();
        System.setOut(out);


        		
	}

}
