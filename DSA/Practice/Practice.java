package DSA.Practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Practice {
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int sum = n * (n + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public void missingNumber1(int[] arr) {
        int a[] = new int[arr.length + 1];
        for (int n : arr) {
            a[n - 1] = 1;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                System.out.println(i + 1);
                return;
            }
        }
    }

    public void countDigits(int n) {
        // String s = Long.toString(n);
        // System.out.println(s.length());
        int c = 0;
        while (n > 0) {
            c++;
            n = n / 10;
        }
        System.out.println(c);

    }

    public int SecondLargest(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : arr) {
            pq.offer(n);
            if (pq.size() > 2) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public char firstNonRepeatChar(String s) {
        int[] arr = new int[256];
        for (char c : s.toCharArray()) {
            System.out.println(c);
            System.out.println(arr[c]);
            arr[c]++;
        }
        for (char ch : s.toCharArray()) {

            if (arr[ch] == 1) {
                System.out.println((int) ch);
                return ch;
            }
        }
        return '_';
    }

    public static char FirstUniqueChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry);
            if (entry.getValue() == 2) {
                return entry.getKey();
            }
        }
        return '_';
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static boolean Anagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static String ReverseSentence(String s) {
        String res = "";
        String arr[] = s.split(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            res = res + arr[i] + " ";
        }
        return res;
    }

    public static String ReverseEachWordInSentence(String s) {
        String arr[] = s.split(" ");
        String f = "";
        for (String str : arr) {
            String res = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                res += str.charAt(i) + "";
            }
            f+=res+" ";
        }
        return f;
    }
    public static int [] MoveAllZerosToEnd(int [] arr){
        for(int j=0;j<arr.length ; j++){
            for(int i=0;i<arr.length-1;i++){
            if(arr[i]==0){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;;
            }
        }
        }
        return arr;
    }

    public static int[] MoveAllZerosToEnd1(int[] arr) {
        int n = arr.length;
        int count = 0; // Count of non-zero elements

        // Traverse the array and move non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[count] = arr[i];
                count++;
                continue;
            }
        }

        // Fill the remaining positions with zeros
        while (count < n) {
            arr[count++] = 0;
        }

        return arr;
    }
    public static void main(String[] args) {
        // Practice p = new Practice();
        // int arr [] = { 1,2,3,4,5,6,7,8,9};
        // System.out.println(p.missingNumber(arr));
        // p.missingNumber1(arr);
        // p.countDigits(649123758);
        // System.out.println(p.SecondLargest(arr));
        // System.out.println(p.firstNonRepeatChar("uuddaayykkummzarr"));
        // String [] strs = {"uday","udayam","udaymm"};
        // System.out.println(longestCommonPrefix(strs));
        // System.out.println(Anagrams("udaynmn","ydamnnu"));
        int arr[] = { 0,1, 0, 2, 0, 3, 0, 4 };
        // System.out.println(ReverseEachWordInSentence("Hello World"));
        System.out.println(Arrays.toString(MoveAllZerosToEnd1(arr)));

    }
}
