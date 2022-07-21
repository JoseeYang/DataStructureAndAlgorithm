package com.bilibili.stack;

//数组模拟栈类测试类
public class ArrayStackTest {
    public static void main(String[] args) {
//        创建一个长度为5的栈
        ArrayStack stack = new ArrayStack(5);
        
//        压栈
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        
//        显示栈的基本信息
        stack.show();
    
//        出栈
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
    
}
