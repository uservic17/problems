package problems.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TargetSumAllWays {
    static int calls = 0;
    public static int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return 0;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> available = new ArrayList<>();
        for (int num : nums) {
            available.add(num);
        }
        helper(result, available, new ArrayList<>(), S);
        System.out.println(result);
        System.out.println("Number of calls made: " + calls);
        return result.size();
    }

    private static void helper(List<List<Integer>> result, List<Integer> available, ArrayList<Integer> chosen, int sum) {
        calls++;
        if (available.size() == 0) {
//            System.out.println(chosen);
            if (chosen.stream().mapToInt(Integer::valueOf).sum() == sum) {
                result.add(new ArrayList<>(chosen));
            }
        } else {
            int temp = available.remove(0);
            chosen.add(temp);
            helper(result, available, chosen, sum);
            chosen.remove(chosen.size() - 1);
            chosen.add(-temp);
            helper(result, available, chosen, sum);
            chosen.remove(chosen.size() - 1);
            available.add(0, temp);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(findTargetSumWays(new int[]{25,33,27,23,46,16,10,27,33,2,12,2,29,44,49,40,32,46,7,50}, 4));
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");
    }
}
//[25,33,27,23,46,16,10,27,33,2,12,2,29,44,49,40,32,46,7,50]
//4