package strings.longestCommonSubsequence;

//this is longest common subsequence.. not substring
public class LongestCommonSubsequenceRecursive {
    static int counter = 0;
    public static int lcsLength(String str1, String str2) {
        counter++;
//        System.out.println("Counter is: " + counter);
        if (isEmpty(str1) || isEmpty(str2)) return 0;
        if (str1.charAt(0) == str2.charAt(0)) {
            return 1 + lcsLength(str1.substring(1), str2.substring(1));
        } else  {
            return Math.max(lcsLength(str1, str2.substring(1)), lcsLength(str1.substring(1), str2));
        }

    }

    private static boolean isEmpty(String str2) {
        return str2 == null || str2.length() == 0;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String s1 = "mabcvi";
        String s2 = "vaibkclmno";
//        String s1 = "hello there how are you doing?";
//        String s2 = "wow hello blah there.. what is you doing?";
        System.out.print("Longest Subsequence common in " + s1 + " and " + s2 + " is: ");
        System.out.println(lcsLength(s1, s2));
        System.out.println("Final Count of calls: " + counter);
        System.out.println("Total time taken: " + (System.currentTimeMillis() - start) + " ms");
    }
}

