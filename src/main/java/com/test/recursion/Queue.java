package com.test.recursion;

public class Queue {

    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array，保存皇后摆放位置的结果
    int[] array = new int[max];

    static int count = 0;
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.check(0);
        System.out.printf("一共有%d个解",count);
    }

    //编写一个方法， 放置第n个皇后
    //特别注意， check 是每一次递归时， 进入到check中， 都有一个for循环
    private void check(int n) {
        if(n == max) { // n = 8, 表示8个皇后已经放好了
            print();
            return;
        }

        //依次放置皇后，并判断是否冲突
        for(int i = 0; i < max; i++) {
            //先把当前这个皇后n， 放到该行的第一列
            array[n] = i;
            //判断当放置第n个皇后到i列时， 是否冲突
            if(judge(n)) {//表示不冲突
                //接着放n+1个皇后,即开始递归
                check(n + 1);
            }
            //如果冲突就继续执行 array[n] = i; 即将第n个皇后， 放置在本行的后移的位置
        }
    }


    //查看当我们摆放第n个皇后，检测该皇后是否和前面已经摆放的皇后冲突
    /**
     *
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {
        for(int i = 0; i < n; i++) {
            //说明
            //1. array[i] == array[n], 表示判断第n个皇后是否和前面的n-1个皇后在同一列
            //2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i个皇后是否在同一斜线
            // n = 1 放置第2列1 n = 1
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }


    //打印皇后摆放后的位置
    private void print() {
        count++;
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
