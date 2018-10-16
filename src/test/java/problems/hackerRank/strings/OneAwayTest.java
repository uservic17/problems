package problems.hackerRank.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class OneAwayTest {

  @Test
  public void isOneDifferenceAwayNullBoth() {
    assertFalse((OneAway.isOneDifferenceAway(null, null)));
  }
  @Test
  public void isOneDifferenceAwayNull1() {
    assertFalse((OneAway.isOneDifferenceAway(null, "hi")));
  }
  @Test
  public void isOneDifferenceAwayNull2() {
    assertFalse((OneAway.isOneDifferenceAway("hello", null)));
  }
  @Test
  public void isOneDifferenceAwayReplace() {
    assertTrue((OneAway.isOneDifferenceAway("pate", "mate")));
  }

  @Test
  public void isOneDifferenceAwayReplace1() {
    assertTrue((OneAway.isOneDifferenceAway("a", "")));
  }

  @Test
  public void isOneDifferenceAwayReplace2() {
    assertTrue((OneAway.isOneDifferenceAway("matt", "batt")));
  }

  @Test
  public void isOneDifferenceAwayReplaceFalse1() {
    assertFalse((OneAway.isOneDifferenceAway("taft", "ttfa")));
  }

  @Test
  public void isOneDifferenceAwayReplaceFalse2() {
    assertFalse((OneAway.isOneDifferenceAway("", "ab")));
  }

  @Test
  public void isOneDifferenceAwayInsert() {
    assertTrue((OneAway.isOneDifferenceAway("aple", "apple")));
  }

  @Test
  public void isOneDifferenceAwayInsert2() {
    assertTrue((OneAway.isOneDifferenceAway("bully", "bull")));
  }

  @Test
  public void isOneDifferenceAwayInsertFalse1() {
    assertFalse((OneAway.isOneDifferenceAway("bully", "bullion")));
  }

  @Test
  public void isOneDifferenceAwayInsertTrue1() {
    assertTrue((OneAway.isOneDifferenceAway("billion", "bullion")));
  }
}