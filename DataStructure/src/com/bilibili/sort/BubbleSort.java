package com.bilibili.sort;

import java.util.Arrays;

//冒泡排序的基础代码实现
public class BubbleSort {
    public static void main(String[] args) {
//        定义要排序的数组,将其变为从小到大排列的数组
        int[] arr = {3, 9, -1, 10, -2};

//        定义交换用的临时变量
        int temp;
//        外层for控制每趟排序要对比的数据范围
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
//                    发现逆序就交换
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
//            一趟排序结束输出一次
            System.out.println("第" + (i + 1) + "趟排序的结果为：");
            System.out.println(Arrays.toString(arr));
        }
    }
}
