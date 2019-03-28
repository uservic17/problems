package problems.recursive;


//todo not working
//This is the better than worst WORST solution 2^n where you are find all subsequences.. here we are just finding the length
//then we will do more optimization - memoization
public class LengthOfLISRecursiveMemo {
    static int calls = 0;

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[][] memo = new int[nums.length + 1][nums.length+1];
        int result = helper(memo, nums, Integer.MIN_VALUE, 0);

        System.out.println("Calls made: " + calls);
        return result;
    }

    private static int helper(int[][] memo, int[] nums, int number, int index) {

        calls++;
        int taken = 0;
        int notTaken = 1;
        if (index < nums.length) {
            if (number < nums[index]) {
                if (memo[index+1][index+2] != 0) {
                    taken = memo[index+1][index+2];
                } else {
                    taken = 1 + helper(memo, nums, nums[index], index + 1);
                    memo[index+1][index+2] = taken;
                }
            }
            if (memo[index][index + 1] != 0) {
                notTaken = memo[index][index + 1];
            } else {
                notTaken = helper(memo, nums, number, index + 1);
                memo[index][index + 1] = notTaken;
            }

            return Math.max(taken, notTaken);
        }
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println("LIS length: " + lengthOfLIS(new int[]{1, 2, 3, 2}));
        System.out.println("LIS length: " + lengthOfLIS(new int[]{10, 9, 2, 5, 3, 4}));
    }
}
