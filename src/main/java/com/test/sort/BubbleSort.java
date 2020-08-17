package com.test.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, 20};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        //为了容易理解， 我们把冒泡排序的演变过程展示出来

        //第一趟排序， 就是将最大的那个数排到最后

        //临时变量
        int temp = 0;
        //表示是否进行过交换，此处为优化点
        boolean flag = false;
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                //如果前面的数比后面的数大则交换
                if(arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //说明本次排序中没有发生交换
            if(!flag) {
                break;
            } else {
                flag = false;//重置flag，进行下次判断
            }
            System.out.println("第"+(i+1)+"排序后的数组");
        }
    }
}
