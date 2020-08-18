package com.test.sort;

import java.util.Arrays;

public class InsertSortDemo {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {


        for(int i = 1; i < arr.length; i++) {
            int insertedValue = arr[i]; //插入值
            int insertedIndex = i - 1; //插入索引位于插入值的前一位

            while (insertedIndex >= 0 && insertedValue < arr[insertedIndex]) {
                arr[insertedIndex + 1] = arr[insertedIndex];
                insertedIndex--;
            }
            arr[insertedIndex + 1] = insertedValue;
        }





    }
}
