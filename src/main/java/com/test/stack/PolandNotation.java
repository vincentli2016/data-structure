package com.test.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] args) {
        //先定义一个逆波兰表达式
        //(3+4)*5-6  =>    3 4 + 5 * 6 -
        //说明： 为了方便， 逆波兰表达式的数字和符号用空格隔开
        String suffixExpression = "3 4 + 5 * 6 -";
        //思路
        //1. 先将expression放到ArrayList中
        //2. 将ArrayList传递给一个方法， 遍历ArrayList配合栈 完成计算
        List<String> list = getListString(suffixExpression);
        System.out.println("list="+ list);

        int res = calculate(list);
        System.out.println("计算的结果是=" + res);
    }

    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    public static int calculate(List<String> ls) {
        //创建一个栈， 只需要一个栈即可
        Stack<String> stack = new Stack<>();
        //遍历ls
        for (String item : ls) {
            //这里使用一个正则表达式取出数
            if(item.matches("\\d+")) {//匹配多位数
                //入栈
                stack.push(item);
            } else {
                //pop出两个数，并运算, 再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")) {
                    res = num1 + num2;
                } else if(item.equals("-")) {
                    res = num1 + num2;
                } else if(item.equals("*")) {
                    res = num1 * num2;
                } else if(item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("error");
                }
                //把res入栈
                stack.push("" + res);
            }
        }
        //最后留在栈中的数就是运算的结果
        return Integer.parseInt(stack.pop());
    }
}
