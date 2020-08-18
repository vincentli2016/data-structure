package com.test.search;

import java.util.Arrays;

public class FibonacciSearch {

    private static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(fibSearch(arr, 1));//0
        System.out.println(fibSearch(arr, 1234));//5
    }

    //因为后面我们mid=low+F（k - 1） - 1,需要使用到斐波那契数列， 因此我们需要先获取一个斐波那契数列
    //非递归方式获得一个斐波那契数列
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }


    //编写斐波那契查找算法
    //使用非递归的方式编写算法

    /**
     * @param arr 数组
     * @param key 查找的关键字
     * @return 返回对应下标， 如果没有-1
     */
    private static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0; //表示斐波那契分割数值的下标
        int mid = 0;//存放mid值
        int f[] = fib();//获取到斐波那契数列
        //获取到斐波那契分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }

        //因为f[k]可能大于数组arr的长度， 因此我们需要使用Arrays类构造一个新的数组， 并指向arr
        //不足的部分会使用0填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        //实际上需要使用a数组的最后的数填充temp
        //举例
        //temp 拷贝完{1, 8, 10, 89, 1000, 1234， 0， 0， 0}， 我们希望{1, 8, 10, 89, 1000, 1234， 1234， 1234， 1234}
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        //使用while来循环处理找到我们的数
        while (low <= high) {//只要这个条件满足， 就可以一直找
            mid = low + f[k - 1] - 1;
            if(key < temp[mid]) {//说明我们应该继续向数组的前面查找，也就是左边
                high = mid - 1;
                k--;//为什么是k--
                //1。 全部元素 = 前面的元素 + 后面的元素
                //2。 f[k] = f[k - 1] + f[k -2 ]
                //因为前面有f[k -1]个元素， 所以我们可以继续拆分 f[k - 1] = f[k-2] + f[k - 3]
                //即在f[k - 1]的前面继续查找 k--
                //即下次循环mid = f[k - 1 - 1] - 1
            } else if(key > temp[mid]) {//说明我们应该继续向数组的后面查找，也就是右边
                low = mid + 1;
                //为什么是k-2
                //说明
                //1。 全部元素 = 前面的元素 + 后面的元素
                //2. f[k] = f[k - 1] + f[k -2 ]
                //3. 因为后面我们有f[k -2]个元素， 所以我们可以继续拆分 f[k - 1] = f[k-3] + f[k - 4]
                //4. 即在f[k - 2]的前面进行查找 k -=2
                //5。即下次循环mid = f[k - 1 - 2] - 1
                k -= 2;
            } else {//找到
                //需要确定返回的是那个下标
                if(mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }

        return -1;

    }

}
