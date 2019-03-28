package problems.hackerRank;

public class CoinChangeNumberOfWaysSimple {
    public static int calls = 0;
    public static void main(String[] args) {
        int[] nums = {1,5,6};

        System.out.println("Number of Ways: " + getWays(nums, 100, 0));
        System.out.println("Number of calls: " + calls);
    }

    private static int getWays(int[] nums, int amount, int currentCoin) {
        calls++;
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 ) {
            return 0;
        }
        if (currentCoin >= nums.length || amount < nums[currentCoin]) {
            return 0;
        }
        //return ways that include this coin and the solution that does not include this coin
        return getWays(nums, amount, currentCoin + 1)
                + getWays(nums, amount - nums[currentCoin], currentCoin);
    }
}
