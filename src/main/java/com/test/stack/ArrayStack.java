package com.test.stack;

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;//表示栈顶， 初始化-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public int peek() {
        return stack[top];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("full");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("empty");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list() {
        if(isEmpty()) {
            System.out.println("empty");
            return;
        }

        for(int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    //返回运算符的优先级，优先级是程序员来确定的，优先级使用数字表示
    //数字越大，则优先级就越高
    public int priority(int operator) {
        if(operator == '*' || operator == '/') {
            return 1;
        } else if(operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是不是一个运算符
    public boolean isOperator(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int operator) {
        int res = 0;//存放计算的结果
        switch (operator) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;//注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;//注意顺序
                break;
            default:
                break;
        }

        return res;
    }

}
