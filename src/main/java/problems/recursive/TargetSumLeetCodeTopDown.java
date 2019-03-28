package problems.recursive;

import java.util.Arrays;

public class TargetSumLeetCodeTopDown {
    int count = 0;
    int calls = 0;
    public int findTargetSumWays(int[] nums, int S) {
        int[][] memo = new int[nums.length][2001];
        for (int[] row: memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        return calculate(nums, 0, 0, S, memo);
    }
    public int calculate(int[] nums, int i, int sum, int S, int[][] memo) {
        calls++;
        if (i == nums.length) {
            if (sum == S)
                return 1;
            else
                return 0;
        } else {
            if (memo[i][sum + 1000] != Integer.MIN_VALUE) {
                return memo[i][sum + 1000];
            }
            int add = calculate(nums, i + 1, sum + nums[i], S, memo);
            int subtract = calculate(nums, i + 1, sum - nums[i], S, memo);
            memo[i][sum + 1000] = add + subtract;
            return memo[i][sum + 1000];
        }
    }
    public static void main(String[] args) {
        TargetSumLeetCodeTopDown tss = new TargetSumLeetCodeTopDown();
        long start = System.currentTimeMillis();
        int result = tss.findTargetSumWays(new int[]{25,33,27,23,46,16,10,27,33,2,12,2,29,44,49,40,32,46,7,50}, 4);
//        int result = tss.findTargetSumWays(new int[]{1,1,1,1,1}, 1);
        System.out.println(result);
        System.out.println("Number of calls made: " + tss.calls);
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");

    }
}
