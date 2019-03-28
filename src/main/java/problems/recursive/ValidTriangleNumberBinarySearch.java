package problems.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Binary search approach. This is the solution 2 in leet code
2 loops still
first sort the array
i and j.. and then to find k.. you do binary search on rest of the elements

 */
public class ValidTriangleNumberBinarySearch {
    static int calls = 0;

    public static int triangleNumber(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int length = nums.length;
        int k = -1;
        for (int i = 0; i < length - 2; i++) {
            k = i + 2;
            for (int j = i + 1; j < length - 1; j++) {
                int a = nums[i];
                int b = nums[j];
                int left = k;
                int right = length - 1;
                while (left <= right) {
                    k = left + (right - left) / 2;
                    if (a + b > nums[k]) {
                        left = k + 1;
                    } else {
                        right = k - 1;
                    }
                }
                System.out.println("left: " + left);
               if ( left -j-1 > 0 )
                result += left - j - 1;
            }
        }

        return result;
    }


    public static void main(String[] args) {
//       int r =  triangleNumber(new int[]{1, 2, 3, 4, 5, 5, 6, 7, 3, 3, 4});
//       int r = triangleNumber(new int[]{2, 2, 3, 4});
//      int r =  triangleNumber(new int[]{1,2,2,3});
      int r =  triangleNumber(new int[]{0,1,1,1});
        System.out.println(r);
    }

}
