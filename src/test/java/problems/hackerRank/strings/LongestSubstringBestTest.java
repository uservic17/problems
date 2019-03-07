package problems.hackerRank.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringBestTest {


  @Test
  public void lengthOfLongestSubstringMine2() {
    assertEquals(0, LongestSubstringBest.getLongestSubstring(""));
  }
  @Test
  public void lengthOfLongestSubstringMine3() {
    assertEquals(1, LongestSubstringBest.getLongestSubstring("a"));
  }
  @Test
  public void lengthOfLongestSubstringMine4() {
    assertEquals(2, LongestSubstringBest.getLongestSubstring("ab"));
  }
  @Test
  public void lengthOfLongestSubstringMine5() {
    assertEquals(5, LongestSubstringBest.getLongestSubstring("tmmzuxt"));
  }
  @Test
  public void lengthOfLongestSubstringMine6() {
    assertEquals(3, LongestSubstringBest.getLongestSubstring("pwwkew"));
  }
}