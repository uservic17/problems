package dataStructures.stack;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MyStack {
  private int[] array;
  private int[] minList;
  private int top;
  private int minTop;


  MyStack() {
    array = new int[8];
    minList = new int[8];
    top = -1;
    minTop = -1;
  }

  int pop() {
    validateNotEmpty();
    int result = array[top--];
    if (result == peekMinArray()) {
      minTop--;
    }
    return result;
  }

  private void validateNotEmpty() {
    if (top < 0) {
      throw new IllegalStateException("MyStack: No elements in stack");
    }
  }

  private void validateMinArrayNotEmpty() {
    if (minTop < 0) {
      throw new IllegalStateException("MinStack: No elements in stack");
    }
  }

  public int peek() {
    validateNotEmpty();
    return array[top];
  }

  private int peekMinArray() {
    validateMinArrayNotEmpty();
    return minList[minTop];
  }

  void push(int value) {
    checkCapacity();
    top++;
    array[top] = value;
    if ( minTop < 0 || value <= peekMinArray()) {
      minList[++minTop] = value;
    }
  }

  private void checkCapacity() {
    if (top >= array.length -1) {
      int[] newArray = new int[array.length << 1];
      System.arraycopy(array, 0, newArray, 0, array.length);
      array = newArray;
    }
  }

  public int min() {
    return peekMinArray();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Stack with " + (top + 1) + " elements: ");
    sb.append(Arrays.stream(array).limit(top + 1).mapToObj(String::valueOf).collect(Collectors.joining("->")));
//    for (int i = top; i >= 0; i--) {
//      sb.append(array[i]).append(", ");
//    }
    sb.append("(top)");
    return sb.toString();
  }
}
