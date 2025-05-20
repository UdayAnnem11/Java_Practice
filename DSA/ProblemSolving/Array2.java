package DSA.ProblemSolving;

import java.util.HashSet;
import java.util.Set;

public class Array2 {
    public int Duplicate(int [] arr){
        Set<Integer> set = new HashSet<>();
        for(int i : arr){
            if(set.contains(i)){
                return i;
            }
            set.add(i);
        }
        return 0;
    }
}
