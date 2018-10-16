package problems.hackerRank.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringDuplicateCharsTest {

  @Test
  public void anyDuplicateChars() {
    assertTrue(StringDuplicateChars.anyDuplicateChars("hello"));
  }

  @Test
  public void anyDuplicateChars2() {
    assertFalse(StringDuplicateChars.anyDuplicateChars(""));
  }

  @Test
  public void anyDuplicateChars3() {
    assertFalse(StringDuplicateChars.anyDuplicateChars("abc"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void anyDuplicateChars4() {
    assertTrue(StringDuplicateChars.anyDuplicateChars("##$#$"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void anyDuplicateChars5() {
    assertFalse(StringDuplicateChars.anyDuplicateChars("123"));
  }
}