package com.bilibili.sort;

import java.util.Arrays;
//ð��������Ż�����ʵ��
public class BubbleSortPlus {
    public static void main(String[] args) {
//        ����Ҫ���������,�����Ϊ��С�������е�����
        int[] arr = {-2, -1, 0, 10, 6};
        
//        ���彻���õ���ʱ�����ͱ�־flag
        int temp;
        boolean flag;
        
//        ���for����ÿ������Ҫ�Աȵ����ݷ�Χ
        for (int i = 0; i < arr.length - 1; i++) {
//            ����flag
            flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
//                    ��������ͽ���
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
//                ���һ����û�в�����������˵���Ѿ�������ɣ�����ǰ����ѭ��
                break;
            }
//            һ������������һ��
            System.out.println("��" + (i + 1) + "������Ľ��Ϊ��");
            System.out.println(Arrays.toString(arr));
        }
    }
}
