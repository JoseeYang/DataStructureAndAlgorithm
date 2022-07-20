package com.bilibili.Queue;

//用数组模拟环形队列类
public class CircleArrayQueue {
    //    表示数组的最大长度
    private int maxSize;
    //    表示队列头和尾
    private int front;
    private int real;
    //    用于存放数据，模拟队列
    private int[] arr;
    
    //    创建队列的构造器
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
//        front指向队列头
        this.front = 0;
//        real指向队列末的后一个位置
        this.real = 0;
    }
    
    //    判断队列是否已满
    public boolean isFull() {
        return (real + 1) % maxSize == front;
    }
    
    //    判断队列是否为空
    public boolean isEmpty() {
        return real == front;
    }
    
    //    返回当前队列的有效数据个数
    public int nowSize() {
        return (real - front + maxSize) % maxSize;
    }
    
    //    添加数据到队列
    public void addQueue(int n) {
//        判断队列是否满
        if (isFull()) {
//            如果为满则抛出异常
            throw new RuntimeException("队列满，无法添加数据");
        }
        arr[real] = n;
        real++;
        real = real % maxSize;
    }
    
    //    数据出队列
    public int getQueue() {
//        判断是否为空
        if (isEmpty()) {
//            如果为空抛出异常
            throw new RuntimeException("队列为空，不能取数据");
        }
        int result = arr[front];
        front++;
        front = front % maxSize;
        return result;
    }
    
    //    显示队列目前的所有数据
    public void showNow() {
//        遍历数组
        if (isEmpty()) {
            System.out.println("队列是空的，没有数据");
            return;
        }

//        被注释的代码为不精简的循环输出

/* //        分为循环头在前和循环尾在前
        if (real > front) {
            for (int i = front; i < real; i++) {
                System.out.printf("%s ", arr[i]);
            }
//            如果队列头在队列尾的后面，则分为两个部分，分别为队列头到数组尾，和数组头到队列尾
        } else {
            for (int i = front; i < arr.length; i++) {
                System.out.printf("%s ", arr[i]);
            }
            for (int i = 0; i < real; i++) {
                System.out.printf("%s ", arr[i]);
            }
        } */

//        以下为改良的循环输出
        
        for (int i = front; i < front + nowSize(); i++) {
            System.out.printf("%d ", arr[i % maxSize]);
        }
        System.out.println();
    }
    
    //    显示队列所有的数据
    public void showAll() {
//        遍历数组
        if (isEmpty()) {
            System.out.println("队列是空的，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s ", arr[i]);
        }
        System.out.println();
    }
}
