package dataStructures.minHeap;

public class MinHeap {
  private int[] heap;
  private int maxSize;
  private int size;


  public MinHeap(int[] array) {
    maxSize = array.length + 10;
    size = array.length;
    this.heap = new int[maxSize];
//    heap = array; //don't do this. any changes to array will be visible in heap. it is a reference
//    heap = array.clone(); //don't do this.. do System.arraycopy()
    System.arraycopy(array, 0, heap, 0, array.length);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < this.size - 1; i++) {
      sb.append(heap[i]).append(", ");
    }
    sb.append(heap[size-1]);
    return "MinHeap{" +
            "heap=" + sb.toString() +
            '}';
  }

  public MinHeap() {
    maxSize = 10;
    size = 0;
    heap = new int[maxSize];
  }

  public int getRootElement() {
    if (size > 0) return heap[0];
    return Integer.MIN_VALUE;
  }
  public void insert(int element) {
    //insert in the end
    //heapify up
    checkSize();
    heap[size] = element;
    size++;
    heapifyUp(size-1);


  }

  private void heapifyUp(int index) {
    if (size == 1 || index == 0) return; //i.e. no parent. and cannot heapifyup
    int parentIndex = getParentIndex(index);
    if (heap[parentIndex] > heap[index]) {
      swap(getParentIndex(index), index);
      heapifyUp(parentIndex);
    }
  }

  private int getParentIndex(int index) {
    return (index - 1) / 2;
  }

  private void checkSize() {
    if (size == maxSize) {
      increaseSize();
    }
  }


  public int extractRoot() {
    return remove(0);
  }

  private int remove(int index) {
    //store the element's value in temp variable to return later
    //swap the value of last node and this node.
    //dont store the toberemoved value at the last node
    //now heapifyDown
    int returnValue = heap[index];
    heap[index] = heap[size-1];
    size--;
    heapifyDown(index);
    return returnValue;
  }

  private void heapifyDown(int index) {


    int indexOfSmallerChild = getSmallerChildIndex(index);
    if (indexOfSmallerChild != -1 && heap[indexOfSmallerChild] < heap[index]) {
      swap(index, indexOfSmallerChild);
      heapifyDown(indexOfSmallerChild);
    }

  }

  private int getSmallerChildIndex(int index) {
    int leftChildIndex = getLeftChildIndex(index);
    int rightChildIndex = getRightChildIndex(index);
    int indexToSwapWith;
    if (leftChildIndex != -1 && rightChildIndex != -1) {
      indexToSwapWith = heap[leftChildIndex] <= heap[rightChildIndex] ? leftChildIndex : rightChildIndex;
    } else if (leftChildIndex == -1  && rightChildIndex != -1) {
      indexToSwapWith = rightChildIndex;
    } else if (rightChildIndex == -1 && leftChildIndex != -1){
      indexToSwapWith = leftChildIndex;
    } else {
      indexToSwapWith = -1;
    }
    return indexToSwapWith;
  }

  private int getRightChildIndex(int index) {
    return 2 * index + 2 <= size ? 2 * index + 1 : -1;
  }

  private int getLeftChildIndex(int index) {
    return 2 * index + 1 <= size ? 2 * index + 1 : -1;
  }

  private void swap(int index1, int index2) {
    int temp = heap[index1];
    heap[index1] = heap[index2];
    heap[index2] = temp;
  }

  private void increaseSize() {
    maxSize = maxSize + 10;
    int[] newArray = new int[maxSize];
    System.arraycopy(heap, 0, newArray, 0, heap.length);
    heap = newArray;
  }

  public int getParent(int index) {

    int position = (index - 1) / 2;
    if (position < 0) return Integer.MIN_VALUE;
    return heap[position];
  }

  public int getFirstChild(int index) {
    int positionOfChild = 2 * index + 1;
    if (positionOfChild > heap.length) return Integer.MAX_VALUE;
    return heap[positionOfChild];
  }

  public int getSecondChild(int index) {
    int positionOfChild = 2 * index + 2;
    if (positionOfChild > heap.length) return Integer.MAX_VALUE;
    return heap[positionOfChild];
  }
}
