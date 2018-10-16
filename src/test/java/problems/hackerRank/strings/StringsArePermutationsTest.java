package problems.hackerRank.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringsArePermutationsTest {

  @Test
  public void arePerutations() {
    assertTrue(StringsArePermutations.arePerutationsWrongOne("ola", "lao"));
  }

  @Test
  public void arePerutations2() {
    assertTrue(StringsArePermutations.arePerutationsWrongOne("hello", "llohe"));
  }

  @Test
  public void arePerutations3() {
    assertTrue(StringsArePermutations.arePerutationsWrongOne("", ""));
  }

  @Test
  public void arePerutations4() {
    assertFalse(StringsArePermutations.arePerutationsWrongOne("hello", "hi"));
  }

  @Test
  public void arePerutations41() {
    assertFalse(StringsArePermutations.arePerutationsWrongOne("aabcd", "bcddd"));
  }

  @Test
  public void arePerutations5() {
    assertFalse(StringsArePermutations.arePerutationsWrongOne("hello", null));
  }

  @Test (expected = IllegalArgumentException.class)
  public void arePerutationsException() {
    assertFalse(StringsArePermutations.arePerutationsWrongOne("hello", "hllo#"));
  }
}