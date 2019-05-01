package problems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSumiiRecursive {
    static int calls = 0;

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> available = new ArrayList<>();
        for (int n : candidates) {
            available.add(n);
        }
        Collections.sort(available);
        helper(result, available, new ArrayList<>(), target);
        return result;
    }

    private static void helper(List<List<Integer>> result, List<Integer> available, ArrayList<Integer> chosen, int target) {
        calls++;
//        System.out.println(chosen);
        if (target == 0) {
            ArrayList<Integer> chosenones = new ArrayList<>(chosen);
            result.add(chosenones);
        } else if (available.size() > 0) {
            if (chosen.size() == 0 || available.get(0) != chosen.get(chosen.size() - 1)) {
                if (target - available.get(0) >= 0) {
                    int temp = available.remove(0);
                    chosen.add(temp);
                    helper(result, available, chosen, target - temp);
                    chosen.remove(chosen.size() - 1);
//                    helper(result, available, chosen, target);
//                    available.add(0, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(combinationSum2(new int[]{2,3,5}, 8));
//        System.out.println(combinationSum2(new int[]{3,6,7}, 808));
//        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
        System.out.println("Calls made: " + calls);
    }
}
