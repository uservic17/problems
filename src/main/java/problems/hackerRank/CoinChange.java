package problems.hackerRank;

import java.util.HashMap;
import java.util.Map;

/**
 * You are working at the cash counter at a fun-fair, and you have different types of coins available to you in infinite quantities.
 * The value of each coin is already given. Can you determine the number of ways of making change for a particular number of units
 * using the given types of coins?
 * <p>
 * For example, if you have 3 types of coins, and the value of each type is given as 1,2,3 respectively,
 * you can make change for 4 units in four ways: 1,1,1,1 - 1,1,2 - 2,2 - 1,3.
 */
public class CoinChange {
  public static void main(String[] args) {
    int[] coins = {1, 2,3,4};
    int money = 1000;
    Map<String, Long> lookup= new HashMap<>();
    long current = System.currentTimeMillis();
    System.out.println(getWays(money, coins, lookup));
    System.out.println("time taken: " + (System.currentTimeMillis() - current));
  }

  private static long getWays(int money, int[] coins, Map<String, Long>  lookup) {
    return getWays(money, coins, 0, lookup);
  }

  private static long getWays(int money, int[] coins, int index, Map<String, Long>  lookup) {
    if (lookup.containsKey("money"+money+":index"+index)) {
      return lookup.get("money"+money+":index"+index);
    }
    if (money == 0) return 1;
    if (index >= coins.length) return 0;
    long ways = 0;
    int amountWithCoins = 0;
    while (amountWithCoins <= money) {
      int diff = money - amountWithCoins;
      ways += getWays(diff, coins, index+1, lookup);
      amountWithCoins += coins[index];
    }
    lookup.put("money"+money+":index"+index, ways);
    return ways;
  }
}
