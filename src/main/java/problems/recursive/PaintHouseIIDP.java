package problems.recursive;

import java.util.Arrays;

public class PaintHouseIIDP {


    public static int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < costs[i].length; j++) {
                costs[i][j] += findMinFromRow(costs[i-1], j);
            }
        }
        int lastRow = costs.length - 1;
        return findMinFromRow(costs[lastRow], -1); //since this is the final row.. we don't want to skip any index
    }

    private static int findMinFromRow(int[] row, int skipIndex) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row.length; i++) {
            if (i == skipIndex) continue;
            int value = row[i];
            min = Math.min(min, value);
        }
        return min;
    }

    private static void printcost(int[][] costs) {
        for (int[] cost : costs) {
            System.out.println(Arrays.toString(cost));
        }
    }


    public static void main(String[] args) {
        int[][] input = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        System.out.println("Expected: 10, Actual: " + minCostII(input));
        int[][] input2 = {{1, 2, 3},
                         {4, 2, 5},
                         {4, 2, 19}};
        System.out.println("Expected: 7, Actual: " + minCostII(input2));
    }
}
