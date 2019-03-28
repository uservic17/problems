package problems.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
brute force approach 1
- find all combinations of 3
and then only count the ones that satisfy the condition - nopes

rather sort them and do not even call the method to check isValidTriangle
 */
public class ValidTriangleNumberRecur {
    static int calls = 0;

    public static int triangleNumber(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> available = new ArrayList<>();
        for (int n : nums) {
            available.add(n);
        }
        Collections.sort(available);
        helper(nums, result, available, new ArrayList<>());
//        System.out.println(result);
//        System.out.println("Result size: " + result.size());
//        System.out.println("Number of calls: " + calls);
        return result.size();
    }

    private static void helper(int[] nums, List<List<Integer>> result, List<Integer> available, ArrayList<Integer> chosen) {
        calls++;
        if (chosen.size() == 3 /*&& isValidTriangle(chosen)*/) {
            result.add(new ArrayList<>(chosen));
        } else {
            if (available.size() > 0 && chosen.size() < 3) {
                if (chosen.size() < 2 || chosen.get(0) + chosen.get(1) > available.get(0)) {
                    int temp = available.remove(0);
                    chosen.add(temp);
                    helper(nums, result, available, chosen);
                    chosen.remove(chosen.size() - 1);
                    helper(nums, result, available, chosen);
                    available.add(0, temp);
                }
            }
        }
    }

    private static boolean isValidTriangle(ArrayList<Integer> chosen) {
        if (chosen.size() != 3) return false;
        int a = chosen.get(0);
        int b = chosen.get(1);
        int c = chosen.get(2);
        return a + b > c && (b + c) > a && (a + c) > b;
    }

    public static void main(String[] args) {
//        triangleNumber(new int[]{1, 2, 3, 4, 5,5,6,7,3,3,4});
        triangleNumber(new int[]{2, 2, 3, 4});
    }

}
