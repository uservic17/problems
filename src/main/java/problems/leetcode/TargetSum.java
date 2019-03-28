package problems.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TargetSum {
    public static int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return 0;
        List<Integer> available = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            available.add(nums[i]);
        }
        return helper(available, new ArrayList<Integer>(), S);
    }

    private static int helper(List<Integer> available, ArrayList<Integer> chosen, int sum) {
        int result = 0;
        if (available.size() == 0) {
            if (chosen.stream().mapToInt(Integer::valueOf).sum() == sum) {
                return 1;
            } else {
                return 0;
            }
        } else {
            int temp = available.remove(0);
            chosen.add(temp);
             result += helper(available, chosen, sum);
             chosen.remove(chosen.size() - 1);
             chosen.add(-temp);
             result += helper(available, chosen, sum);
             chosen.remove(chosen.size() -1 );
             available.add(0, temp);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1}, 10));
    }
}
