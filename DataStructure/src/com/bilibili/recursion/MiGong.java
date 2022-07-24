package com.bilibili.recursion;

public class MiGong {
    public static void main(String[] args) {
//        先创建一个二维数组模拟迷宫
//        八行七列的地图
        int[][] map = new int[8][7];
//        使用1表示墙，先把上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
//        左右也置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
//        设置挡板
        map[3][1] = 1;
        map[3][2] = 1;

//        输出地图
        System.out.println("地图的情况：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        
//        使用递归回溯给小球找路
        setWay(map, 1, 1);
        
//        输出新的地图，小球走过并标识过的递归
//        输出地图
        System.out.println("小球走过，并标识的地图的情况：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    
    }
    
    /**
     * 使用递归回溯来给小球招录
     * 说明:
     * 1.map表示地图
     * 2.i，j表示从地图的哪里出发
     * 3.如果小球能到达map[6][5]位置，说明通路能找到
     * 4.约定：当map[i][j]为0表示该点还没走过，为1表示墙，为2表示通路可以走，为3表示该点走过了，走不通
     * 5.策略：下->右->上->左
     *
     * @param map 表示地图
     * @param i   从哪个位置开始找
     * @param j   从哪个位置开始找
     * @return 找到路返回ture，否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
//            此时说明通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {
//                当前节点还没有走过
//                按照策略走
//                先假定该点是可以走通的
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
//                    先向下走,如果能走通返回true
                    return true;
                } else if (setWay(map, i, j + 1)) {
//                    再往右走
                    return true;
                } else if (setWay(map, i - 1, j)) {
//                    向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {
//                    向左走
                    return true;
                } else {
//                    说明该点是走不通的，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {
//                如果map[i][j] !=0 ,可能是1，2，3
                return false;
            }
        }
        
    }
}
