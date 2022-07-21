package com.bilibili.stack;

//链表模拟栈测试类
public class LinkedListStackTest {
    public static void main(String[] args) {

//        创建链表模拟队列
        LinkedListStack stack = new LinkedListStack();

//        压入数据
        stack.push(5);

//        显示数据
        stack.show();

//        弹出数据
        System.out.println(stack.pop());
        System.out.println(stack.pop());

//        显示数据
        stack.show();
    }
}
