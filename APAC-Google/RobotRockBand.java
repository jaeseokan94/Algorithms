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


/*
 * You're the manager of Xorbitant, the world's first robot rock band. There will be four positions in the band, and there are N robots auditioning for
 *  each position. (No robot is auditioning for more than one position.) Every robot has a number, 
 * and multiple robots might have the same number, just as two people can have the same name.

You know from market research that your robot audiences won't care how well the robot band members make music,
 how handsome they are, or what scandalous things the tabloids say about them. Instead, the audience will be checking to see whether the 
 four members' numbers, when bitwise XORed together, equal a certain trendy number K.

How many different sets of four robots (one for each position) is it possible to choose so that the band will have this property? 
More specifically, given four lists A, B, C, D containing N numbers each, how many ways are there to choose one number a from list A, 
one number b from list B, and so on, such that a^b^c^d = K? (Here ^ represents the bitwise XOR operation.)
 */

public class RobotRockBand {

	
	
	public static long[] convertStringToLong(String array[])
    {
        long longArray[] = new long[array.length];
        for (int i = 0; i < array.length; i++) longArray[i] = Long.parseLong(array[i]);
        return longArray;
    }
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		FileInputStream fis = new FileInputStream("src/practiceRound2016/B-large.in.txt");
        DataInputStream in = new DataInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        PrintStream out = new PrintStream(new FileOutputStream("src/practiceRound2016/output.txt"));
        
        int N = Integer.parseInt(br.readLine());
        int x = 1;
        String[] total;
        long[] arr;
        long[] first,second,third,fourth;
        long a; 
        long number;
        long sum;
        long answer;
        while(x <= N){
        	total = br.readLine().split(" ");
        	a = Integer.parseInt(total[0]);
        	number = Integer.parseInt(total[1]);
        	
            //answer= new BigInteger("0");
 answer=0;
    		first=convertStringToLong(br.readLine().split(" "));
    		second=convertStringToLong(br.readLine().split(" "));;
    		third=convertStringToLong(br.readLine().split(" "));;
    		fourth=convertStringToLong(br.readLine().split(" "));;
    		
    		for(int i = 0 ; i < a ; i ++){
    			for(int j = 0 ; j < a ; j ++){
    				for(int k = 0 ; k < a ; k ++){
    					for(int l = 0 ; l < a ; l ++){
    						
    						 sum =first[i]^second[j]^third[k]^fourth[l];
    						 if(sum==number){
    				                //answer = answer.add(BigInteger.valueOf(1));
    							 answer++;

    						 }
    			
    		}
    		}
    		}
    		}
    		

        	System.out.println("Case #"+x+": "+answer);
            out.println("Case #"+x+": "+answer);

        	x++;
        	
        	
        	
        	
        }
        br.close();
        System.setOut(out);


	}

}
