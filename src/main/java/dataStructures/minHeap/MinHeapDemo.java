package dataStructures.minHeap;

public class MinHeapDemo {
  public static void main(String[] args) {
    int[] array = new int[] {0,1,2,3,4};
    MinHeap minHeap = new MinHeap(array);
    System.out.println(minHeap);
    System.out.println("Root value: " + minHeap.getRootElement());
    System.out.println("Remove root" + minHeap.extractRoot());
    System.out.println(minHeap);
    System.out.println("Insert 0");
    minHeap.insert(0);
    System.out.println(minHeap);

  }
}
