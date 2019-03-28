package strings.longestPalindromicSubsequence;

import java.util.HashMap;
import java.util.Map;

//the idea here is to store the already evaluated strings with their lengths
//map of <String, Integer>

//This solution is good but FAILING time exceeded in leetcode.. check out the topdown leetcode in the same package
//this takes 1370ms.. but leetcode one takes 60ms
//calls made 244530
public class LongestPalindromicSubsequenceMemo {
    static int calls = 0;

    //    static Map<String, Integer> memo = new HashMap<>();
    public static int longestPalindromeSubseq(String s) {

        Integer[][] memo = new Integer[s.length()][s.length()];
        return longestPalindromeSubseq(s, memo, 0, s.length() - 1);
    }

    public static int longestPalindromeSubseq(String s, Integer[][] memo, int start, int end) {
        calls++;
        if (start > end) return 0;
        if (start == end) return 1;
        if (end < 0 || start >= s.length()) return 0;

        if (memo[start][end] != null) return memo[start][end];
        if (s.charAt(start) == s.charAt(end)) {
            memo[start][end] = longestPalindromeSubseq(s, memo, start + 1, end - 1);
            return 2 + memo[start][end];
        } else {
            int first = longestPalindromeSubseq(s, memo, start, end - 1);
            memo[start][end - 1] = first;
            int second = longestPalindromeSubseq(s, memo, start + 1, end);
            memo[start + 1][end] = first;

            return Math.max(first, second);
        }

    }


    public static void main(String[] args) {
//        System.out.println("Should be 4 and is: " + longestPalindromeSubseq("bbbab"));
//        System.out.println("Should be 11 and is: " + longestPalindromeSubseq("vickyklmykciv"));
//        System.out.println("Should be 1 and is: " + longestPalindromeSubseq("b"));
//        System.out.println("Should be 3 and is: " + longestPalindromeSubseq("bab"));
//        System.out.println("Should be 3 and is: " + longestPalindromeSubseq("badb"));
//        System.out.println("Should be 5 and is: " + longestPalindromeSubseq("ABBDCACB"));
        long start = System.currentTimeMillis();
//        System.out.println("Should be 2 and is: " + longestPalindromeSubseq("vickyklmykciv"));
        System.out.println("Should be 494 and is: " + longestPalindromeSubseq("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg"));
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println("Calls made: " + calls);
    }
}
