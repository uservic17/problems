package problems.hackerRank.strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ZeroMatrixTest {

  @Test
  public void makeZeroMatrix() {
    int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    assertArrayEquals(array, ZeroMatrix.makeZeroMatrix(array));
  }

  @Test
  public void makeZeroMatrix2() {
    int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 0, 9}};
    int[][] result = {{1, 0, 3}, {4, 0, 6}, {0, 0, 0}};

    assertArrayEquals(result, ZeroMatrix.makeZeroMatrix(array));
  }

  @Test
  public void makeZeroMatrix3() {
    int[][] array = {{1, 2, 3}, {0, 5, 6}, {7, 0, 9}};
    int[][] result = {{0, 0, 3}, {0, 0, 0}, {0, 0, 0}};

    assertArrayEquals(result, ZeroMatrix.makeZeroMatrix(array));
  }

  @Test
  public void makeZeroMatrix4() {
    int[][] array = {{1, 2, 3}, {0, 5, 6}, {7, 0, 9}, {10, 11, 12}};
    int[][] result = {{0, 0, 3}, {0, 0, 0}, {0, 0, 0}, {0, 0, 12}};

    assertArrayEquals(result, ZeroMatrix.makeZeroMatrix(array));
  }

  @Test
  public void makeZeroMatrix5() {
    int[][] array = {{1, 2, 3, 4}, {5, 0, 5, 6}, {10, 11, 0, 12}};
    int[][] result = {{1, 0, 0, 4}, {0, 0, 0, 0}, {0, 0, 0, 0}};

    assertArrayEquals(result, ZeroMatrix.makeZeroMatrix(array));
  }

  @Test
  public void makeZeroMatrix6() {
    int[][] array = {{0, 2, 3, 4}, {5, 0, 5, 6}, {10, 11, 0, 12}};
    int[][] result = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};

    assertArrayEquals(result, ZeroMatrix.makeZeroMatrix(array));
  }

  //to test original array is not changed...todo
  @Test
  public void makeZeroMatrix6Clone() {
    int[][] array = {{1, 2, 3, 4}, {5, 0, 5, 6}, {10, 11, 0, 12}};
    int[][] result = {{1, 0, 0, 4}, {0, 0, 0, 0}, {0, 0, 0, 0}};

    assertEquals(5, array[1][1]);
  }
}