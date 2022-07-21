package com.bilibili.stack;

//数组模拟栈类
public class ArrayStack {
//    定义栈的大小
    private int maxSize;
//    模拟的数组
    private int[] stack;
//    栈顶指针
    private int top;
    
//    构造器
    public ArrayStack(int maxSize) {
//        初始化栈的大小，数组和顶指针
        this.maxSize = maxSize;
        stack = new int[maxSize];
        top = -1;
    }
    
//    栈满判断
    public boolean isFull(){
        return top == (maxSize-1);
    }
    
//    栈空判断
    public boolean isEmpty(){
        return top == -1;
    }
    
//    入栈函数
    public void push(int value){
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
    public int pop(){
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
    public void show(){
//        判断是否为空
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
            return;
        }
//        需要从栈顶开始显示数据
        for (int i = top; i >=0 ; i--) {
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }
        
    }
}
