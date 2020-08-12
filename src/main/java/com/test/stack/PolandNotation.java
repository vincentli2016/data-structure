package com.test.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] args) {

        //完成将一个中最表达式转成后缀表达式的功能
        //说明
        //1. 1+((2+3)*4)-5 => 转成 1 2 3 + 4 * + 5 -

        String expression = "1+((2+3)*4)-5";

        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println(infixExpressionList); //[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]

        //将得到的中缀表达式对应的list转换成后缀表达式对应的List， 小括号会被消除掉
        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println(suffixExpressionList);


//        //先定义一个逆波兰表达式
//        //(3+4)*5-6  =>    3 4 + 5 * 6 -
//        //说明： 为了方便， 逆波兰表达式的数字和符号用空格隔开
//        String suffixExpression = "3 4 + 5 * 6 -";
//        //思路
//        //1. 先将expression放到ArrayList中
//        //2. 将ArrayList传递给一个方法， 遍历ArrayList配合栈 完成计算
//        List<String> list = getListString(suffixExpression);
//        System.out.println("list="+ list);
//
//        int res = calculate(list);
//        System.out.println("计算的结果是=" + res);
    }

    public static List<String> parseSuffixExpressionList(List<String> list) {
        //定义两个栈
        Stack<String> s1 = new Stack<>(); //符号栈
        //存储中间结果，在整个过程中s2一直没出出栈的操作，而且后面还需要逆序输出，比较麻烦，这里就不用Stack了， 直接使用List
        //Stack<String> s2 = new Stack<>();
        List<String> s2 = new ArrayList<>();

        //开始遍历list
        for (String item : list) {
            //如果是一个数，加入到s2
            if(item.matches("\\d+")) {
                s2.add(item);
            } else if(item.equals("(")) {
                s1.push(item);
            } else if(item.equals(")")) {
                //如果是右括号，则依次弹出s1栈顶的运算符，并压入s2,直到遇到左括号为止,此时将这一对括号丢弃
                while(!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//将左括号弹出，消除小括号
            } else {
                //当item的优先级小于等于栈顶运算符，将s1栈顶的运算符弹出并加入s2
                while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //最后还需要将item压入栈中
                s1.push(item);
            }
        }

        //将s1中剩余的运算符加入到s2中
         while(s1.size() != 0) {
             s2.add(s1.pop());
         }

        return s2;
    }

    //将中缀表达式转成对应的List
    public static List<String> toInfixExpressionList(String expression) {
        //定义一个List， 存放中缀表达式对应的内容
        List<String> list = new ArrayList<>();
        int i = 0;
        String str; //对多位数的拼接工作
        char c;
        do {
            //如果c是一个非数字，就需要加入到list中
            if((c=expression.charAt(i)) < 48 || (c=expression.charAt(i)) < 57) {
                list.add("" + c);
                i++;
            } else {//需要拼接，考虑到多位数的问题
                str = "";
                while(i < expression.length() && (c=expression.charAt(i)) >= 48 && (c=expression.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                list.add(str);
            }
        } while(i < expression.length());
        return list;
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

class Operation {
    private static final int ADD = 1;
    private static final int SUB = 1;
    private static final int MUL = 2;
    private static final int DIV = 2;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+": result = ADD; break;
            case "-": result = SUB; break;
            case "*": result = MUL; break;
            case "/": result = DIV; break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}