package problems.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class FruitBasketTest {

  @Test
  public void totalFruit() {
    assertEquals(0, FruitBasket.totalFruit(new int[]{}));
  }
  @Test
  public void totalFruit1() {
    assertEquals(1, FruitBasket.totalFruit(new int[]{0}));
  }
  @Test
  public void totalFruit2() {
    assertEquals(2, FruitBasket.totalFruit(new int[]{1,1}));
  }
 @Test
  public void totalFruit21() {
    assertEquals(2, FruitBasket.totalFruit(new int[]{1,2}));
  }
  @Test
  public void totalFruit3() {
    assertEquals(3, FruitBasket.totalFruit(new int[]{1,2,1}));
  }
  @Test
  public void totalFruit4() {
    assertEquals(3, FruitBasket.totalFruit(new int[]{1,2,1,3}));
  }

  @Test
  public void totalFruit5() {
    assertEquals(3, FruitBasket.totalFruit(new int[]{1,2,1,3,1,2,1}));
  }
  @Test
  public void totalFruit6() {
    assertEquals(5, FruitBasket.totalFruit(new int[]{1,2,1,3,3,3,1,2}));
  }
  @Test
  public void totalFruit7() {
    assertEquals(6, FruitBasket.totalFruit(new int[]{1,2,1,3,3,3,3,1,2,1,1}));
  }
  @Test
  public void totalFruit8() {
    assertEquals(6, FruitBasket.totalFruit(new int[]{1,1,12,12,1,12}));
  }
  @Test
  public void totalFruit9() {
    assertEquals(4, FruitBasket.totalFruit(new int[]{1,2,3,2,2}));
  }
  @Test
  public void totalFruit10() {
    assertEquals(5, FruitBasket.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
  }
}