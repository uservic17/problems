package dataStructures.stack;

public class MyStackDemo {
  public static void main(String[] args) {
    MyStack stack = new MyStack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    System.out.println(stack);
    stack.pop();
    System.out.println(stack);
  }
}
