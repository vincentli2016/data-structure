package com.test.sort;

import java.util.Arrays;

public class ShellSortDemo {

    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        sort3(arr);
        System.out.println("希尔排序结束:"+ Arrays.toString(arr));
    }

    private static void sort3(int[] arr) {
        for(int gap = arr.length / 2; gap > 0; gap/=2) {
            for(int i = gap; i < arr.length; i++) {
                int insertedValue = arr[i];
                int insertedIndex = i - gap;

                if(insertedValue < arr[insertedIndex]) {
                    while(insertedIndex >= 0 && insertedValue < arr[insertedIndex]) {
                        arr[insertedIndex + gap] = arr[insertedIndex];
                        insertedIndex -= gap;
                    }
                    arr[insertedIndex + gap] = insertedValue;
                }
            }
        }

    }


    private static void sort2(int[] arr) {



        int gap = 5;
        for(int i = gap; i < arr.length;i++) {
            for(int j = i - gap; j >= 0 ; j-=gap) {
                if(arr[j] > arr[j + gap]) {
                    int temp = arr[j];
                    arr[j] = arr[j + gap];
                    arr[j + gap] = temp;
                }
            }
        }

        gap = 2;
        for(int i = gap; i < arr.length;i++) {
            for(int j = i - gap; j >= 0 ; j-=gap) {
                if(arr[j] > arr[j + gap]) {
                    int temp = arr[j];
                    arr[j] = arr[j + gap];
                    arr[j + gap] = temp;
                }
            }
        }

        gap = 1;
        for(int i = gap; i < arr.length;i++) {
            for(int j = i - gap; j >= 0 ; j-=gap) {
                if(arr[j] > arr[j + gap]) {
                    int temp = arr[j];
                    arr[j] = arr[j + gap];
                    arr[j + gap] = temp;
                }
            }
        }






















//        int gap = 5;
//        for(int i = gap; i < arr.length; i++) {
//            for(int j = i - gap; j >= 0; j-=gap) {
//                if(arr[j] < arr[j + gap]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + gap];
//                    arr[j + gap] = temp;
//                }
//            }
//        }
//
//        gap = 2;
//        for(int i = gap; i < arr.length; i++) {
//            for(int j = i - gap; j >= 0; j-=gap) {
//                if(arr[j] < arr[j + gap]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + gap];
//                    arr[j + gap] = temp;
//                }
//            }
//        }
//
//        gap = 1;
//        for(int i = gap; i < arr.length; i++) {
//            for(int j = i - gap; j >= 0; j-=gap) {
//                if(arr[j] < arr[j + gap]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + gap];
//                    arr[j + gap] = temp;
//                }
//            }
//        }

    }


    private static void sort(int[] arr) {

        for(int gap = arr.length /2; gap > 0;gap/=2) {
            for(int j = gap; j < arr.length; j++) {

                int insertedValue = arr[j];
                int insertedIndex = j - gap;

                while(insertedIndex >= 0 && insertedValue < arr[insertedIndex]) {
                    arr[j] = arr[insertedIndex];
                    insertedIndex -= gap;
                }
                arr[insertedIndex + gap] = insertedValue;

            }

        }

//        int gap = 5;
//        for(int j = gap; j < arr.length; j++) {
//
//            int insertedValue = arr[j];
//            int insertedIndex = j - gap;
//
//            while(insertedIndex >= 0 && insertedValue < arr[insertedIndex]) {
//                arr[j] = arr[insertedIndex];
//                insertedIndex -= gap;
//            }
//            arr[insertedIndex + gap] = insertedValue;
//
//        }
//
//        gap = 2;
//        for(int j = gap; j < arr.length; j++) {
//
//            int insertedValue = arr[j];
//            int insertedIndex = j - gap;
//
//            while(insertedIndex >= 0 && insertedValue < arr[insertedIndex]) {
//                arr[j] = arr[insertedIndex];
//                insertedIndex -= gap;
//            }
//            arr[insertedIndex + gap] = insertedValue;
//
//        }
//
//        gap = 1;
//        for(int j = gap; j < arr.length; j++) {
//
//            int insertedValue = arr[j];
//            int insertedIndex = j - gap;
//
//            while(insertedIndex >= 0 && insertedValue < arr[insertedIndex]) {
//                arr[j] = arr[insertedIndex];
//                insertedIndex -= gap;
//            }
//            arr[insertedIndex + gap] = insertedValue;
//
//        }
    }
}
