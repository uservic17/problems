package strings.longestPalindromicSubsequence;

public class LongestPalindromicSubsequenceRecursive {
    static int calls = 0;
    public static int longestPalindromeSubseq(String s) {
        System.out.println(calls++);
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return 2 + longestPalindromeSubseq(s.substring(1, s.length() - 1));
        } else {
            return Math.max(longestPalindromeSubseq(s.substring(1)),
                    longestPalindromeSubseq(s.substring(0, s.length() - 1)));
        }

    }


    public static void main(String[] args) {
//        System.out.println("Should be 4 and is: " + longestPalindromeSubseq("bbbab"));
//        System.out.println("Should be 11 and is: " + longestPalindromeSubseq("vickyklmykciv"));
//        System.out.println("Should be 1 and is: " + longestPalindromeSubseq("b"));
//        System.out.println("Should be 2 and is: " + longestPalindromeSubseq("bb"));
//        System.out.println("Should be 3 and is: " + longestPalindromeSubseq("bab"));
//        System.out.println("Should be 3 and is: " + longestPalindromeSubseq("badb"));
//        System.out.println("Should be 5 and is: " + longestPalindromeSubseq("ABBDCACB"));
        long start = System.currentTimeMillis();
        System.out.println("Should be 494 and is: " + longestPalindromeSubseq("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg"));
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");
    }
}
