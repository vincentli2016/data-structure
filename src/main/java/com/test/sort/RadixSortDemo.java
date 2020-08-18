package com.test.sort;

import java.util.Arrays;

public class RadixSortDemo {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println("排序的处理 arr=" + Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        int max = arr[0];
        for(int i = 1 ; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        int maxLength = (max + "").length();
        for(int i = 0, n= 1; i < maxLength; i++, n*=10) {
            int[][] bucket = new int[10][arr.length];
            int[] bucketElementCount = new int[10];

            for(int j = 0 ; j < arr.length; j++) {
                int singleDigit = arr[j] / n % 10;
                bucket[singleDigit][bucketElementCount[singleDigit]] = arr[j];
                bucketElementCount[singleDigit]++;
            }

            int index = 0;
            for(int k = 0 ; k < bucketElementCount.length; k++) {
                if(bucketElementCount[k] != 0) {
                    for(int l = 0; l < bucketElementCount[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                bucketElementCount[k] = 0;
            }
        }


//        int[][] bucket = new int[10][arr.length];
//        int[] bucketElementCount = new int[10];
//
//        for(int j = 0 ; j < arr.length; j++) {
//            int singleDigit = arr[j] % 10;
//            bucket[singleDigit][bucketElementCount[singleDigit]] = arr[j];
//            bucketElementCount[singleDigit]++;
//        }
//
//        int index = 0;
//        for(int k = 0 ; k < bucketElementCount.length; k++) {
//            if(bucketElementCount[k] != 0) {
//                for(int l = 0; l < bucketElementCount[k]; l++) {
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//            }
//            bucketElementCount[k] = 0;
//        }
//
//
//        for(int j = 0 ; j < arr.length; j++) {
//            int singleDigit = arr[j] / 10 % 10;
//            bucket[singleDigit][bucketElementCount[singleDigit]] = arr[j];
//            bucketElementCount[singleDigit]++;
//        }
//
//        index = 0;
//        for(int k = 0 ; k < bucketElementCount.length; k++) {
//            if(bucketElementCount[k] != 0) {
//                for(int l = 0; l < bucketElementCount[k]; l++) {
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//            }
//            bucketElementCount[k] = 0;
//        }
//
//
//
//        for(int j = 0 ; j < arr.length; j++) {
//            int singleDigit = arr[j] / 10 / 10 % 10;
//            bucket[singleDigit][bucketElementCount[singleDigit]] = arr[j];
//            bucketElementCount[singleDigit]++;
//        }
//
//        index = 0;
//        for(int k = 0 ; k < bucketElementCount.length; k++) {
//            if(bucketElementCount[k] != 0) {
//                for(int l = 0; l < bucketElementCount[k]; l++) {
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//            }
//            bucketElementCount[k] = 0;
//        }
    }
}
