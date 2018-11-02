package dataStructures.stack.sortStack;

import java.util.Stack;

public class SortedStack {
  private Stack<Integer> stack;
  private Stack<Integer> tempStack;

  SortedStack() {
    stack = new Stack<>();
    tempStack = new Stack<>();
  }

  void push(int element) {
    if (stack.isEmpty()) {
      stack.push(element);
    } else if (element <= stack.peek()) {
      stack.push(element);
    } else {
      popMinAndThenPush(element);
    }
  }

  private void popMinAndThenPush(int element) {
    while (!stack.isEmpty() && stack.peek() < element) {
      tempStack.push(stack.pop());
    }
    stack.push(element);
    while(!tempStack.isEmpty()) {
      stack.push(tempStack.pop());
    }
  }

  int peek() {
    return stack.peek();
  }

  int pop() {
    return stack.pop();
  }

  @Override
  public String toString() {
    return stack.toString();
  }
}
