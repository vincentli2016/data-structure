package com.test;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int insertedValue = arr[i];
            int insertedIndex = i - 1;
            while(insertedIndex >= 0 && insertedValue < arr[insertedIndex]) {
                arr[insertedIndex + 1] = arr[insertedIndex];
                insertedIndex--;
            }
            arr[insertedIndex + 1] = insertedValue;
        }
    }
}
