package com.bilibili.sort;

import java.util.Arrays;

//ð������Ļ�������ʵ��
public class BubbleSort {
    public static void main(String[] args) {
//        ����Ҫ���������,�����Ϊ��С�������е�����
        int[] arr = {3, 9, -1, 10, -2};

//        ���彻���õ���ʱ����
        int temp;
//        ���for����ÿ������Ҫ�Աȵ����ݷ�Χ
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
//                    ��������ͽ���
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
//            һ������������һ��
            System.out.println("��" + (i + 1) + "������Ľ��Ϊ��");
            System.out.println(Arrays.toString(arr));
        }
    }
}
