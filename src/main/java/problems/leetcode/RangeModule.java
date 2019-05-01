package problems.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class RangeModule {

    private TreeMap<Integer, Integer> map;

    public RangeModule() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        if (right >= left) return;
        //new floorEntry is the smallest.. on the left of all
        Map.Entry<Integer, Integer> firstEntry = map.firstEntry();
        if (left < firstEntry.getKey()) {
            if (right < firstEntry.getValue()) {
                map.put(left, right);
                return;
            } else {
                if (right <= firstEntry.getValue()) {
                    changekey(left, firstEntry);
                    return;
                } else {
                    changeValue(right, firstEntry);
                    return;
                }
            }
        }

        Map.Entry<Integer, Integer> lastEntry = map.lastEntry();
        if (left > lastEntry.getKey()) {
            if (left > lastEntry.getValue()) {
                map.put(left, right);
                return;
            } else {
                changeValue(right, lastEntry);
                return;
            }
        }



        Map.Entry<Integer, Integer> floorEntry = map.floorEntry(left);
        //if left is smaller than the smallest key
        if (floorEntry == null) {
            Map.Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(left);
            if (ceilingEntry == null ) {
                map.put(left, right);
                return;
            } else {
                if (ceilingEntry.getKey() > right) {
                    map.put(left, right);
                } else {
//                    if (right <=)

                }
            }

        } else {
            if (floorEntry.getValue() < left) {
//                map.put(left)
            }
        }
//        map.put(left, right);

    }

    private void changeValue(int right, Map.Entry<Integer, Integer> entry) {
        int key = entry.getKey();
        map.remove(key);
        map.put(key, right);
    }

    private void changekey(int left, Map.Entry<Integer, Integer> entry) {
        int value = entry.getValue();
        map.remove(entry.getKey());
        map.put(left, value);

    }

    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> entry = map.floorEntry(left);
        if (entry == null) return false;

        int key = entry.getKey();
        int value = entry.getValue();
        return left >= key && left < right && right <= value;
    }

    public void removeRange(int left, int right) {
    }

    public static void main(String[] args) {
        RangeModule obj = new RangeModule();
        obj.addRange(10, 20);
        boolean param_2 = obj.queryRange(12, 14);
        System.out.println(param_2);
        System.out.println("Expected false. Actual: " + obj.queryRange(18, 21));
        System.out.println("Expected false. Actual: " + obj.queryRange(20, 21));
        System.out.println("Expected false. Actual: " + obj.queryRange(20, 20));
        System.out.println("Expected false. Actual: " + obj.queryRange(8,9));
        System.out.println("Expected false. Actual: " + obj.queryRange(8,12));
        obj.addRange(21,22);
        System.out.println(obj.map);
//        obj.removeRange(left, right);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */