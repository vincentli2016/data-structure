package com.test.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        shellSort2(arr);
        System.out.println("希尔排序结束:"+ Arrays.toString(arr));
    }

    //使用逐步推导的方式,来编写希尔排序
    private static void shellSort(int[] arr) {

        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            //希尔排序的第一轮
            //因为第一轮排序是将10个数据分成5组
            for(int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素(共5组, 每组有2个元素)
                for(int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素, 说明交换
                    if(arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }

            System.out.println("希尔排序第一轮结束:"+ Arrays.toString(arr));
        }



//        //希尔排序的第一轮
//        //因为第一轮排序是将10个数据分成5组
//        for(int i = 5; i < arr.length; i++) {
//            //遍历各组中所有的元素(共5组, 每组有2个元素)
//            for(int j = i - 5; j >= 0; j -= 5) {
//                //如果当前元素大于加上步长后的那个元素, 说明交换
//                if(arr[j] > arr[j + 5]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 5];
//                    arr[j + 5] = temp;
//                }
//            }
//        }
//
//        System.out.println("希尔排序第一轮结束:"+ Arrays.toString(arr));
//
//
//
//        //希尔排序的第二轮
//        //因为第二轮排序是将10个数据分成5/2组 = 2组
//        for(int i = 2; i < arr.length; i++) {
//            //遍历各组中所有的元素(共5组, 每组有2个元素)
//            for(int j = i - 2; j >= 0; j -= 2) {
//                //如果当前元素大于加上步长后的那个元素, 说明交换
//                if(arr[j] > arr[j + 2]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 2];
//                    arr[j + 2] = temp;
//                }
//            }
//        }
//
//        System.out.println("希尔排序第二轮结束:"+ Arrays.toString(arr));
//
//
//        //希尔排序的第三轮
//        //因为第二轮排序是将10个数据分成2/2组 = 1组
//        for(int i = 1; i < arr.length; i++) {
//            //遍历各组中所有的元素(共5组, 每组有2个元素)
//            for(int j = i - 1; j >= 0; j -= 1) {
//                //如果当前元素大于加上步长后的那个元素, 说明交换
//                if(arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//
//        System.out.println("希尔排序第三轮结束:"+ Arrays.toString(arr));
    }

    //对交换式希尔排序的优化 => 移位法

    private static void shellSort2(int[] arr) {

        //增量gap, 并逐步的缩小增量
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素开始,逐个对其所在的组进行直接插入排序
             for(int i = gap; i < arr.length; i++) {

                int j = i;
                int temp = arr[j];

                if(arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while后, 就给temp找到了插入的位置
                    arr[j] = temp;
                }
            }
        }
    }

    private static void shellSortEnhance(int[] arr) {
        for(int gap = arr.length/2; gap > 0; gap/=2) {
            for(int i = gap; i < arr.length; i++) {

                int j = i;
                int temp = arr[j];

                while(j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                arr[j] = temp;
            }
        }
    }

}
