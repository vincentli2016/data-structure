package com.test.sort;

import java.util.Arrays;

public class SelectiveSortDemo {
    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 4};
        sort(arr);
        System.out.println("结果: " + Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            int min = arr[index];
            for(int j = index + 1; j < arr.length; j++) {
                if(min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }

            arr[index] = arr[i];
            arr[i] = min;
        }
    }
}
