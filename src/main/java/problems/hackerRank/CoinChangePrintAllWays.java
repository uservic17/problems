package problems.hackerRank;

import java.util.ArrayList;

public class CoinChangePrintAllWays {
    public static int calls = 0;
    private static int combinations = 0;
    public static void main(String[] args) {
        int[] nums = {1,5,6};
//        int[] nums = {1,2};

        long current = System.currentTimeMillis();
        getWays(nums, 100, new ArrayList<Integer>(), 0);
        System.out.println("Time taken: " + (System.currentTimeMillis() - current)/1000.0 + " secs");
        System.out.println("Number of combinations: " + combinations);
        System.out.println("Number of calls: " + calls);
    }

    private static void getWays(int[] nums, int amount , ArrayList<Integer> chosen, int currentCoin) {
        calls++;
        if (amount == 0) {
            combinations++;
//            System.out.println("number of combinations:" + combinations);
//            System.out.println("number of calls made: " + calls);
            System.out.println(chosen);
        } else if ( amount < 0) {
            return;
        } else {
            for (int i = currentCoin; i < nums.length; i++) {
                chosen.add(nums[i]);
                getWays(nums, amount - nums[i], chosen, i);
                chosen.remove(chosen.size()-1);
            }
        }

    }
}
