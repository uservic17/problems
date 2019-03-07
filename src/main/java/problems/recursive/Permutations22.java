package problems.recursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//using hashmap
public class Permutations22 {
    static public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> available = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            available.add(nums[i]);
        }
        //build a map

        foo(nums, available, new ArrayList<>(), result);
        System.out.println(result.size());
        return result;
    }

    static private void foo(int[] nums, List<Integer> available, List<Integer> chosen, List<List<Integer>> result) {
        if (chosen.size() == nums.length) {
            result.add(new ArrayList<>(chosen));
        } else {

            for (int i = 0; i < available.size(); i++) {
                if (i - 1>=0 && available.get(i).equals(available.get(i - 1))) continue;
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
        System.out.println(permuteUnique(new int[]{3,3,0,3}));
    }
}