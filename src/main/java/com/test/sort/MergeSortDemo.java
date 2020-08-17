package com.test.sort;

import java.util.Arrays;

public class MergeSortDemo {

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length]; //归并排序需要额外的空间
        splitAndSort(arr, 0, arr.length - 1, temp);
        System.out.println("归并排序后=" + Arrays.toString(arr));
    }

    private static void splitAndSort(int[] arr, int left, int right, int[] temp) {
        if(left < right) {
            int mid = (left + right) / 2;
            splitAndSort(arr, left, mid, temp);
            splitAndSort(arr, mid + 1, right, temp);

            System.out.printf("left: %d, right: %d", left, right);
            System.out.println();

            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        //将数组拆分成两个部分， 将最小值放到临时数组temp中
        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //将剩余的数组元素拷贝到temp中
        while(i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }

        while(j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        //将temp数组中的数据填充回arr中
        t = 0;
        int tempLeft = left;
        while(tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
