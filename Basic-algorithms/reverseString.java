package algorithms;

import java.util.Scanner;

public class reverseString {
	                        
	
	public static String useString(String s){
		
		String reverse = "";
		
		for(int i = 0 ; i < s.length() ; i ++ ){
			reverse=reverse+s.charAt(s.length()-i-1);
		} // you have to make a whole copy of String everytime you add new character, so it takes more time. 
		
		return reverse;
	}
	
	public static String useStringBuilder(String s){
		StringBuilder reverse = new StringBuilder();
		
		for(int i = 0 ; i < s.length() ; i ++ ){
			reverse.append(s.length()-i-1);
		} 
		return reverse.toString();
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine() ; 
		double a1,a2,b1,b2;
		a1 = System.nanoTime();
		useString(s);
		a2 = System.nanoTime();
		
		b1 = System.nanoTime();
		useStringBuilder(s);
		b2 = System.nanoTime();

		
		System.out.println("Using String time taken : "+(a2-a1));
		System.out.println("Using StringBuilder time taken : "+(b2-b1));
		
		

		
	}

}
