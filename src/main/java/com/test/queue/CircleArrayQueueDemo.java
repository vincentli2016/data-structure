package com.test.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列");

        CircleArray arrayQueue = new CircleArray(3);

        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(3);

        arrayQueue.showQueue();
        arrayQueue.getQueue();
        arrayQueue.showQueue();
        arrayQueue.getQueue();
        arrayQueue.getQueue();


    }

}

class CircleArray {
    private int maxSize;//数组的最大容量
    private int front;//头
    private int rear;//尾
    private int[] arr;//改数组用于存放数据

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满, 不能加入数据~");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空,不能取数据");
        }

        //这里需要分析front是指向队列的第一个元素
        //1. 先把front 保存到一个临时变量
        //2. 将front后移
        //3. 将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空,无数据");
            return;
        }

        //从front开始遍历, 遍历多少个元素
        //

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前队列有效元素的个数
    public int size() {
        // rear = 2
        // front = 1
        // maxSize = 3
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空, 没有数据");
        }
        return arr[front];
    }
}