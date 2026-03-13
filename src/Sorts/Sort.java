package Sorts;

import Heap.*;

public class Sort {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int hold = arr[i];

            while (j != -1 && hold < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = hold;
        }
    }

    public static void selectionSort(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) min = j;
            }

            if (min != i) {
                swap(arr, i, min);
            }
        }
    }

    public static void heapSort(int[] arr) {
        heapify(arr);

        for (int i = arr.length-1; i > 0; i--) {
            int hold = arr[i];
            arr[i] = arr[0];
            arr[0] = hold;
            bubbleDown(arr, 0, i);
        }
    }

    private static void heapify(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
             int parent = (i - 1) / 2;

             if (arr[parent] > arr[i]) continue;

             int hold = arr[i];
             arr[i] = arr[parent];
             arr[parent] = hold;
             bubbleDown(arr, i, arr.length);
        }
    }

    private static void bubbleDown(int[] arr, int index, int last) {
        int left = (index * 2) + 1;
        int right = (index * 2) + 2;
        int max = index;

        if (left < last && arr[left] > arr[max]) {
            max = left;
        }

        if (right < last && arr[right] > arr[max]) {
            max = right;
        }

        if (max == index) return;

        swap(arr, max, index);
        bubbleDown(arr, max, last);
    }

    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) return;

        int[] left = new int[arr.length/2];
        int[] right = new int[arr.length - left.length];

        for (int i = 0; i < arr.length; i++) {
            if (i < left.length) {
                left[i] = arr[i];
            } else {
                right[i - left.length] = arr[i];
            }
        }

        mergeSort(left);
        mergeSort(right);
        int i = 0;
        int j = 0;

        while (i < left.length || j < right.length) {
            if (j == right.length || (i < left.length && left[i] < right[j])) {
                arr[i+j] = left[i++];
            } else {
                arr[i+j] = right[j++];
            }
        }
    }

    public static void quickSort(int[] arr) {
        quickSortHelp(arr, 0, arr.length-1);
    }

    private static void quickSortHelp(int[] arr, int start, int end) {
        if (start >= end) return;

        int pivot = (int) (start + (end - start + 1) * Math.random());
        swap(arr, pivot, end);

        int i = start;

        for (int j = start; j < end; j++) {
            if (arr[j] < arr[end]) {
                swap(arr, j, i);
                i++;
            }
        }

        swap(arr, i, end);
        quickSortHelp(arr, start, i-1);
        quickSortHelp(arr, i+1, end);
    }

    private static void swap (int[] arr, int i1, int i2) {
        int hold = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = hold;
    }
}
