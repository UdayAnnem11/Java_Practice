package DSA.Practice;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Test1 {

    public static int [] twoSum(int [] arr ,int target ){
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i =0; i<arr.length ; i++){
            int comp = target - arr[i];
            if(map.containsKey(comp)){
                return new int[] {map.get(comp),i};
            }
            map.put(arr[i],i);
        }
        return new int[] {-1,-1};
    }

    public static int ClimbingStairs(int n){
        if(n<2 ){
            return  n ;
        }
        int first = 1 , second = 2;
        for(int i = 3 ; i<n ; i++){
            int third = first + second ;
            first = second ;
            second = third ;

        }
        return second ;
    }

    public static int KthLargestElementInArray(int [] arr , int k ){
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       for(int n : arr){
        pq.offer(n);
        if(pq.size()>k){
            pq.poll();
        }
       }
       return pq.peek();
    }
    public static void main(String [] args){
        int arr[] = { 2,3, 5, 13,5 ,6,3,6,7,85,6,7,1};
        System.out.println(KthLargestElementInArray(arr, 1));
        System.out.println(ClimbingStairs(8));
        System.out.println((char)97);
    }
}
