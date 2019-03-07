package problems.leetcode;


import java.util.*;

/**
 * Definition for an interval.
 * struct Interval {
 * int start;
 * int end;
 * Interval() : start(0), end(0) {}
 * Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Interval {
  public int start;
  int end;
}

public class MeetingRooms2 {

}

//Using Min Heap
class Solution {
  public int minMeetingRooms(Interval[] intervals) {
    if (intervals.length == 0) return 0;

    Arrays.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return Integer.compare(o1.start, o2.start);
      }
    });
    PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length, (o1, o2) -> o1 - o2);
    allocator.add(intervals[0].end);
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i].start >= allocator.peek()) {
        allocator.poll();
      }
      allocator.add(intervals[i].end);
    }
    return allocator.size();
  }
}

//Using 2 separate Arrays
class Solution2 {
  public int minMeetingRooms(Interval[] intervals) {
    if (intervals.length == 0) return 0;

    int[] startArray = new int[intervals.length];
    int[] endArray = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      startArray[i] = intervals[i].start;
    }
    for (int i = 0; i < intervals.length; i++) {
      endArray[i] = intervals[i].end;
    }
    Arrays.sort(startArray);
    Arrays.sort(endArray);
    int result = 0;

    for (int startPointer = 0, endPointer = 0; startPointer < intervals.length; startPointer++) {
      if (startArray[startPointer] >= endArray[endPointer]) {
        result--;
        startPointer++;
      } else {
        result ++;
        startPointer++;
        endPointer++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
//    System.out.println(1 << 3);
    int num = 2;
    System.out.println(num & (1 << 1));
  }
}