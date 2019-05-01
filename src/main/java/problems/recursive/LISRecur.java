package problems.recursive;

import java.util.Arrays;

public class LISRecur {
    public static int lengthOfLIS(int[] nums) {
        return helper(nums, Integer.MIN_VALUE, 0);
    }
    private static int helper(int[] nums, int prev, int index) {
        printArray(nums, index, prev);
        if (index == nums.length) {
            return 0;
        } else {
            int taken = 0;
            if (nums[index] > prev) {
                taken = 1 + helper(nums, nums[index], index + 1);
            }
            int nottaken = helper(nums, prev, index + 1);
            return Math.max(taken, nottaken);
        }
    }

    private static void printArray(int[] nums, int index, int prev) {
        System.out.print("prev: " + prev + " and nums as: ");
        for (int i = index; i < nums.length - 1; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.print(nums[nums.length - 1]);
        System.out.println("");
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
