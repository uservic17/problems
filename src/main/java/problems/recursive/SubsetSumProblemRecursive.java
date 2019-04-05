package problems.recursive;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

//using find subsets first and then calculate the sum
//may not be the best approach.. we could pass sum - current sum
//but lets solve this first this way
public class SubsetSumProblemRecursive {
    static int calls = 0;

    public static boolean subsetSumExists(int[] nums, int S) {
        List<Integer> available = new ArrayList<>();
        for (int num : nums) {
            available.add(num);
        }
        return helper(available, new ArrayList<Integer>(), S);
    }
    private static boolean helper(List<Integer> available, ArrayList<Integer> chosen, int sum) {
        calls++;
        if (available.size() == 0) {
            if (chosen.stream().mapToInt(Integer::intValue).sum() == sum) {
                System.out.println(chosen);
                return true;
            } else return false;
        } else {
            int temp = available.remove(0);
            boolean without = helper(available, chosen, sum);
            chosen.add(temp);
            boolean with = helper(available, chosen, sum);
            chosen.remove(chosen.size()-1);
            available.add(0, temp);

            return with || without;

        }

//[0,[-1],[0,[-1]]]
        //-1 + 2*-1 + 0*3
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        boolean result = subsetSumExists(new int[]{25,33,27,23,46,16,10,27,33,2,12,2,29,44,49,40,32,46,7,50}, 4);
//        boolean result = subsetSumExists(new int[]{1,1,1,1,1}, 1);
        System.out.println(result);
        System.out.println("Number of calls made: " + calls);
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");

    }
}
