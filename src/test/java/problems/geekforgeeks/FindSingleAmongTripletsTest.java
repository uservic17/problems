package problems.geekforgeeks;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindSingleAmongTripletsTest {

  @Test
  public void findSingle() {
    assertEquals(2, FindSingleAmongTriplets.findSingle(new int[] { 2, 3,3,3}));
  }

  @Test
  public void findSingle11() {
    assertEquals(1, FindSingleAmongTriplets.findSingle(new int[] { 1, 3,3,3}));
  }
  @Test
  public void findSingle2() {
    assertEquals(1, FindSingleAmongTriplets.findSingle(new int[] { 1,2,2,2, 3,3,3}));
  }

  @Test
  public void findSingle3() {
    assertEquals(3, FindSingleAmongTriplets.findSingle(new int[] { 3,2,2,2, 3,3,3}));
  }

  @Test
  public void findSingle4() {
    assertEquals(4, FindSingleAmongTriplets.findSingle(new int[] { 3,2,2,2, 3,3,3, 3,3,4}));
  }
}