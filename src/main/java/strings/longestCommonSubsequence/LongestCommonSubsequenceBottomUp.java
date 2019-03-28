package strings.longestCommonSubsequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//this is longest common subsequence.. not substring
public class LongestCommonSubsequenceBottomUp {
    public static int lcsLength(String str1, String str2) {
        return helper(str1.toCharArray(), str2.toCharArray());
        }

    private static int helper(char[] array1, char[] array2) {
        int max = 0;
        int m = array1.length;
        int n = array2.length;
        int[][] matrix = new int[m+1][n+1];
        for (int i = 0; i<=m; i++) {
            for (int j = 0; j<=n; j++) {
                if (i==0 || j==0) {
                    matrix[i][j] = 0; //to populate first row and first column as zero;
                } else {
                    if (array1[i-1] == array2[j-1]) {  //todo.. take care here
                        matrix[i][j] = 1 + matrix[i-1][j-1];
                        max = Math.max(max, matrix[i][j]);
                    } else {
                        matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                    }
                }
            }
        }
        System.out.println("Max is: " + max);
        System.out.println("And answer could also be gotten from the last element of the matrix which is: " + matrix[m][n]);
        return max;
    }


    private static boolean isEmpty(String str2) {
        return str2 == null || str2.length() == 0;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        String s1 = "vaiaia";
//        String s2 = "aaa";
//        String s1 = "mabcvi";
//        String s2 = "vaibkclmno";
        String s1 = "hello there how are you doing?";
        System.out.println("s1 length is: " + s1.length());
        String s2 = "wow hello blah there.. how are you doing?";
        System.out.print("Longest Subsequence common in " + s1 + " and " + s2 + " is: ");
        System.out.println(lcsLength(s1, s2));
        System.out.println("Total time taken: " + (System.currentTimeMillis() - start) + " ms");
    }
}

