package problems.hackerRank.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromePermutationTest {

  @Test
  public void isPalidromPerm() {
    assertTrue(PalindromePermutation.isPalidromPerm("lala"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void isPalidromPermNull() {
    assertTrue(PalindromePermutation.isPalidromPerm(null));
  }

  @Test
  public void isPalidromPermEmpty() {
    assertTrue(PalindromePermutation.isPalidromPerm(""));
  }

  @Test
  public void isPalidromPerm2() {
    assertTrue(PalindromePermutation.isPalidromPerm("hi hi"));
  }

  @Test
  public void isPalidromPerm21() {
    assertTrue(PalindromePermutation.isPalidromPerm("hihi"));
  }

  @Test
  public void isPalidromPerm3() {
    assertTrue(PalindromePermutation.isPalidromPerm("tact coa"));
  }

  @Test
  public void isPalidromPerm4() {
    assertTrue(PalindromePermutation.isPalidromPerm("tacT cOA"));
  }

  @Test
  public void isPalidromPerm5() {
    assertTrue(PalindromePermutation.isPalidromPerm("ta cT cOA"));
  }

  @Test
  public void isPalidromPerm6() {
    assertTrue(PalindromePermutation.isPalidromPerm("tactcoa"));
  }

  @Test
  public void isPalidromPerm7() {
    assertTrue(PalindromePermutation.isPalidromPerm("zzzzyyyyx"));
  }

  @Test
  public void isPalidromPermLengthOne() {
    assertTrue(PalindromePermutation.isPalidromPerm("Z"));
  }

  @Test
  public void isPalidromPermJustSpaces() {
    assertTrue(PalindromePermutation.isPalidromPerm("      "));
  }
  @Test
  public void isPalidromPermNot1() {
    assertFalse(PalindromePermutation.isPalidromPerm("blah"));
  }

  @Test
  public void isPalidromPermInvalidChars() {
    assertFalse(PalindromePermutation.isPalidromPerm("% %"));
  }
}