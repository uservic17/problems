package sorting;

import java.util.Arrays;

public class MergeSortArrayP2 {
    private static int[] mergeSort(int[] array) {
        if (array == null || array.length == 0) return array;
         helper(array, 0, array.length-1);
         return array;
    }

    private static void helper(int[] array, int left, int right) {
        if (left >= right) return ;
        int mid = left + (right - left) /2;
        helper(array, left, mid);   //todo.make sure you pass mid and mid+1 in the next line. or stackoverflow
        helper(array, mid+1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        if (left >= right) return;
        for (int i = left, j = mid; i <= mid && j <= right;  ) {
            if (array[i] > array[mid]) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j++;
            } else {
                i++;
            }
        }


    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(mergeSort(new int[]{11, 12, 1, 8, 88, 9, 7, 9, 6, 3, 4, 5})));
//        System.out.println(Arrays.toString(mergeSort(new int[]{1, 2, 3, 4, 5, 6})));
//        System.out.println(Arrays.toString(mergeSort(new int[]{6, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6})));
//        System.out.println(Arrays.toString(mergeSort(new int[]{})));
//        System.out.println(Arrays.toString(mergeSort(new int[]{1})));
        System.out.println(Arrays.toString(mergeSort(new int[]{1, 2, 1})));
    }

}
