package com.bilibili.stack;

//����ģ��ջ�������
public class ArrayStackTest {
    public static void main(String[] args) {
//        ����һ������Ϊ5��ջ
        ArrayStack stack = new ArrayStack(5);
        
//        ѹջ
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        
//        ��ʾջ�Ļ�����Ϣ
        stack.show();
    
//        ��ջ
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
    
}
