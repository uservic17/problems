package meetup;

public class MinimalSumSubarray {
    public static int length(int[] nums, int target) {
        int start = 0;
        int end = 0;
        //ask interviewer if sum of all elements is guaranteed to be greater than or equal to the target
        int sum = nums[start];
        while (sum < target) {
            end++;
            sum += nums[end];
        }
        int min = end - start + 1;
        while (end < nums.length && start <= end) {
            if (sum - nums[start] >= target) {
                sum = sum - nums[start];
                start++;
            } else {
                end++;
                sum += nums[end];
            }
            min = Math.min(min, end - start + 1);
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(length(new int[]{2,3,1,2,4,3}, 7));
    }
}
