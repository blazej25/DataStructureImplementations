package Sorts;

import Heap.*;
import Lists.DynamicList.List;

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
                int hold = arr[i];
                arr[i] = arr[min];
                arr[min] = hold;
            }
        }
    }

    public static void heapSort(int[] arr) {
        //Heap<Integer> heap = new ListHeap<Integer>(List.listOf(arr));
    }
}
