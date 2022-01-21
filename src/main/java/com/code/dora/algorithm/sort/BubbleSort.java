package com.code.dora.algorithm.sort;

public class BubbleSort {

    public static void sort(int[] arr) {
        int length = arr.length;
        int posMax = length -1;
        for (int i = 0; i < posMax; i++) {
            for (int j = 0; j < posMax - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 1, 3, 5, 10, 2, 6};
        sort(arr);
        for (int i : arr) {
            System.out.print(i);
            System.out.print(",");
        }
    }

}
