package com.test.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        insertSort(arr);
    }


    private static void sort(int[] arr) {

        int insertVal  = arr[1];
        int insertIndex = 1 - 1;

        while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }

        arr[insertIndex + 1] = insertVal;

        System.out.println(Arrays.toString(arr));






    }

    private static void insertSort(int[] arr) {
        //第一轮{101, 34, 119, 1} => {34, 101, 119, 1}

        for(int i = 1 ;  i < arr.length; i++) {
            //定义待插入的数
            int insertVal = arr[i];
            int insertIndex = i - 1;//也就是arr[1]的前面数的下标

            //给insertValue找到插入的位置
            //insertIndex >= 0 保证不越界
            //insertVal < arr[insertIndex] 还没有找到插入的位置
            while(insertIndex >= 0 && insertVal < arr[insertIndex]) {//保证不越界
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            if(insertIndex - 1 != i) {
                //当循环结束时, 说明找到插入位置, insertIndex + 1
                arr[insertIndex + 1] = insertVal;
            }

            System.out.println("第"+i+"轮结束");
            System.out.println(Arrays.toString(arr));
        }

    }
}
