package com.bilibili.Queue;

//������ģ�⻷�ζ�����
public class CircleArrayQueue {
    //    ��ʾ�������󳤶�
    private int maxSize;
    //    ��ʾ����ͷ��β
    private int front;
    private int real;
    //    ���ڴ�����ݣ�ģ�����
    private int[] arr;
    
    //    �������еĹ�����
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
//        frontָ�����ͷ
        this.front = 0;
//        realָ�����ĩ�ĺ�һ��λ��
        this.real = 0;
    }
    
    //    �ж϶����Ƿ�����
    public boolean isFull() {
        return (real + 1) % maxSize == front;
    }
    
    //    �ж϶����Ƿ�Ϊ��
    public boolean isEmpty() {
        return real == front;
    }
    
    //    ���ص�ǰ���е���Ч���ݸ���
    public int nowSize() {
        return (real - front + maxSize) % maxSize;
    }
    
    //    ������ݵ�����
    public void addQueue(int n) {
//        �ж϶����Ƿ���
        if (isFull()) {
//            ���Ϊ�����׳��쳣
            throw new RuntimeException("���������޷��������");
        }
        arr[real] = n;
        real++;
        real = real % maxSize;
    }
    
    //    ���ݳ�����
    public int getQueue() {
//        �ж��Ƿ�Ϊ��
        if (isEmpty()) {
//            ���Ϊ���׳��쳣
            throw new RuntimeException("����Ϊ�գ�����ȡ����");
        }
        int result = arr[front];
        front++;
        front = front % maxSize;
        return result;
    }
    
    //    ��ʾ����Ŀǰ����������
    public void showNow() {
//        ��������
        if (isEmpty()) {
            System.out.println("�����ǿյģ�û������");
            return;
        }

//        ��ע�͵Ĵ���Ϊ�������ѭ�����

/* //        ��Ϊѭ��ͷ��ǰ��ѭ��β��ǰ
        if (real > front) {
            for (int i = front; i < real; i++) {
                System.out.printf("%s ", arr[i]);
            }
//            �������ͷ�ڶ���β�ĺ��棬���Ϊ�������֣��ֱ�Ϊ����ͷ������β��������ͷ������β
        } else {
            for (int i = front; i < arr.length; i++) {
                System.out.printf("%s ", arr[i]);
            }
            for (int i = 0; i < real; i++) {
                System.out.printf("%s ", arr[i]);
            }
        } */

//        ����Ϊ������ѭ�����
        
        for (int i = front; i < front + nowSize(); i++) {
            System.out.printf("%d ", arr[i % maxSize]);
        }
        System.out.println();
    }
    
    //    ��ʾ�������е�����
    public void showAll() {
//        ��������
        if (isEmpty()) {
            System.out.println("�����ǿյģ�û������");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s ", arr[i]);
        }
        System.out.println();
    }
}
