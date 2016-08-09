package algorithms;

import java.util.*;

/*
 * create a method to reverse the words of a string.
 * i.e., "Hello World" => "World Hello"
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		char [] arr = a.toCharArray();
		System.out.println(reverseWord(arr));
		
		
	}

}
