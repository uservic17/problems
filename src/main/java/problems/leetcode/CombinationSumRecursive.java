package problems.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumRecursive {
    static int calls = 0;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> available = new ArrayList<>();
        for (int n : candidates) {
            available.add(n);
        }
        helper(result, available, new ArrayList<>(), target, 0);
        return result;
    }

    private static void helper(List<List<Integer>> result, List<Integer> available, ArrayList<Integer> chosen, int target, int start) {
        calls ++;
        if (target == 0) {
            ArrayList<Integer> chosenones = new ArrayList<>(chosen);
                result.add(chosenones);
        } else {
            for (int i = start; i < available.size(); i++) {  //todo starting from start is the idea
               int temp = available.get(i);
               if (temp == 0) continue;
               if (target - temp >= 0) {
                   chosen.add(temp);
                   helper(result, available, chosen, target - temp, i); //change start.. todo similar to factor combinations
                   chosen.remove(chosen.size() - 1);
               }
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(combinationSum(new int[]{2,3,5}, 8));
//        System.out.println(combinationSum(new int[]{3,6,7}, 808));
        System.out.println(combinationSum(new int[]{0,0,3,3,4}, 12));
        System.out.println("Calls made: " + calls);
    }
}
