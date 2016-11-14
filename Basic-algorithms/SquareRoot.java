// basic implementation of binary search
// input a 
// output = floor(sqrt(x)) 
public class Solution {
	public int sqrt(int a) {
	    long i = a / 2 ; 
	    long start = 0 ; 
	    long end = a ; 
	    boolean find = false ; 
	    while(find==false){
	        long cur = i * i ;
	        long nxt = (i+1)*(i+1);
	        if(cur<=a&&a<nxt){
	            return (int)i;
	        }else if(cur>a){
	            end = i - 1 ;
	        }else{
	            start = i + 1;
	        }
	        i = (start + end) / 2 ;
	    }
	    return 0 ;
	}
}
