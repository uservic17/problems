package problems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] twod = {{1,3},{2,6},{8,10},{15,18}};
//        int[][] twod = {{1,4},{4,5}};

        System.out.println(Arrays.deepToString(twod));
        System.out.println(Arrays.deepToString(merge(twod)));
    }

    private static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals,(Comparator.comparingInt(o -> o[0])));
        int index = 0;
        for (int[] interval : intervals) {
            if (result.isEmpty()) {
                result.add(interval);
            } else if (result.get(index)[1] >= interval[0]) {
                result.get(index)[1] = Math.max(result.get(index)[1], interval[1]);
            } else {
                index++;
                result.add(interval);
            }
        }
        return result.toArray(new int[0][]);
    }
}