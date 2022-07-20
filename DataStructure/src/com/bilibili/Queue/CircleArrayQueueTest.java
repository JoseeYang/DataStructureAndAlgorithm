package com.bilibili.Queue;

import java.util.Scanner;

public class CircleArrayQueueTest {
    public static void main(String[] args) {
        //        ����һ�����ж���,����Ϊ5
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(5);

//        ���˵�
        mainMenu(circleArrayQueue);
    }
    
    private static void mainMenu(CircleArrayQueue circleArrayQueue) {
        System.out.println("------------------------------------");
        System.out.println("��ӭ����ѭ��������ʾ����");
        System.out.println("1.�������");
        System.out.println("2.��������");
        System.out.println("3.��ʾ�������е�����");
        System.out.println("4.��ʾ����Ŀǰ��������");
        System.out.println("5.�˳�����");
        System.out.println("���������ѡ��");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("��������Ҫ��ӵ����ݣ�");
                try {
                    circleArrayQueue.addQueue(scanner.nextInt());
                    System.out.println("��ӳɹ�");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                try {
                    System.out.printf("����������Ϊ��%s\n", circleArrayQueue.getQueue());
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
