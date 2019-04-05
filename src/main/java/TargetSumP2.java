import java.util.Arrays;

public class TargetSumP2 {
    static int calls = 0;

    public static int findTargetSumWays(int[] nums, int S) {
        int[][] memo = new int[nums.length][2001]; //this is from requirements in teh question.. selecting matrix size is the key
        for (int[] array : memo) {
            Arrays.fill(array, Integer.MIN_VALUE);
        }
        return helper(memo, nums, 0, S);

    }

    private static int helper(int[][] memo, int[] nums, int index, int sum) {
        calls++;
        if (index == nums.length) {
            return sum == 0 ? 1 : 0;
        } else {
            int taken;
            int nottaken;
            if (memo[index][sum + 1000] != Integer.MIN_VALUE) return memo[index][sum + 1000];
            taken = helper(memo, nums, index + 1, sum - nums[index]);
            nottaken = helper(memo, nums, index + 1, sum + nums[index]);
            memo[index][sum + 1000] = taken + nottaken;
            return memo[index][sum + 1000];
        }
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        int result = findTargetSumWays(new int[]{25,33,27,23,46,16,10,27,33,2,12,2,29,44,49,40,32,46,7,50}, 4);
//        int result = findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 1);
//        int result = findTargetSumWays(new int[]{-3, 1, 3, 5}, 6);
//        int result = findTargetSumWays(new int[]{1000}, -1000);
        int result = findTargetSumWays(new int[]{1,2,7,9,981}, 1000000000);

        System.out.println(result);
        System.out.println("Number of calls made: " + calls);
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");

    }

}
