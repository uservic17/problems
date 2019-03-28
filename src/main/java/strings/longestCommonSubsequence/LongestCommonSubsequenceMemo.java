package strings.longestCommonSubsequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//this is longest common subsequence.. not substring
public class LongestCommonSubsequenceMemo {
    static int counter = 0;
    static Map<String, Integer> memo = new HashMap<>();
    public static int lcsLength(String str1, String str2) {
        counter++;
//        System.out.println("Counter is: " + counter);
        if (isEmpty(str1) || isEmpty(str2)) return 0;
        if (str1.charAt(0) == str2.charAt(0)) {
            String substring1 = str1.substring(1);
            String substring2 = str2.substring(1);
            String key = substring1 + "%" + substring2;
            if (memo.containsKey(key)) {
                return 1 + memo.get(key);
            }
            int recur = lcsLength(substring1, substring2);
            memo.put(key, recur);
            return 1 + recur;
        } else  {
            String key1 = str1 + "%" + str2.substring(1);
            String key2 = str1.substring(1) + "%" + str2;
            int recur1 = 0;
            int recur2 = 0;
            if (memo.containsKey(key1)) {
                recur1 = memo.get(key1);
            } else {
                recur1 = lcsLength(str1, str2.substring(1));
                memo.put(key1, recur1);
            }
            if (memo.containsKey(key2)) {
                recur2 = memo.get(key2);
            } else {
                recur2 = lcsLength(str1.substring(1), str2);
                memo.put(key2, recur2);
            }
            return Math.max(recur1, recur2);
        }

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
        System.out.println("Final Count of calls: " + counter);
        System.out.println("Total time taken: " + (System.currentTimeMillis() - start) + " ms");
        System.out.println("Map size: " + memo.size());
        Set<String> set = new HashSet<>();
        for (Map.Entry<String, Integer> entry: memo.entrySet()) {
//            System.out.println(entry.getKey());
            set.add(entry.getKey());
        }
        System.out.println("Set size: " + set.size());
    }
}

