package com.test.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while(loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加队列");
            System.out.println("g(get):获取队列");
            System.out.println("h(head):查看队列头");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);

                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                    }


                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("取出的数据头是%d\n",res);
                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }

    }
}

//使用数组模拟队列, 编写一个ArrayQueue类

class ArrayQueue {
    private int maxSize;//数组的最大容量
    private int front;//头
    private int rear;//尾
    private int[] arr;//改数组用于存放数据

    //创建队列的构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部, 分析出front是指向队列头的前一个位置
        rear = -1; //指向队列尾
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if(isFull()) {
            System.out.println("队列满, 不能加入数据~");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列空,不能取数据");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if(isFull()) {
            System.out.println("队列空,无数据");
            return;
        }
        for (int i = 0 ; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public int headQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列空, 没有数据");
        }
        return arr[front+1];
    }

}