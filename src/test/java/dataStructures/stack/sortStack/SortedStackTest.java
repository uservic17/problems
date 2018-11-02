package dataStructures.stack.sortStack;


import org.junit.Test;

import static org.junit.Assert.*;

public class SortedStackTest {

  @org.junit.Test
  public void push() {
    SortedStack stack = new SortedStack();
    stack.push(3);
    stack.push(1);
    stack.push(2);
    assertEquals("[3, 2, 1]", stack.toString());
  }

  @org.junit.Test
  public void push2() {
    SortedStack stack = new SortedStack();
    stack.push(3);
    stack.push(1);
    stack.push(2);
    stack.push(1);
    assertEquals("[3, 2, 1, 1]", stack.toString());
    stack.pop();
    stack.push(5);
    assertEquals("[5, 3, 2, 1]", stack.toString());
    stack.push(-1);
    assertEquals("[5, 3, 2, 1, -1]", stack.toString());
  }
}