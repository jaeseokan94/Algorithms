package algorithms;

import java.util.*;

/*
 * create a method to reverse the words of a string.
 * i.e., "Hello World" => "World Hello"
 
 Additional method for reversing String.
 
 */

public class ReverseWord {
    
	public static String reverseWord(char[] a){
		String ans = "";
		Stack<String> stack = new Stack();
		String sb="";
		
		for(int i = 0 ; i < a.length ; i ++){
			if(a[i]==' '){
				stack.push(sb);
				sb="";
			}else if(i==a.length-1){
				sb = sb + a[i];
				stack.push(sb);
			}else{
				sb = sb + a[i];
			}
			
			}
		
		int k = stack.size(); // since stack size is dynamically changing, i assigned it before a for loop. 
		for(int i = 0 ; i < k; i ++){
			ans = ans + stack.pop() + " ";

		}
		
		return ans;
	}
    
    // reversing a string method using String
	public static String useString(String s){
		
		String reverse = "";
		
		for(int i = 0 ; i < s.length() ; i ++ ){
			reverse=reverse+s.charAt(s.length()-i-1);
		} // you have to make a whole copy of String everytime you add new character, so it takes more time. 
		
		return reverse;
	}
	    // reversing a string method using StringBuilder
	public static String useStringBuilder(String s){
		StringBuilder reverse = new StringBuilder();
		
		for(int i = 0 ; i < s.length() ; i ++ ){
			reverse.append(s.length()-i-1);
		} 
		return reverse.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		char [] arr = a.toCharArray();
		System.out.println(reverseWord(arr));
		
		
	}

}
