package problems.mit;

public class PeakFinder {
    //todo lets see if the elemnet is greater than both neighbors
    static int findPeak(int[] array) {
        int start = 0;
        int end = array.length - 1;
        return foo(array, start, end);
    }

    static private int foo(int[] array, int start, int end) {
        if (start > end ) return Integer.MIN_VALUE;
        int mid = start + (end - start) / 2;
        int left = mid - 1;
        int right = mid + 1;

        if (mid == left) {
            if (array[mid] > array[right])            return array[mid];
            return Integer.MIN_VALUE;
        }
        if (mid == right ) {
            if (array[mid] > array[left])        return array[mid];
            return Integer.MIN_VALUE;
        }
        if (array[mid] > array[left] && array[mid] > array[right] ) {
            return array[mid];
        } else if (array[mid] < array[right]) {
            return foo(array, right, end);
        } else if (array[mid] < array[left]) {
            foo(array, start, left);
        } else {
            return Math.max(foo(array, right, end), foo(array, start, left));
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
       int[] array = new int[] {2,1,1,1,1,1,1};
        System.out.println(findPeak(array));
    }
}
