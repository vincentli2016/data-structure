package com.test.sort;

import java.util.Arrays;

public class BubbleSortDemo {

    public static void main(String[] args) {
        int[] arr = {9, 3, 1, 4, 5};
        bubble(arr);
        System.out.println("arr:"+ Arrays.toString(arr));
    }

    private static void bubble(int[] arr) {
        for(int i = 0 ; i < arr.length - 1; i++) {
            for(int j = 1; j < arr.length - i; j++) {
                if(arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
