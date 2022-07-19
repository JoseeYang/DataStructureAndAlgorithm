package com.bilibili.Queue;

//ʹ������ģ��Ķ�����
public class ArrayQueue {
    //    ��ʾ�������󳤶�
    private int maxSize;
    //    ��ʾ����ͷ��β
    private int front;
    private int real;
    //    ���ڴ�����ݣ�ģ�����
    private int[] arr;
    
    //    �������еĹ�����
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
//        frontָ�����ͷ��ǰһ��λ�ã�����������ͷ
        this.front = -1;
//        realָ�����ĩ����������ĩβ
        this.real = -1;
    }
    
    //    �ж϶����Ƿ�����
    public boolean isFull() {
        return real == maxSize - 1;
    }
    
    //    �ж϶����Ƿ�Ϊ��
    public boolean isEmpty() {
        return real == front;
    }
    
    //    ������ݵ�����
    public void addQueue(int n) {
//        �ж϶����Ƿ���
        if (isFull()) {
            System.out.println("���������޷��������");
        }
        real++;
        arr[real] = n;
    }
    
    //    ���ݳ�����
    public int getQueue() {
//        �ж��Ƿ�Ϊ��
        if (isEmpty()) {
//            ���Ϊ���׳��쳣
            throw new RuntimeException("����Ϊ�գ�����ȡ����");
        }
        front++;
        return arr[front];
    }
    
    //    ��ʾ����Ŀǰ����������
    public void show() {
//        ��������
        if (isEmpty()) {
            System.out.println("�����ǿյģ�û������");
            return;
        }
        for (int i = front + 1; i < arr.length; i++) {
            System.out.printf("%s ", arr[i]);
        }
        System.out.println();
    }
}
