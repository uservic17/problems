package problems.recursive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//using find subsets first and then calculate the sum
//may not be the best approach.. we could pass sum - current sum
//but lets solve this first this way
//ADDING MEMO here

//this is not a good solution.. becaseu we are creating all subsets first and then
//checking if the sum of elements in each subset is equal to the required sum
//but we can simply reduce sum by current element selected and stop when sum == 0;

// solution - check the Geeks one - Now It has been made same as the geeks solution
public class SubsetSumProblemRecursiveMemo {
    static int calls = 0;
    static Map<String, Boolean> memo = new HashMap<>();
    static long start = System.currentTimeMillis();

    public static boolean subsetSumExists(int[] nums, int S) {
        List<Integer> available = new ArrayList<>();
        for (int num : nums) {
            available.add(num);
        }
        return helper(available, new ArrayList<Integer>(), S);
    }

    private static boolean helper(List<Integer> available, ArrayList<Integer> chosen, int sum) {
        calls++;
        if (sum == 0) {
            return true;
        } else {
            if (available.size() > 0) {
                int temp = available.remove(0);

                String key = "key" + available.toString() + "sum" + sum;
                boolean without;
                if (memo.containsKey(key)) {
                    without = memo.get(key);
                } else {
                    without = helper(available, chosen, sum);
                    memo.put(key, without);
                }
                chosen.add(temp);

                boolean with;
                key = "key" + available.toString() + "sum" + (sum - temp);
                if (memo.containsKey(key)) {
                    with = memo.get(key);
                } else {
                    with = helper(available, chosen, sum - temp);
                    memo.put(key, with);
                }
                chosen.remove(chosen.size() - 1);
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
//        boolean result = subsetSumExists(new int[]{1,2,3,4,5}, 5);
        System.out.println(result);
        System.out.println("Number of calls made: " + calls);
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");

    }
}
