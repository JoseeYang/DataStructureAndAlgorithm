package com.bilibili.stack;

//����ģ��ջ������
public class LinkedListStackTest {
    public static void main(String[] args) {

//        ��������ģ�����
        LinkedListStack stack = new LinkedListStack();

//        ѹ������
        stack.push(5);

//        ��ʾ����
        stack.show();

//        ��������
        System.out.println(stack.pop());
        System.out.println(stack.pop());

//        ��ʾ����
        stack.show();
    }
}
