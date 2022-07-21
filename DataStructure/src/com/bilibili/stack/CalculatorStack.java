package com.bilibili.stack;

//计算器专用栈类
//用的是数组模拟栈
public class CalculatorStack {
    //    定义栈的大小
    private int maxSize;
    //    模拟的数组
    private int[] stack;
    //    栈顶指针
    private int top;
    
    //    构造器
    public CalculatorStack(int maxSize) {
//        初始化栈的大小，数组和顶指针
        this.maxSize = maxSize;
        stack = new int[maxSize];
        top = -1;
    }
    
    //    栈满判断
    public boolean isFull() {
        return top == (maxSize - 1);
    }
    
    //    栈空判断
    public boolean isEmpty() {
        return top == -1;
    }
    
    //    入栈函数
    public void push(int value) {
//        先判断栈是否满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
//        把top上移一位，然后把数据存入top指向的数组
        top++;
        stack[top] = value;
    }
    
    //    出栈函数
    public int pop() {
//        先判断是否为空
        if (isEmpty()) {
//            抛出异常
            throw new RuntimeException("栈空，没有数据");
        }
//        取出栈顶元素，栈顶指针减一，返回栈顶元素
        int value = stack[top];
        top--;
        return value;
    }
    
    
    //    遍历栈
    public void show() {
//        判断是否为空
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
            return;
        }
//        需要从栈顶开始显示数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
        
    }
    
    /**
     * 通过传入的数据判断运算符的优先级
     *
     * @param oper 需要判断优先级的符号
     * @return 1的优先级大于0，返回-1说明传入的数据有误
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }
    
    /**
     * 判断传入的数据是不是操作符
     *
     * @param val 传入的数据
     * @return true表示时操作符 false表示不是操作符
     */
    public boolean isOper(int val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }
    
    /**
     * 传入两个操作数和一个操作符，输出计算结果
     * @param num1 第一个操作数
     * @param num2 第二个操作数
     * @param oper 符号数
     * @return int类型计算结果
     */
    public int cal(int num1, int num2, int oper) {
        return switch (oper) {
            case '+' -> num1 + num2;
            case '-' -> num2 - num1;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> 0;
        };
    }
    
//    偷看一眼栈顶的元素并返回
    public int peek(){
        return stack[top];
    }
    
}
