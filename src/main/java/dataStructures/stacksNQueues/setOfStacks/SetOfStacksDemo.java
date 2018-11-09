package dataStructures.stacksNQueues.setOfStacks;

public class SetOfStacksDemo {
  public static void main(String[] args) {
    SetOfStacks set = new SetOfStacks(2,1);
    set.push(1);
    set.push(2);
    set.push(3);
    set.push(4);
    set.push(5);
    set.push(6);
    set.pop();
    System.out.println(set);
  }
}
