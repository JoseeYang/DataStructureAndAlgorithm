package com.bilibili.stack;

//����ģ��ջ��
public class ArrayStack {
//    ����ջ�Ĵ�С
    private int maxSize;
//    ģ�������
    private int[] stack;
//    ջ��ָ��
    private int top;
    
//    ������
    public ArrayStack(int maxSize) {
//        ��ʼ��ջ�Ĵ�С������Ͷ�ָ��
        this.maxSize = maxSize;
        stack = new int[maxSize];
        top = -1;
    }
    
//    ջ���ж�
    public boolean isFull(){
        return top == (maxSize-1);
    }
    
//    ջ���ж�
    public boolean isEmpty(){
        return top == -1;
    }
    
//    ��ջ����
    public void push(int value){
//        ���ж�ջ�Ƿ���
        if (isFull()) {
            System.out.println("ջ��");
            return;
        }
//        ��top����һλ��Ȼ������ݴ���topָ�������
        top++;
        stack[top] = value;
    }
    
//    ��ջ����
    public int pop(){
//        ���ж��Ƿ�Ϊ��
        if (isEmpty()) {
//            �׳��쳣
            throw new RuntimeException("ջ�գ�û������");
        }
//        ȡ��ջ��Ԫ�أ�ջ��ָ���һ������ջ��Ԫ��
        int value = stack[top];
        top--;
        return value;
    }
    
    
//    ����ջ
    public void show(){
//        �ж��Ƿ�Ϊ��
        if (isEmpty()) {
            System.out.println("ջ�գ�û������");
            return;
        }
//        ��Ҫ��ջ����ʼ��ʾ����
        for (int i = top; i >=0 ; i--) {
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }
        
    }
}
