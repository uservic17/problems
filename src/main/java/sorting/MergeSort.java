package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {


    private static List<Integer> mergeSort(List<Integer> nums) {
        if (nums.size() < 2) {
            return null;
        } else {
            //split the array in half .. get 2 different arrays
            List<Integer> left = nums.subList(0, nums.size()/2+ 1);
            List<Integer> right = nums.subList(nums.size()/2 + 1, nums.size() );
            //sort the halves
            mergeSort(left);
            mergeSort(right);
            //merge the halvese
            return merge(left, right);



        }

    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (i < left.size() && j < right.size() ) {
            if (left.get(i) < right.get(j)) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }
        if (i == left.size() && j == right.size()) {
            return result;
        } else if (i == left.size()) {
            for (int blah = j; blah < right.size(); blah++) {
                result.add(right.get(blah));
            }
        } else {
            for (int blah = i; blah < left.size(); blah++) {
                result.add(left.get(blah));
            }
        }


        return result;
    }

    public static void main(String[] args) {
        int[] nums = {11, 2, 4, 5, 2, 1, 4, 6};
        System.out.println(mergeSort(new ArrayList<>(Arrays.asList(1, 2, 3))));


    }
}
