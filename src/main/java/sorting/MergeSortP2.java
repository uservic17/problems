package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSortP2 {
    private static List<Integer> mergeSort(List<Integer> nums) {
        if (nums == null || nums.size() == 0) return nums;

        // we will divide them and then we will sort them

     return helper(nums, 0, nums.size() - 1);
    }

    private static List<Integer> helper(List<Integer> nums, int left, int right) {
        if (left > right) return null;
        if (left == right) return new ArrayList<>(Collections.singletonList(nums.get(left)));

        int mid = left + (right - left)/2;
        List<Integer> leftList = helper(nums, left, mid);
        List<Integer> rightList = helper(nums, mid + 1, right);

        //merge the lists
        List<Integer> result = new ArrayList<>();
        while (leftList != null && rightList != null && !leftList.isEmpty() && !rightList.isEmpty()) {
            if (leftList.get(0) < rightList.get(0)) {
                result.add(leftList.remove(0));
            } else {
                result.add(rightList.remove(0));
            }
        }
        result.addAll(leftList);
        result.addAll(rightList);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(mergeSort(Arrays.asList(11,12,1,8, 88, 9, 7 , 9 ,6,3,4,5)));
    }
}
