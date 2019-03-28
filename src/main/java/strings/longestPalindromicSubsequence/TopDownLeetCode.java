package strings.longestPalindromicSubsequence;

//time taken to run = 60secs, 37 secs
//calls made 608856

public class TopDownLeetCode {
    static int calls = 0;

    static public int longestPalindromeSubseq(String s) {
        return helper(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }

    static private int helper(String s, int start, int end, Integer[][] memo) {
        calls++;
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        if (start > end) return 0;
        if (start == end) return 1;

        if (s.charAt(start) == s.charAt(end)) {
            memo[start][end] = helper(s, start + 1, end - 1, memo) + 2;
        } else {
            memo[start][end] = Math.max(helper(s, start + 1, end, memo), helper(s, start, end - 1, memo));
        }
        return memo[start][end];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        System.out.println("Should be 2 and is: " + longestPalindromeSubseq("vickyklmykciv"));
        System.out.println("Should be 494 and is: " + longestPalindromeSubseq("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg"));
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println("Calls made: " + calls);
    }
}