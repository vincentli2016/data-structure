package com.test.stack;

public class Calculator {

    public static void main(String[] args) {
        String expression = "73+2*6-2";
        //创建两个栈， 数栈， 符号栈
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operatorStack = new ArrayStack(10);

        //定义需要的相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int operator = 0;
        int res = 0;
        char ch = ' ';//将每次扫描得到的char保存到ch
        String keepNum = "";//用于拼接多位数
        //开始循环扫描expression
        while(true) {
            //一次得到express里面的每一个字符
            ch = expression.substring(index, index+1).charAt(0);
            //判断
            if(operatorStack.isOperator(ch)) {
                if(!operatorStack.isEmpty()) {//判断当前的符号栈是否为空
                    //处理，如果有操作符，需要进行优先级比较
                    if(operatorStack.priority(ch) <= operatorStack.priority(operatorStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operator = operatorStack.pop();
                        res = numStack.cal(num1, num2, operator);
                        //把运算的结果入数栈
                        numStack.push(res);
                        //帮当前操作符入符号栈
                        operatorStack.push(ch);
                    } else {
                        //如果当前操作符大于
                        operatorStack.push(ch);
                    }
                } else {
                    //如果为空，直接入栈
                    operatorStack.push(ch);
                }
            } else {//如果是数字， 直接入栈
                //numStack.push(ch - 48);//ASCI表 1是49
                //分析思路
                //1. 当处理多位数时， 不能发现是一个数就立即入栈， 因为它可能是多位数
                //2. 在处理数时候， 需要向expression表达式的后面index后再看一位， 如果是数就继续扫描， 如果是符号才入站
                //3. 因此需要定一个字符串变量， 用于拼接

                //处理多位数
                keepNum += ch;
                if(index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //拼接数字,一直到后一位是运算符的时候,就将拼接好的数值入栈
                    if(operatorStack.isOperator(expression.substring(index+1, index+2).charAt(0))) {
                        //如果后一位是运算符则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";//清空
                    }
                }
            }
            //让index+1， 并判断是否扫描到expression的最后
            index++;

            if(index >= expression.length()) {
                break;
            }
        }

        //当表达式扫描完毕， 就顺序从数栈和符号栈中出栈， 并完成计算
        while(true) {
            //如果符号栈为空，则计算结束， 数栈中只有一个数字
            if(operatorStack.isEmpty()) {
                break;
            } else {
                num1 = numStack.pop();
                num2 = numStack.pop();
                operator = operatorStack.pop();
                res = numStack.cal(num1, num2, operator);
                numStack.push(res);
            }
        }


        //将数栈的最后一个数 pop出，就是结果
        System.out.printf("表达式%s = %d", expression, numStack.pop());
    }

}
