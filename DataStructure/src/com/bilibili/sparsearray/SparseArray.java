package com.bilibili.sparsearray;

public class SparseArray {
    public static void main(String[] args) {
//        ����һ��ԭʼ��ά����11*11
//        0����ʾû�����ӣ�1����ʾ���ӣ�2����ʾ����
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

//        ���ԭʼ�Ķ�ά����
        System.out.println("ԭʼ�Ķ�ά���飺");
        outputArr(chessArr1);

//        ����ά����ת��Ϊϡ������
        int[][] sparseArr = toSparseArray(chessArr1);

//        ���ϡ������
        System.out.println("�õ���ϡ������Ϊ��");
        outputArr(sparseArr);


//        ��ϡ������ָ�Ϊԭʼ��ά����
        int[][] chessArr2 = toArr(sparseArr);

//        �����ά����
        System.out.println("�õ��Ķ�ά����Ϊ��");
        outputArr(chessArr2);
    }
    
    
    //    �������ϡ������ת��Ϊ��ά����
    private static int[][] toArr(int[][] sparseArr) {
//        1.��ȡϡ������ĵ�һ�У����ݵ�һ�е����ݣ�������ά����
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

//        2.��ȡϡ��������漸�У���ֵ����ά����
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        return chessArr2;
    }
    
    //    ������Ķ�ά����ת��Ϊϡ������
    private static int[][] toSparseArray(int[][] chessArr) {
//        1.�ȱ�����ά���飬�õ���Ч���ݵĸ���
        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }

//        2.������Ӧ��ϡ������
        int[][] sparseArr = new int[sum + 1][3];
//        ��ϡ�����鸳ֵ
        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr[0].length;
        sparseArr[0][2] = sum;

//        ������ά���飬�ѷ�������ݴ���ϡ������
//        count������¼�ǵڼ�����������
        int count = 1;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                    count++;
                }
            }
        }
        return sparseArr;
    }
    
    
    //    �������������Ķ�ά����
    private static void outputArr(int[][] Arr) {
        for (int i = 0; i < Arr.length; i++) {
            for (int j = 0; j < Arr[i].length; j++) {
                System.out.printf("%d\t", Arr[i][j]);
            }
            System.out.println();
        }
    }
}
