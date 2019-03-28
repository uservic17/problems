package problems.recursive;

import java.util.HashMap;
import java.util.Map;

//rather than using backtracking and creating all subsets..
// this is an easier or simpler way.. not particularly easy approach to think about on the spot
public class TargetSumSimpleMemo {
    int calls = 0;
    Map<String, Integer> memo = new HashMap<>();
    public int findTargetSumWays(int[] nums, int S) {
        return calculate(nums, 0, S);
    }

    private int calculate(int[] nums, int index, int sum) {
        calls++;
        if (index == nums.length) {
            if (sum == 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            int current = nums[index];
            // index
            String plusKey = sum + "plus" + index; //I just roughly made these and they work
            String minusKey = sum + "minus" + index ;
            int plus ;
            int minus;
            if (memo.containsKey(plusKey)) {
                plus = memo.get(plusKey);
            } else {
                 plus = calculate(nums, index + 1, sum + current);
                 memo.put(plusKey, plus);

            }
            if (memo.containsKey(minusKey)) {
                minus = memo.get(minusKey);
            } else {
                minus = calculate(nums, index + 1, sum - current);
                memo.put(minusKey, minus);
            }
            return minus + plus;
        }
    }

    public static void main(String[] args) {
        TargetSumSimpleMemo tss = new TargetSumSimpleMemo();
        long start = System.currentTimeMillis();
        int result = tss.findTargetSumWays(new int[]{25,33,27,23,46,16,10,27,33,2,12,2,29,44,49,40,32,46,7,50}, 4);
//        int result = tss.findTargetSumWays(new int[]{1,1,1,1,1}, 1);
        System.out.println(result);
        System.out.println("Number of calls made: " + tss.calls);
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");

    }
}
