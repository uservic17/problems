package problems.leetcode;

import com.sun.tools.javac.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class GFG
{ 
    static final int INT_SIZE = 32; 
      
    // Method to find the element that occur only once 
    static int getSingle(int arr[], int n) 
    { 
        int result = 0; 
        int x, sum; 
          
        // Iterate through every bit 
        for(int i=0; i<INT_SIZE; i++) 
        { 
            // Find sum of set bits at ith position in all  
            // array elements 
            sum = 0; 
            x = (1 << i); 
            for(int j=0; j<n; j++) 
            { 
                if((arr[j] & x) == 0) {
                    System.out.println(arr[j] + ": " + x);
                    sum++;
                }
            } 
            // The bits with sum not multiple of 3, are the 
            // bits of element with single occurrence. 
            if ((sum % 3) == 0) 
            result |= x; 
        } 
        return result; 
    } 
      
    // Driver method 
    public static void main(String args[]) 
    { 
        int arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 2, 2, 3, 7}; 
        int n = arr.length; 
        System.out.println("The element with single occurrence is " + getSingle(arr, n)); 
    } 

    void blah() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
    }
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (o1, o2) -> o1.length() - o2.length());
        System.out.println(Arrays.toString(strs));
        return "";
    }
} 