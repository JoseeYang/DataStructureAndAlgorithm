package com.bilibili.Queue;

public class ArrayQueueTest {
    public static void main(String[] args) {

//        ����һ�����ж���,����Ϊ5
        ArrayQueue arrayQueue = new ArrayQueue(5);
        
        arrayQueue.addQueue(10);
        arrayQueue.addQueue(20);
        arrayQueue.addQueue(30);
        arrayQueue.show();
        try {
            System.out.println(arrayQueue.getQueue());
            System.out.println(arrayQueue.getQueue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        arrayQueue.addQueue(40);
        arrayQueue.show();
    }
}
