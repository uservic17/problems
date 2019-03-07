package problems.recursive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations2 {
    static public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> available = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            available.add(nums[i]);
        }
        foo(nums, available, new ArrayList<Integer>(), result);
//        System.out.println(result.size());
        return new ArrayList<>(result);
    }

    static private void foo(int[] nums, List<Integer> available, List<Integer> chosen, Set<List<Integer>> result) {
        if (available.isEmpty()) {
            result.add(new ArrayList(chosen));
        } else {

            for (int i = 0; i < available.size(); i++) {
                int temp = available.get(i);
                chosen.add(temp);
                available.remove(i);
                foo(nums, available, chosen, result);
                chosen.remove(chosen.size() - 1);
                available.add(i, temp);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2, 2, 2}));
    }
}