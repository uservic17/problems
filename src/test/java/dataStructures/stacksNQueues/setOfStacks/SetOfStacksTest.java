package dataStructures.stacksNQueues.setOfStacks;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetOfStacksTest {

  @Test
  public void push() {
    SetOfStacks set = new SetOfStacks(2,3);
    set.push(1);
    set.push(2);
    set.push(3);
    set.push(4);
    set.push(5);
    set.push(6);
    assertEquals(6, set.pop());
    assertEquals(5, set.peek());
    set.pop();
    set.pop();
    assertEquals(3, set.peek());
    assertEquals("Stack with 3 elements: 1->2->3(top)", set.toString());
  }

  @Test
  public void push2() {
    SetOfStacks set = new SetOfStacks(2,1);
    set.push(1);
    set.push(2);
    assertEquals("Stack with 2 elements: 1->2(top)", set.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void push3() {
    SetOfStacks set = new SetOfStacks(2,1);
    set.push(1);
    set.push(2);
    set.push(3);
  }
}