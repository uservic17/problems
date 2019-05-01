package problems.recursive;

import java.util.Arrays;

public class LISDP {
    public static int lengthOfLIS(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int temp = 0;
            for (int j= 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    temp = Math.max(temp, 1 + result[j]);
                } else {
                    temp = Math.max(temp, 1);
                }
            }
            result[i] = temp;
            max = Math.max(max, result[i]);
        }
//        System.out.println(Arrays.toString(result));
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
//        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
//        System.out.println(lengthOfLIS(new int[]{4,10,4,3,8,9}));
    }
}
