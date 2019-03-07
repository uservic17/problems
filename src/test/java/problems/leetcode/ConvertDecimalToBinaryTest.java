package problems.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertDecimalToBinaryTest {

  @Test
  public void decimalToBinary() {
    assertEquals("101", ConvertDecimalToBinary.decimalToBinary(5));
  }

  @Test
  public void decimalToBinaryMinus16() {
    assertEquals("-10000", ConvertDecimalToBinary.decimalToBinary(-16));
  }

  @Test
  public void decimalToBinary1() {
    assertEquals("1", ConvertDecimalToBinary.decimalToBinary(1));
  }

  @Test
  public void decimalToBinary3() {
    assertEquals("11", ConvertDecimalToBinary.decimalToBinary(3));
  }

  @Test
  public void decimalToBinary15() {
    assertEquals("1111", ConvertDecimalToBinary.decimalToBinary(15));
  }

  @Test
  public void decimalToBinaryZero() {
    assertEquals("0", ConvertDecimalToBinary.decimalToBinary(0));
  }

  @Test
  public void decimalToBinaryMinus5() {
    assertEquals("-101", ConvertDecimalToBinary.decimalToBinary(-5));
  }

  @Test
  public void decimalToBinary7() {
    assertEquals("111", ConvertDecimalToBinary.decimalToBinary(7));
  }


}