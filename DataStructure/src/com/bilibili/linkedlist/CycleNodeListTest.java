package com.bilibili.linkedlist;

//单向环形列表测试类
public class CycleNodeListTest {
    public static void main(String[] args) {
//        构建长度为5的环形链表
        CycleNodeList list = new CycleNodeList();
        list.addNode(5);

//        显示环形链表
        list.show();

//        出圈链表
        list.countNode(1, 2, 5);
    }
}
