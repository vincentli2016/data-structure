package com.test.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {

        //二分查找必须使用有序数组
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int result = binarySearch(arr, 0, arr.length - 1, 88);
        System.out.println(result);

    }

    /**
     * 二分查找
     * @param arr 数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param findVal 要查找的值
     * @return
     */
    private static int binarySearch(int[] arr, int left, int right, int findVal) {

        //当left > right 时， 说明找不到
        if(left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if(findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if(findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    /**
     * {1, 8, 10, 89, 1000, 1000, 1234} 当一个有序数组中
     * 有多个相同的值时， 如何将所有的数值查找到， 比如这里的1000
     *
     * 思路分析
     * 在找到mid索引值， 不要马上返回
     * 向mid索引左边扫描， 将所有满足1000的元素的下标， 加入到集合
     * 向mid索引右边扫描， 将所有满足1000的元素的下标， 加入到集合
     * 将ArrayList返回
     */

    private static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

        //当left > right 时， 说明找不到
        if(left > right) {
            return new ArrayList<>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if(findVal > midVal) {
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if(findVal < midVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            List<Integer> resIndexList = new ArrayList<>();
            int temp = mid - 1;

            while(true) {
                if(temp < 0 || arr[temp] != findVal) {
                    break;
                }
                //否则就把temp放入到集合中
                resIndexList.add(temp);
               temp--; //temp左移
            }
            resIndexList.add(mid);
            temp = mid + 1;
            while(true) {
                if(temp < 0 || arr[temp] != findVal) {
                    break;
                }
                //否则就把temp放入到集合中
                resIndexList.add(temp);
                temp++; //temp右移
            }
            return resIndexList;
        }
    }
}
