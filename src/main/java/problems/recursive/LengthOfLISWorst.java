package problems.recursive;

import java.util.ArrayList;
import java.util.List;


//This is the WORST solution 2^n
//on top of that you are finding all the subsets too.. a lot of memory used..
//2 steps to improve
// rather than finding all subsets.. first do a simple solution in 2^n to find the longest increasing subsequence's length rather
//than the subsequence
//then we will do more optimization - memoization
public class LengthOfLISWorst {
    static int calls = 0;

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> available = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            available.add(nums[i]);
        }
        helper(result, available, new ArrayList<>());


        System.out.println("Calls made: " + calls);
        int lis = 1;
        for (List<Integer> list : result) {
            lis = Math.max(lis, list.size());
        }
        return lis;
    }

    private static void helper(List<List<Integer>> result, List<Integer> available, ArrayList<Integer> chosen) {
        calls++;
        if (available.size() == 0) {
            if (isIncreasingSubsequence(chosen)) {
                if (chosen.size() > result.size()) {
                    result.add(new ArrayList<>(chosen));
                }
            }
        } else {
            int temp = available.remove(0);
            helper(result, available, chosen);
            chosen.add(temp);
            helper(result, available, chosen);
            chosen.remove(chosen.size() - 1);
            available.add(0, temp);
        }
    }

    private static boolean isIncreasingSubsequence(ArrayList<Integer> chosen) {
        for (int i = 0; i < chosen.size() - 1; i++) {
            if (chosen.get(i) >= chosen.get(i + 1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println("LIS length: " + lengthOfLIS(new int[]{1, 2, 3, 2}));
        System.out.println("LIS length: " + lengthOfLIS(new int[]{10, 9, 2, 5, 3, 4}));
    }
}
