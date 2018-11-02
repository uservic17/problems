package dataStructures.stack.setOfStacks;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SetOfStacks {

    private int[][] matrix;
    private int top;
    private int stackNumber;
    private int numberOfStacks;
    private int stackSize;


    SetOfStacks(int numberOfStacks, int stackSize) {
      matrix = new int[numberOfStacks][stackSize];
      stackNumber = 0;
      top = -1;
      this.numberOfStacks = numberOfStacks;
      this.stackSize = stackSize;
    }

    void push(int value) {
      checkCapacity();
      top++;
      matrix[stackNumber][top] = value;
    }

    int pop() {
      validateNotEmpty();
      return matrix[stackNumber][top--];
    }

    private void validateNotEmpty() {
      if (top < 0) {
        if (stackNumber == 0) {
          throw new IllegalStateException("MyStack: No elements in stack");
        } else {
          stackNumber--;
          top = stackSize-1;
        }
      }
    }

    public int peek() {
      validateNotEmpty();
      return matrix[stackNumber][top];
    }


    private void checkCapacity() {
      if (top >= matrix[stackNumber].length - 1) {
        if (stackNumber < numberOfStacks - 1) {
          stackNumber++;
          top = -1;
        } else {
          throw new IllegalStateException("Stack is full. All mini stack are full");
        }
      }
    }


    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("Stack with " + (stackNumber*stackSize + top + 1) + " elements: ");
      sb.append(Arrays.stream(matrix).flatMap(s -> Arrays.stream(s).mapToObj(String::valueOf)).limit(stackNumber*stackSize + top + 1).collect(Collectors.joining("->")));
      sb.append("(top)");
      return sb.toString();
  }
}
