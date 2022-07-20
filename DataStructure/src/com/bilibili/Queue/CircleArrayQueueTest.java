package com.bilibili.Queue;

import java.util.Scanner;

public class CircleArrayQueueTest {
    public static void main(String[] args) {
        //        创建一个队列对象,长度为5
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(5);

//        主菜单
        mainMenu(circleArrayQueue);
    }
    
    private static void mainMenu(CircleArrayQueue circleArrayQueue) {
        System.out.println("------------------------------------");
        System.out.println("欢迎来到循环队列演示程序");
        System.out.println("1.添加数据");
        System.out.println("2.弹出数据");
        System.out.println("3.显示队列所有的数据");
        System.out.println("4.显示队列目前所有数据");
        System.out.println("5.退出程序");
        System.out.println("请输入你的选择：");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("请输入你要添加的数据：");
                try {
                    circleArrayQueue.addQueue(scanner.nextInt());
                    System.out.println("添加成功");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                try {
                    System.out.printf("弹出的数据为：%s\n", circleArrayQueue.getQueue());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                circleArrayQueue.showAll();
                break;
            case 4:
                circleArrayQueue.showNow();
                break;
            case 5:
                System.exit(0);
        }
        mainMenu(circleArrayQueue);
    }
}
