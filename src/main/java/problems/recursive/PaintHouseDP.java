package problems.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class PaintHouseDP {


    public static int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0],costs[i-1][1]);
        }
        int lastRow = costs.length - 1;
        return Math.min(costs[lastRow][0], Math.min(costs[lastRow][1], costs[lastRow][2]));
    }

    private static void printcost(int[][] costs) {
        for (int[] cost : costs) {
            System.out.println(Arrays.toString(cost));
        }
    }


    public static void main(String[] args) {
        int[][] input = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        System.out.println("Expected: 10, Actual: " + minCost(input));
        int[][] input2 = {{1, 2, 3},
                         {4, 2, 5},
                         {4, 2, 19}};
        System.out.println("Expected: 7, Actual: " + minCost(input2));
    }
}
