package problems.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumRecursiveBad {
    static int calls = 0;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> available = new ArrayList<>();
        for (int n : candidates) {
            available.add(n);
        }
        helper(result, available, new ArrayList<>(), target, new HashSet<>());
        return result;
    }

    private static void helper(List<List<Integer>> result, List<Integer> available, ArrayList<Integer> chosen, int target, Set<List<Integer>> set) {
//        System.out.println(chosen);
        calls ++;
        if (target == 0) {
            ArrayList<Integer> chosenones = new ArrayList<>(chosen);
//            if (!set.contains(chosenones)) {
                result.add(chosenones);
//                set.add(chosenones);
//            }
        } else {
            for (int i = 0; i < available.size(); i++) {
               int temp = available.get(0);
               if (target - temp >= 0) {
                   chosen.add(temp);
                   helper(result, available, chosen, target - temp, set);
                   available.remove(0);
                   helper(result, available, chosen, target - temp, set);
                   chosen.remove(chosen.size() - 1);
                   helper(result, available, chosen, target, set );
                   available.add(0, temp);
               }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,5}, 8));
        System.out.println("Calls made: " + calls);
    }
}
