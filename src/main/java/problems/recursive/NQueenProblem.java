package problems.recursive;

public class NQueenProblem {
  public static void main(String[] args) {
    try {
      nQueen(5);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
  private static void nQueen(int n) throws InterruptedException {

    //Populate the grid
    char[][] grid = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j< n; j++) {
        grid[i][j] = '_';
      }
    }

    //call the N queen solution
    nQueen(grid, 0);
  }

  static private void nQueen(char[][] grid, int column) throws InterruptedException {
    if (column > grid[0].length - 1) {

      System.out.println("Solution");
      printMyGrid(grid);
    } else {
      for (int i = 0; i < grid.length; i++) {

//        printMyGrid(grid);
//        Thread.sleep(200);
          grid[i][column] = 'Q';
          if (isSafe(grid, i, column)) {
            nQueen(grid, column + 1);
          }
          grid[i][column] = '_';
      }
    }


  }

  private static void printMyGrid(char[][] grid) {
    System.out.println("-----------------");
    for (int i = 0; i< grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.println("");
    }
  }

  static private boolean isSafe(char[][] grid, int row, int column) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < column; j++) {
        if (grid[i][j] == 'Q') {
          if (i == row) return false; //same row
          else {
            //diagonal
            int rowDiff = Math.abs(row - i);
            int colDiff = column -j;
            if(rowDiff == colDiff) return false;
          }
        }

      }
    }
    return true;
  }

}

/*
_ _ _ _
Q _ _ _
_ _ _ _
_ Q _ _
 */