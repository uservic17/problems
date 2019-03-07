package problems.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
  public static int[][] getResultingMatrix(int[][] array) {
    int[][] result = new int[array.length][array[0].length];

    return getResultingMatrix(array, result);
  }

  private static int[][] getResultingMatrix(int[][] array, int[][] result) {
    //Mark the resulting matrix's first and last , row and column to 1's
//    prepopulate

    //Create adjacency matrix for each node containing the eligible neighbors

    //Now for every node from row 1 to array.length - 1 and column 1 to array[0].length - 1
    //do a depth first search and see if any neighbor is connected to pacific, set this node to pacific as well..
    //or  in other words, set this node in the result to 1

    //do the same again for atlantic ocean and set the node in the result to result + 1;



    return result;
  }
}

//This solution runs fine
class Solution22 {
  public int m;
  public int n;
  public List<int[]> pacificAtlantic(int[][] matrix) {
    List<int[]> res = new ArrayList<>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
      return res;
    }
    m = matrix.length;
    n = matrix[0].length;
    boolean[][] pacific = new boolean[m][n];
    boolean[][] atlantic = new boolean[m][n];
    for (int i = 0; i < m; i++){
      helper(matrix, pacific, Integer.MIN_VALUE, i, 0);
      helper(matrix, atlantic, Integer.MIN_VALUE, i, n - 1);
    }
    for (int i = 0; i < n; i++){
      helper(matrix, pacific, Integer.MIN_VALUE, 0, i);
      helper(matrix, atlantic, Integer.MIN_VALUE, m - 1, i);
    }
    for (int i = 0; i < m; i++){
      for (int j = 0; j < n; j++){
        if (pacific[i][j] && atlantic[i][j]){
          res.add(new int[]{i,j});
        }
      }
    }
    return res;
  }

  private void helper(int[][] matrix, boolean[][] visited, int pre, int i, int j){
    if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || matrix[i][j] < pre){
      return;
    }
    visited[i][j] = true;
    helper(matrix, visited, matrix[i][j], i - 1, j);
    helper(matrix, visited, matrix[i][j], i, j - 1);
    helper(matrix, visited, matrix[i][j], i + 1, j);
    helper(matrix, visited, matrix[i][j], i, j + 1);
  }
}

