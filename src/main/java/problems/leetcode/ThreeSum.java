package problems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            if (i > 0 && nums[i-1] == nums[i]) continue;
            int desired = -first;
            helper(result, nums, desired, i);
        }
        return result;
    }
    private static void helper(List<List<Integer>> result, int[] nums, int desired, int skip) {
        int left = skip + 1;
        int right = nums.length - 1;
        while(left < right) {
             if (nums[left] + nums[right] == desired) {
                result.add(new ArrayList<>(Arrays.asList(nums[skip], nums[left], nums[right])));
                while(left < right && nums[left] == nums[left+1]) left++;
                while(left < right && nums[right] == nums[right-1]) right--;
                left++;
                right--;
            } else if (nums[left] + nums[right] < desired) {
                left++;
            } else if (nums[left] + nums[right] > desired) {
                right--;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -4}));
//        System.out.println(threeSum(new int[]{-1, 0, 1,-1,0, 2, -4}));
        System.out.println(threeSum(new int[]{5,2,3,-5,-3,-1,-1,-6,4,3,7,-5,-3,-6}));
    }
}
