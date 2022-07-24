package com.bilibili.recursion;

public class MiGong {
    public static void main(String[] args) {
//        �ȴ���һ����ά����ģ���Թ�
//        �������еĵ�ͼ
        int[][] map = new int[8][7];
//        ʹ��1��ʾǽ���Ȱ�����ȫ����Ϊ1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
//        ����Ҳ��Ϊ1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
//        ���õ���
        map[3][1] = 1;
        map[3][2] = 1;

//        �����ͼ
        System.out.println("��ͼ�������");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        
//        ʹ�õݹ���ݸ�С����·
        setWay(map, 1, 1);
        
//        ����µĵ�ͼ��С���߹�����ʶ���ĵݹ�
//        �����ͼ
        System.out.println("С���߹�������ʶ�ĵ�ͼ�������");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    
    }
    
    /**
     * ʹ�õݹ��������С����¼
     * ˵��:
     * 1.map��ʾ��ͼ
     * 2.i��j��ʾ�ӵ�ͼ���������
     * 3.���С���ܵ���map[6][5]λ�ã�˵��ͨ·���ҵ�
     * 4.Լ������map[i][j]Ϊ0��ʾ�õ㻹û�߹���Ϊ1��ʾǽ��Ϊ2��ʾͨ·�����ߣ�Ϊ3��ʾ�õ��߹��ˣ��߲�ͨ
     * 5.���ԣ���->��->��->��
     *
     * @param map ��ʾ��ͼ
     * @param i   ���ĸ�λ�ÿ�ʼ��
     * @param j   ���ĸ�λ�ÿ�ʼ��
     * @return �ҵ�·����ture�����򷵻�false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
//            ��ʱ˵��ͨ·�Ѿ��ҵ�
            return true;
        } else {
            if (map[i][j] == 0) {
//                ��ǰ�ڵ㻹û���߹�
//                ���ղ�����
//                �ȼٶ��õ��ǿ�����ͨ��
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
//                    ��������,�������ͨ����true
                    return true;
                } else if (setWay(map, i, j + 1)) {
//                    ��������
                    return true;
                } else if (setWay(map, i - 1, j)) {
//                    ������
                    return true;
                } else if (setWay(map, i, j - 1)) {
//                    ������
                    return true;
                } else {
//                    ˵���õ����߲�ͨ�ģ�����·
                    map[i][j] = 3;
                    return false;
                }
            } else {
//                ���map[i][j] !=0 ,������1��2��3
                return false;
            }
        }
        
    }
}
