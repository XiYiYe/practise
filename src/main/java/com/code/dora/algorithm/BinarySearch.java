package com.code.dora.algorithm;

public class BinarySearch {

    public static int findPos(int[] arr, int data) {
        if (arr == null) {
            return -1;
        }
        int begin = 0;
        int end = arr.length;
        int mid;
        while (begin < end) {
            mid = (begin + end) / 2 + 1;
            if (arr[mid] == data) {
                return mid + 1;
            } else if (arr[mid] > data) {
                end = mid - 1;
            } else if (arr[mid] < data){
                begin = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,5,6,7,8,9,10};
        int pos = findPos(arr, 10);
        System.out.println("find num pos:" + pos);
    }

}
