package com.test.sort;

import java.util.Arrays;

public class SelectiveSort {

    public static void main(String[] args) {
        int[] arr = {3,2,6,4};
        sort(arr);
        System.out.println("结果: " + Arrays.toString(arr));

    }

    private static void sort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int min = arr[minIndex];
            for(int j = 1 + minIndex; j < arr.length ;j++) {
                if(min > arr[j]) {
                    minIndex = j;
                    min = arr[j];
                }
            }

            if(minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
                System.out.println("第一轮" + Arrays.toString(arr));
            }
        }
    }




    public static void selectiveSort(int[] arr) {
        for(int i = 0 ; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[minIndex];
            for(int j = i + 1; j  < arr.length; j++) {
                if(min > arr[j]) {
                    min = arr[j] ;
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }

    }

}
