package com.test.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        int l = left;//左下标
        int r = right;//右下标
        //中间
        int pivot = arr[(left + right) / 2];
        int temp = 0; //临时变量, 作为交换
        //while循环的目的是让比pivot小的放到它的左边, 比pivot大的值放到右边
        while(l < r) {
            //在pivot的左边一直找, 找到大于等于pivot的值才退出
            while(arr[l] < pivot) {
                l += 1;
            }
            while(arr[r] > pivot) {
                r -= 1;
            }
            //如果l > r成立, 说明pivot的左右两边的值, 已经按照左边全部是小于等于pivot的值,右边全部是大于等于pivot的值
            if( l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完成后, 发现arr[l] == pivot 前移 r--
            if(arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完成后, 发现arr[r] == pivot 前移 l++
            if(arr[r] == pivot) {
                l += 1;
            }
        }

        //如果l == r, 必须l++, r--, 否则会出现栈溢出
        if(l == r){
            l += 1;
            r -= 1;
        }
        //向左递归
        if(left < r) {
           quickSort(arr, left, r);
        }
        //向右递归
        if(right > l) {
            quickSort(arr, l, right);
        }
    }

}
