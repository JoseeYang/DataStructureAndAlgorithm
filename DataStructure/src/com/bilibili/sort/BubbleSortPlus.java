package com.bilibili.sort;

import java.util.Arrays;
//冒泡排序的优化代码实现
public class BubbleSortPlus {
    public static void main(String[] args) {
//        定义要排序的数组,将其变为从小到大排列的数组
        int[] arr = {-2, -1, 0, 10, 6};
        
//        定义交换用的临时变量和标志flag
        int temp;
        boolean flag;
        
//        外层for控制每趟排序要对比的数据范围
        for (int i = 0; i < arr.length - 1; i++) {
//            重置flag
            flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
//                    发现逆序就交换
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
//                如果一趟中没有操作交换，则说明已经排序完成，就提前跳出循环
                break;
            }
//            一趟排序结束输出一次
            System.out.println("第" + (i + 1) + "趟排序的结果为：");
            System.out.println(Arrays.toString(arr));
        }
    }
}
