package problems.recursive;

public class LISRecurP2 {
    public static int lengthOfLIS(int[] nums) {
        return helper(nums, Integer.MIN_VALUE, 0);
    }

    private static int helper(int[] nums, int prev, int start) {
        if (start == nums.length) return 0;
        else {
            int taken = 0;
            if (nums[start] > prev) {
                taken = 1 + helper(nums, nums[start], start + 1);
            }
            int nottaken = helper(nums, nums[start], start + 1);
            return Math.max(taken, nottaken);
        }

    }


    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
