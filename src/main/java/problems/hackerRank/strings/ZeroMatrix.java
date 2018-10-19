package problems.hackerRank.strings;

/**
 * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 * Time complexity even in the best case scneario is O(mn) where m is number of rows and n is that of columns
 * Space complexity in simple solution is O(mn)
 * so use different arrays or lists to store zeroes for rows and columns
 * but the third and the best solution is to store that data in first row and first column
 *
 * Space O(1)
 * Time O(mn)
 */
public class ZeroMatrix {
  static int[][] makeZeroMatrix(int[][] array) {
    //todo clone the array rather than using the original one.. but in interview doing in-place is fine.
//    int[][] array = input.clone();
    //for real code, better to use the clone
    boolean rowHasZero = false;
    boolean columnHasZero = false;

    //find if there is any zero in the row
    rowHasZero = getRowHasZero(array);

    //find if there is any zero in the column
    columnHasZero = getColumnHasZero(array);

    setZeroRowsInFirstRowAndFirstColumn(array);

    //set all the columns zero according to the first row
    for (int i = 1; i < array[0].length; i++) {
      if (array[0][i] == 0) {
        nullifyTheColumn(array, i);
      }
    }

    //set all the rows zero according to the first column
    for (int i = 1; i < array.length; i++) {
      if (array[i][0] == 0) {
        nullifyTheRow(array, i);
      }
    }

    if (columnHasZero) {
      nullifyTheColumn(array, 0);
    }
    if (rowHasZero) {
      nullifyTheRow(array, 0);
    }
    return array;
  }

  private static boolean getRowHasZero(int[][] array) {
    for (int i = 0; i < array[0].length; i++) {
      if (array[0][i] == 0) {
        return true;
      }
    }
    return false;
  }

  private static boolean getColumnHasZero(int[][] array) {
    for (int i = 0; i < array.length; i++) {
      if (array[i][0] == 0) {
        return true;
      }
    }
    return false;
  }
  private static void nullifyTheColumn(int[][] array, int column) {
    for (int i = 0; i < array.length; i++) {
      array[i][column] = 0;
    }
  }

  private static void nullifyTheRow(int[][] array, int row) {
    for (int i = 0; i < array[row].length; i++) {
      array[row][i] = 0;
    }
  }

  private static void setZeroRowsInFirstRowAndFirstColumn(int[][] array) {
    for (int i = 1; i < array.length; i++) {
      for (int j = 1; j < array[i].length; j++) {
        if (array[i][j] == 0) {
          array[0][j] = 0;
          array[i][0] = 0;
        }
      }
    }
  }


}
