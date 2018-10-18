package dataStructures.minHeap;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinHeapTest {

  @Test
  public void getRootElement() {
    int[] array = new int[] {0,1,2,3,4};
    MinHeap minHeap = new MinHeap(array);
    assertEquals("MinHeap{heap=0, 1, 2, 3, 4}", minHeap.toString());
    assertEquals(0, minHeap.getRootElement());
    assertEquals(0, minHeap.extractRoot());
    assertEquals("MinHeap{heap=1, 3, 2, 4}", minHeap.toString());
    minHeap.insert(0);
    assertEquals("MinHeap{heap=0, 1, 2, 4, 3}", minHeap.toString());
  }
}