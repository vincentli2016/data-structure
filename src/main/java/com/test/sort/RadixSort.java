package com.test.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println("排序的处理 arr=" + Arrays.toString(arr));

    }

    private static void radixSort(int[] arr) {
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();

        //第1轮（针对每个元素的个位进行排序处理）
        //定义一个二维数组， 表示10个桶， 每个桶就是一个一维数组
        //说明
        //1。 二维数组包含10个一维数组
        //2。 为了防止在放入数的时候， 数据溢出， 则每个一维数组，大小为arr.length
        //3。 很明显， 基数排序是典型的空间换时间的算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中， 实际存放轮多少个数据， 我们定义一个一维数组来记录各个桶每次放入的数据个数
        //可以这样理解，
        //比如： bucketElementCounts[0], 记录就是bucket【0】桶放入数据的个数
        int[] bucketElementCounts = new int[10];

        //使用循环将代码处理
        for(int i = 0, n = 1; i < maxLength; i++, n*=10) {
            for(int j = 0; j < arr.length; j++) {
                //取出每个元素的个位数
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            //按照这个桶的顺序， 一维数组的下标依次取出数据， 放入原数组
            int index = 0;
            //遍历每一个桶， 并将桶中数据， 放入到原数组
            for(int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据， 我们才放入到原数组
                if(bucketElementCounts[k] != 0) {
                    //循环该桶即第k个桶（即第k个一维数组）
                    for(int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                //第一轮处理后， 需要将每个bucketElementCounts[k] = 0
                bucketElementCounts[k] = 0;
            }
        }
    }

        //基数排序🧮
    private static void radixSortStepByStep(int[] arr) {
        //第1轮（针对每个元素的个位进行排序处理）
        //定义一个二维数组， 表示10个桶， 每个桶就是一个一维数组
        //说明
        //1。 二维数组包含10个一维数组
        //2。 为了防止在放入数的时候， 数据溢出， 则每个一维数组，大小为arr.length
        //3。 很明显， 基数排序是典型的空间换时间的算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中， 实际存放轮多少个数据， 我们定义一个一维数组来记录各个桶每次放入的数据个数
        //可以这样理解，
        //比如： bucketElementCounts[0], 记录就是bucket【0】桶放入数据的个数
        int[] bucketElementCounts = new int[10];


        //第一轮 按照每个元素的个位数进行处理
        for(int j = 0; j < arr.length; j++) {
            //取出每个元素的个位数
            int digitOfElement = arr[j] % 10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }

        //按照这个桶的顺序， 一维数组的下标依次取出数据， 放入原数组
        int index = 0;
        //遍历每一个桶， 并将桶中数据， 放入到原数组
        for(int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中有数据， 我们才放入到原数组
            if(bucketElementCounts[k] != 0) {
                //循环该桶即第k个桶（即第k个一维数组）
                for(int l = 0; l < bucketElementCounts[k]; l++) {
                    //取出元素放入到arr
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            //第一轮处理后， 需要将每个bucketElementCounts[k] = 0
            bucketElementCounts[k] = 0;
        }

        System.out.println("第一轮， 对个位排序的处理 arr=" + Arrays.toString(arr));


        //第二轮 按照每个元素的个位数进行处理
        for(int j = 0; j < arr.length; j++) {
            //取出每个元素的个位数
            int digitOfElement = arr[j] / 10 % 10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }

        //按照这个桶的顺序， 一维数组的下标依次取出数据， 放入原数组
        index = 0;
        //遍历每一个桶， 并将桶中数据， 放入到原数组
        for(int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中有数据， 我们才放入到原数组
            if(bucketElementCounts[k] != 0) {
                //循环该桶即第k个桶（即第k个一维数组）
                for(int l = 0; l < bucketElementCounts[k]; l++) {
                    //取出元素放入到arr
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            //第一轮处理后， 需要将每个bucketElementCounts[k] = 0
            bucketElementCounts[k] = 0;
        }

        System.out.println("第二轮， 对个位排序的处理 arr=" + Arrays.toString(arr));


        //第三轮 按照每个元素的个位数进行处理
        for(int j = 0; j < arr.length; j++) {
            //取出每个元素的个位数
            int digitOfElement = arr[j] / 100 % 10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }

        //按照这个桶的顺序， 一维数组的下标依次取出数据， 放入原数组
        index = 0;
        //遍历每一个桶， 并将桶中数据， 放入到原数组
        for(int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中有数据， 我们才放入到原数组
            if(bucketElementCounts[k] != 0) {
                //循环该桶即第k个桶（即第k个一维数组）
                for(int l = 0; l < bucketElementCounts[k]; l++) {
                    //取出元素放入到arr
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            //第一轮处理后， 需要将每个bucketElementCounts[k] = 0
            bucketElementCounts[k] = 0;
        }

        System.out.println("第三轮， 对个位排序的处理 arr=" + Arrays.toString(arr));


    }


}
