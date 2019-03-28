package problems.hackerRank;

public class CoinChangeNumberOfWays {
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
        int numberOfWays = 0;
        for (int i = currentCoin; i < nums.length; i++) {
            numberOfWays = numberOfWays + getWays(nums, amount - nums[i], i);
        }
        return numberOfWays;
    }
}
