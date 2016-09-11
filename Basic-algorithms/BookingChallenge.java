package hackerrank;
import java.io.*;
import java.util.*;


/*
 * question info
 * https://www.hackerrank.com/contests/booking-passions-hacked-backend/challenges/a-couple-and-their-passions/copy-from/6936850
 * 
 */
public class BookingChallenge {
    
   
    public static double distance_between(double lat1, double lng1, double lat2, double lng2) {
    double earthRadius = 6371000; //meters
    double dLat = Math.toRadians(lat2-lat1);
    double dLng = Math.toRadians(lng2-lng1);
    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
               Math.sin(dLng/2) * Math.sin(dLng/2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    double dist = (double) (earthRadius * c);

    return dist;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        Hashtable h = new Hashtable();
        
        int n1 = sc.nextInt();
        Set<String> set = new HashSet<String>(); // Use set of hobbies to remove duplicate 
        
        for(int i = 0 ; i < n1 ; i ++){
            int n3 = sc.nextInt();
            for(int j = 0 ; j < n3 ; j ++ ){
                String hobby = sc.next();
                set.add(hobby);
            }     
        }
        
       // System.out.println(set);
        
        int n2 = sc.nextInt();
        
        List[][] table = new List[n2][];
        
        for(int i = 0 ; i < n2 ; i ++){
            
            List[] value = new List[3];
            List cities = new LinkedList();
            List<Double> citiesPoint = new LinkedList();
            List countries = new LinkedList();
            
            Double p[] = new Double[2];            
            String country = sc.next();
            p[0] = sc.nextDouble();
            p[1] = sc.nextDouble();
            int n4 = sc.nextInt();
            
            String arr3[] = new String[n4];
            for(int j = 0 ; j < n4 ; j ++ ){
                String hobby2 = sc.next();
                cities.add(hobby2);
            }
            
         
            countries.add(country);
            citiesPoint.addAll(Arrays.asList(p)); 
            value[1] = cities ; 
            value[2] = citiesPoint;
            value[0] = countries;  
            table[i] = value ; 
        }
        
        String destination1 = "",destination2 = ""; 
        int max = 0 ;
        int maxIndexI = 0, maxIndexJ = 0 ; 
        for(int i = 0 ; i < table.length ; i ++){
            for(int j = i+1 ; j < table.length ; j ++){
               String city1 = table[i][0].toString();
               String city2 = table[j][0].toString();
               
                List citiesSort = new LinkedList();
                citiesSort.add(city1);
                citiesSort.add(city2);
                Collections.sort(citiesSort);
                
                
                Set<String> setToCompare = new HashSet<String>(); 
                for(int k = 0 ; k < table[i][1].size() ; k ++ ){
                    setToCompare.add(table[i][1].get(k).toString());
                }for(int l = 0 ; l < table[j][1].size() ; l ++ ){
                    setToCompare.add(table[j][1].get(l).toString());
                }
                int noOfCommon = 0 ; 
            
                
            //System.out.println(table[i][1].toString());
                
                for (String commonHobby : setToCompare) {
                    for(String commonHobby2 : set){
                    if(commonHobby.equals(commonHobby2)){
                        noOfCommon++;
                    }
                    
                    }
                }
                if(noOfCommon>max){
                destination1 = citiesSort.get(0).toString() ; 
                destination2 = citiesSort.get(1).toString() ;  
                maxIndexI = i ;
                maxIndexJ = j ; 
                max = noOfCommon ;
                }else if(noOfCommon==max){
                    // check points
                    double disCur =distance_between(  (Double)table[j][2].get(0) , (Double)table[j][2].get(1),(Double)table[i][2].get(0), (Double)table[i][2].get(1) );
                       double disMx = distance_between(  (Double)table[maxIndexJ][2].get(0) , (Double)table[maxIndexJ][2].get(1), (Double)table[maxIndexI][2].get(0), (Double)table[maxIndexI][2].get(1) );
                                    
                    
                 //  System.out.println(city1+"   "+city2+"  "+ disCur + " max = "+destination1+" "+ destination2 + " = " + disMx );

                    if(disCur<disMx){
                destination1 = citiesSort.get(0).toString() ; 
                destination2 = citiesSort.get(1).toString() ;  
                maxIndexI = i ;
                maxIndexJ = j ; 
                                        max = noOfCommon ;

                    }
                    
                    
                }else{
                    // do nothing
                }
                
                
            }
        }
        
        destination1 = destination1.replaceAll("[\\[\\](){}]","");
        destination2 = destination2.replaceAll("[\\[\\](){}]","");

        System.out.println(destination1+" "+destination2);

        
        
    }
}