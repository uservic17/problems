package problems.recursive;


//This is the better than worst WORST solution 2^n where you are find all subsequences.. here we are just finding the length
//then we will do more optimization - memoization
public class LengthOfLISRecursive {
    static int calls = 0;

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int result = helper(nums, Integer.MIN_VALUE, 0);

        System.out.println("Calls made: " + calls);
        return result;
    }

    private static int helper(int[] nums, int number, int index) {

        calls++;
        int taken = 0;

        if (index < nums.length) {
            if (number < nums[index]) {
                taken = 1 + helper(nums, nums[index], index + 1);
            }
            int notTaken = helper(nums, number, index + 1);
            return Math.max(taken, notTaken);
        }
        return 0;
    }


    public static void main(String[] args) {
//        System.out.println("LIS length: " + lengthOfLIS(new int[]{1, 2, 3, 2}));
        System.out.println("LIS length: " + lengthOfLIS(new int[]{10, 9, 2, 5, 3, 4}));
    }
}
