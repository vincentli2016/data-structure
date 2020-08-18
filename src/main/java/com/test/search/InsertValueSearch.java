package com.test.search;

public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for(int i = 0; i<=100; i++) {
            arr[i] = i + 1;
        }

       int index =  insertValueSearch(arr, 0, arr.length - 1, 100);
        System.out.println(index);
    }

    private static int insertValueSearch(int[] arr, int left, int right, int findVal) {

        //注意 findVal < arr[0] || findVal > arr[arr.length - 1] 必须有
        //否则我们得到的mid可能越界
        if(left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }

        //求出mid
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if(findVal > midValue) {
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if(findVal < midValue) {
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return midValue;
        }


    }

}
