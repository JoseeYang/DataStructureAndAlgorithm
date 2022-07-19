package com.bilibili.Queue;

//使用数组模拟的队列类
public class ArrayQueue {
    //    表示数组的最大长度
    private int maxSize;
    //    表示队列头和尾
    private int front;
    private int real;
    //    用于存放数据，模拟队列
    private int[] arr;
    
    //    创建队列的构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
//        front指向队列头的前一个位置，不包含队列头
        this.front = -1;
//        real指向队列末，包括队列末尾
        this.real = -1;
    }
    
    //    判断队列是否已满
    public boolean isFull() {
        return real == maxSize - 1;
    }
    
    //    判断队列是否为空
    public boolean isEmpty() {
        return real == front;
    }
    
    //    添加数据到队列
    public void addQueue(int n) {
//        判断队列是否满
        if (isFull()) {
            System.out.println("队列满，无法添加数据");
        }
        real++;
        arr[real] = n;
    }
    
    //    数据出队列
    public int getQueue() {
//        判断是否为空
        if (isEmpty()) {
//            如果为空抛出异常
            throw new RuntimeException("队列为空，不能取数据");
        }
        front++;
        return arr[front];
    }
    
    //    显示队列目前的所有数据
    public void show() {
//        遍历数组
        if (isEmpty()) {
            System.out.println("队列是空的，没有数据");
            return;
        }
        for (int i = front + 1; i < arr.length; i++) {
            System.out.printf("%s ", arr[i]);
        }
        System.out.println();
    }
}
