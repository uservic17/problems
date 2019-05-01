package problems.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    static int calls = 0;

    public static List<List<Integer>> getFactors(int n) {

        List<List<Integer>> result = new ArrayList<>();
        if (n <= 3) return result;
        helper(result, n, new ArrayList<>(), 2);
        return result;
    }

    private static void helper(List<List<Integer>> result, int n, ArrayList<Integer> chosen, int start) {
        calls++;
        if (n <= 1) {
            System.out.println(chosen);
            result.add(new ArrayList<>(chosen));
        } else {
            for (int i = start; i <= n; i++) {
                if (n % i == 0) {
                    chosen.add(i);
                    helper(result, n / i, chosen, i);
                    chosen.remove(chosen.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getFactors(32));
        System.out.println("Number of calls made: " + calls);
    }
}
