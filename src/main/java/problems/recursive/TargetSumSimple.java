package problems.recursive;

//rather than using backtracking and creating all subsets..
// this is an easier or simpler way.. not particularly easy approach to think about on the spot
public class TargetSumSimple {
    int count = 0;
    int calls = 0;
    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, S);
        return count;
    }

    private void calculate(int[] nums, int index, int sum) {
        calls++;
        if (index == nums.length) {
            if (sum == 0) count++;
        } else {
            int current = nums[index];
            calculate(nums, index + 1, sum - current);
            calculate(nums, index + 1, sum + current);
        }
    }






























    public static void main(String[] args) {
        TargetSumSimple tss = new TargetSumSimple();
        long start = System.currentTimeMillis();
        int result = tss.findTargetSumWays(new int[]{25,33,27,23,46,16,10,27,33,2,12,2,29,44,49,40,32,46,7,50}, 4);
//        int result = tss.findTargetSumWays(new int[]{1,1,1,1,1}, 1);
        System.out.println(result);
        System.out.println("Number of calls made: " + tss.calls);
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");

    }
}
