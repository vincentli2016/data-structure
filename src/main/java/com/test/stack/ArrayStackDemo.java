package com.test.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试一下ArrayStack是否正确
        //先创建一个ArrayStack对象
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;// 是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while(loop) {
            System.out.println("show：表示显示栈");
            System.out.println("exit：退出");
            System.out.println("push：入栈");
            System.out.println("pop：出栈");

            System.out.println("请输入你的选择");

            key = scanner.next();

            switch (key) {
                case "show" : stack.list();break;
                case "exit" :
                    scanner.close();
                    loop=false;
                    break;
                case "push" :
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop" :
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是%d\n", res);
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

            }
        }
        System.out.println("程序退出");
    }
}