package problems.recursive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Base condition - rather than checking if available size is 0
//we can check if the passed sum is 0 and deduct the chosen element from the sum everytime

//and add memo to it
//uncomment chosen if you want to print the list of subset that equals to the sum

public class SubsetSumProblemRecursiveGeeks {
    static int calls = 0;
    static Map<String, Boolean> memo = new HashMap<>();

    public static boolean subsetSumExists(int[] nums, int S) {
        List<Integer> available = new ArrayList<>();
        for (int num : nums) {
            available.add(num);
        }
        return helper(available, S);
    }

    private static boolean helper(List<Integer> available, int sum) {
        calls++;
        if (sum == 0) {
//            System.out.println(chosen);
            return true;
        } else {
            if (available.size() > 0) {
                int temp = available.remove(0);
                String key = "key" + available.toString() + "sum" + sum;
                boolean without;
                if (memo.containsKey(key)) {
                    without = memo.get(key);
                } else {
                     without = helper(available, sum);
                     memo.put(key, without);
                }
//                chosen.add(temp);
                key = "key" + available.toString() + "sum" + (sum - temp);
                boolean with;
                if (memo.containsKey(key)) {
                    with = memo.get(key);
                } else {
                    with = helper(available, sum - temp);
                    memo.put(key, with);
                }
//                chosen.remove(chosen.size() - 1);
                available.add(0, temp);

                return with || without;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        boolean result = subsetSumExists(new int[]{25, 33, 27, 23, 46, 16, 10, 27, 33, 2, 12, 2, 29, 44, 49, 40, 32, 46, 7, 50}, 4);
//        boolean result = subsetSumExists(new int[]{1,1,1,1,1}, 1);
        System.out.println(result);
        System.out.println("Number of calls made: " + calls);
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");

    }
}
