package com.bilibili.linkedlist;

//�������б������
public class CycleNodeListTest {
    public static void main(String[] args) {
//        ��������Ϊ5�Ļ�������
        CycleNodeList list = new CycleNodeList();
        list.addNode(5);

//        ��ʾ��������
        list.show();

//        ��Ȧ����
        list.countNode(1, 2, 5);
    }
}
