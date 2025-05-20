// Method 1 : {
//Find a pair with the given sum in an array
// Input: nums = [8, 7, 2, 5, 3, 1]target = 10 Output: Pair found (8, 2)orPair found (7, 3)
// }


package DSA.ProblemSolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Array1 {
    public void FindPair1(int[] arr, int target) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.printf("Pair found (%d, %d)", arr[i], arr[j]);
                    return ;
                }
            }
        }
        System.out.println("Pair not found");
    }

    public boolean checkIfSubArrayExistsWithOptimize(int [] arr){
        Set<Integer> set = new HashSet<>();
        int s = 0 ;
        for(int i=0 ; i< arr.length ; i++ ){
            s += arr[i];
            if(set.contains(s) || s==0 ){
                return true;
            }
            set.add(s);
        }
        return false;
    }

    public boolean checkIfSubArrayWithZeroSum (int arr []) {
        
        for(int i=0 ; i<arr.length ; i++) {
            int s = 0;
            for(int j=i ;j<arr.length ; j++){
                s += arr[j];
                if(s == 0 ){
                    return true ;
                }
            }
        }
        return false ;
    }


    //Find All SubArrays with sum Zero 

    public void printAllSubArrays(int [] arr){
        Map<Integer, List<Integer>> subMap = new HashMap<>();
        List<int[]> res = new ArrayList<>();
        int sum = 0 ;
         
        for(int i=0 ; i<arr.length ; i++){
            sum += arr[i];
            if(sum == 0 ){
                res.add(new int[]{0,i});
            }
            if(subMap.containsKey(sum)){
                List<Integer> indices = subMap.get(sum);
                for(int startIndex : indices){
                    res.add(new int[] { startIndex+1 , i});
                }
            }
            subMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }

        for (int[] pair : res) {
            int start = pair[0], end = pair[1];
            System.out.print("Subarray with 0 sum: [");
            for (int j = start; j <= end; j++) {
                System.out.print(arr[j]);
                if (j < end) System.out.print(", ");
            }
            System.out.println("]");
        }
    }


    public int[] MoveAllZerosToStart(int [] arr ){
        int c = 0 ;
        for( int i : arr) {
            if(i == 0){
                c++;
            }
        }
        for(int i=0 ; i<c ; i++ ){
            arr[i]=0;
        }
        for(int j=c ; j<arr.length ; j++){
            arr[j]=1;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = { 8, 7, 4, 5, 9, 8 };
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        int[] arr1 = { 1, 0, 1, 0, 1, 0, 0, 1 } ;
        // Array1 array1 = new Array1();
        // array1.FindPair1(nums, 10);

        // array1.printAllSubArrays(arr);

        // System.out.println(array1.checkIfSubArrayExistsWithOptimize(arr));  

        // array1.MoveAllZerosToStart(arr1);
        // for(int i : arr1){
        //     System.out.print(i);
        // }
        Array2 array2 = new Array2();
       System.out.println( array2.Duplicate(nums)); 

    }

}