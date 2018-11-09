package dataStructures.stacksNQueues;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyStackTest {

  @Test
  public void pop() {
  }

  @Test
  public void peek() {
  }

  @Test
  public void pushAndPopAndToString() {
    MyStack stack = new MyStack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    assertEquals(1, stack.min());
    assertEquals("Stack with 3 elements: 1->2->3(top)", stack.toString());
    assertEquals(3, stack.pop());
    assertEquals(2, stack.pop());
    assertEquals(1, stack.min());
    assertEquals(1, stack.pop());
  }

  @Test
  public void min() {
    MyStack stack = new MyStack();
    stack.push(5);
    stack.push(2);
    stack.push(3);
    assertEquals(2, stack.min());
    stack.pop();
    assertEquals(2, stack.min());
    stack.pop();
    assertEquals(5, stack.min());



  }

  @Test
  public void min2() {
    MyStack stack = new MyStack();
    stack.push(5);
    stack.push(4);
    stack.push(3);
    stack.push(2);
    stack.push(1);
    assertEquals(1, stack.min());
    stack.pop();
    assertEquals(2, stack.min());
    stack.pop();
    assertEquals(3, stack.min());
    stack.pop();
    assertEquals(4, stack.min());
    stack.pop();
    assertEquals(5, stack.min());
  }

  @Test
  public void min3() {
    MyStack stack = new MyStack();
    stack.push(5);
    stack.push(4);
    stack.push(3);
    stack.push(2);
    stack.push(1);
    stack.push(4);
    stack.push(5);
    stack.push(6);
    stack.push(0);
    stack.push(-1);
    System.out.println(stack);
    assertEquals(-1, stack.min());
    stack.pop();
    assertEquals(0, stack.min());
    stack.pop();
    assertEquals(1, stack.min());
    stack.pop();
    assertEquals(1, stack.min());
    stack.pop();
    assertEquals(1, stack.min());
  }

  @Test
  public void min4() {
    MyStack stack = new MyStack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(1);
    assertEquals(1, stack.min());
    stack.pop();
    assertEquals(1, stack.min());
    stack.pop();
    assertEquals(1, stack.min());
    stack.pop();
    assertEquals(1, stack.min());
    stack.pop();
    assertEquals(1, stack.min());
  }
}