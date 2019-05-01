package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortListP3 {
    private static List<Integer> mergeSort(List<Integer> nums) {
        if (nums == null || nums.size() == 0) return nums;

        //goods here... not passing left right
        int left = 0;
        int right = nums.size();
        if (nums.size() == 1) return nums;
        int mid = left + (right - left)/2;
        //this can be good here..adding 1.. try it next time - todo List<Integer> left = nums.subList(0, nums.size()/2+ 1);
        List<Integer> leftList = mergeSort(nums.subList(left, mid));
        List<Integer> rightList = mergeSort(nums.subList(mid, right));
        return merge(leftList, rightList);


    }

    private static List<Integer> merge(List<Integer> leftList, List<Integer> rightList) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        //careful here.. dont increment i or j in the for statement.. do them in the loop
        for ( i = 0, j = 0; i < leftList.size() && j < rightList.size(); ) {
            int temp = leftList.get(i) < rightList.get(j) ? leftList.get(i++) : rightList.get(j++);
            result.add(temp);
        }
        while (i < leftList.size())
            result.add(leftList.get(i++));
        while (j < rightList.size())
            result.add(rightList.get(j++));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(mergeSort(Arrays.asList(11,12,1,8, 88, 9, 7 , 9 ,6,3,4,5)));
        System.out.println(mergeSort(Arrays.asList(1,2,3,4,5,6)));
        System.out.println(mergeSort(Arrays.asList(6,5,4,3,2,1,2,3,4,5,6)));
        System.out.println(mergeSort(Arrays.asList()));
        System.out.println(mergeSort(Arrays.asList(1)));
        System.out.println(mergeSort(Arrays.asList(1,2,1)));
    }
}