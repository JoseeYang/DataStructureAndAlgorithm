package com.bilibili.sparsearray;

public class SparseArray {
    public static void main(String[] args) {
//        创建一个原始二维数组11*11
//        0：表示没有棋子；1：表示黑子；2：表示白子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

//        输出原始的二维数组
        System.out.println("原始的二维数组：");
        outputArr(chessArr1);

//        将二维数组转化为稀疏数组
        int[][] sparseArr = toSparseArray(chessArr1);

//        输出稀疏数组
        System.out.println("得到的稀疏数组为：");
        outputArr(sparseArr);


//        将稀疏数组恢复为原始二维数组
        int[][] chessArr2 = toArr(sparseArr);

//        输出二维数组
        System.out.println("得到的二维数组为：");
        outputArr(chessArr2);
    }
    
    
    //    将传入的稀疏数组转化为二维数组
    private static int[][] toArr(int[][] sparseArr) {
//        1.读取稀疏数组的第一行，根据第一行的数据，创建二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

//        2.读取稀疏数组后面几行，赋值给二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        return chessArr2;
    }
    
    //    把输入的二维数组转换为稀疏数组
    private static int[][] toSparseArray(int[][] chessArr) {
//        1.先遍历二维数组，得到有效数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }

//        2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
//        给稀疏数组赋值
        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr[0].length;
        sparseArr[0][2] = sum;

//        遍历二维数组，把非零的数据存入稀疏数组
//        count用来记录是第几个非零数据
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
    
    
    //    遍历输出所传入的二维数组
    private static void outputArr(int[][] Arr) {
        for (int i = 0; i < Arr.length; i++) {
            for (int j = 0; j < Arr[i].length; j++) {
                System.out.printf("%d\t", Arr[i][j]);
            }
            System.out.println();
        }
    }
}
