package com.test.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9, 3, 1, 4, 5};
        bubble(arr);
        System.out.println("arr:"+Arrays.toString(arr));

    }

    private static void bubble(int[] arr) {

        int temp;
        boolean flag = false;
        for(int i = 0 ; i < arr.length - 1; i++) {
            //第一轮
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if(!flag) {
                break;
            } else {
                flag = false;
            }
            System.out.println(Arrays.toString(arr));
        }

    }

}
