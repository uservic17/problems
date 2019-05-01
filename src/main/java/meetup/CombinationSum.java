package meetup;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int calls = 0;

    public static List<List<Integer>> allSubsets(int[] nums, int target, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, result, new ArrayList<>(), target, k, 0, k);
        return result;
    }

    private static void helper(int[] nums, List<List<Integer>> result, ArrayList<Integer> chosen, int target, int k, int start, int count) {
        calls++;
        if (start >= nums.length) return;
        if (target == 0 && chosen.size() == k) {
            result.add(new ArrayList<>(chosen));
        } else {
            if (target >= nums[start] ) {
                chosen.add(nums[start]);
                helper(nums, result, chosen, target - nums[start], k, start + 1,count -1 );
                chosen.remove(chosen.size() - 1);
                helper(nums, result, chosen, target, k, start + 1, count - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(allSubsets(nums, 9, 2));
        System.out.println("Number of calls: " + calls);
    }
}
