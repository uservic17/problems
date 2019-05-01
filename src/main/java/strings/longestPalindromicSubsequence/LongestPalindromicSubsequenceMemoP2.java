package strings.longestPalindromicSubsequence;

//the idea here is to store the already evaluated strings with their lengths
//map of <String, Integer>

//This solution is good but FAILING time exceeded in leetcode.. check out the topdown leetcode in the same package
//this takes 1370ms.. but leetcode one takes 60ms
//calls made 244530
public class LongestPalindromicSubsequenceMemoP2 {
    static int calls = 0;

    //    static Map<String, Integer> memo = new HashMap<>();
    public static int longestPalindromeSubseq(String s) {
        return helper(s, 0, s.length()-1, new Integer[s.length()][s.length()]);
    }
    private static int helper(String str, int left, int right, Integer[][] memo) {
        if (str == null || str.length() <= 0) return 0;
        if (left > right || left >= str.length() || right < 0) return 0;
        if (left == right) return 1;
        if (memo[left][right] != null) return memo[left][right];

        if (str.charAt(left) == str.charAt(right)) {
            memo[left][right] = 2 + helper(str, left+1, right -1, memo);
//            return memo[left][right];
        } else {
            memo[left][right] = Math.max(helper(str, left+1, right, memo),
                    helper(str, left, right-1, memo));
        }
            return memo[left][right];

    }

    public static void main(String[] args) {
        System.out.println("Should be 3 and is: " + longestPalindromeSubseq("aaa"));
        System.out.println("Should be 4 and is: " + longestPalindromeSubseq("bbbab"));
        System.out.println("Should be 11 and is: " + longestPalindromeSubseq("vickyklmykciv"));
        System.out.println("Should be 1 and is: " + longestPalindromeSubseq("b"));
        System.out.println("Should be 3 and is: " + longestPalindromeSubseq("bab"));
        System.out.println("Should be 3 and is: " + longestPalindromeSubseq("badb"));
        System.out.println("Should be 5 and is: " + longestPalindromeSubseq("ABBDCACB"));
        long start = System.currentTimeMillis();
        System.out.println("Should be 11 and is: " + longestPalindromeSubseq("vickyklmykciv"));
        System.out.println("Should be 494 and is: " + longestPalindromeSubseq("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg"));
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println("Calls made: " + calls);
    }
}
