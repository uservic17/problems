package problems.recursive;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class PaintHouse {

    static int calls = 0;
    public static int minCost(int[][] costs) {
        calls = 0;
        AtomicInteger result = new AtomicInteger(Integer.MAX_VALUE);
        helper(costs, new ArrayList<>(), 0, -1, result);
        return result.get();
    }

    private static void helper(int[][] costs, ArrayList<Integer> chosen, int row, int column, AtomicInteger result) {
        calls++;
//        if (chosen.size() == costs.length) {
        if (row == costs.length) {
            int sum = chosen.stream().mapToInt(Integer::intValue).sum();
            if (result.get() > sum)
                result.set(sum);
        } else {
            for (int i = 0; i < costs[row].length; i++) {
                if (i == column) continue;
                int temp = costs[row][i];
                chosen.add(temp);
                helper(costs, chosen, row + 1, i, result);
                chosen.remove(chosen.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        System.out.println("Expected: 10, Actual: " + minCost(input));
        System.out.println("Number of calls made: " + calls);
        int[][] input2 = {{1, 2, 3},
                {4, 2, 5},
                {4, 2, 5},
                {4, 2, 5},
                {4, 2, 19}};
        System.out.println("Expected: 7, Actual: " + minCost(input2));
        System.out.println("Number of calls made: " + calls);
    }
}
