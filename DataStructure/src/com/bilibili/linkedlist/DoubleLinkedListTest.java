package com.bilibili.linkedlist;

//˫����Ĳ�����
public class DoubleLinkedListTest {
    public static void main(String[] args) {
//        �����ڵ�
        DoubleHeroNode heroNode1 = new DoubleHeroNode(1, "�ν�", "��ʱ��");
        DoubleHeroNode heroNode2 = new DoubleHeroNode(2, "¬����", "������");
        DoubleHeroNode heroNode3 = new DoubleHeroNode(3, "����", "�Ƕ���");
        DoubleHeroNode heroNode4 = new DoubleHeroNode(4, "�ֳ�", "����ͷ");

//        �����б�
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

////        ����ڵ�
//        doubleLinkedList.add(heroNode1);
//        doubleLinkedList.add(heroNode2);
//        doubleLinkedList.add(heroNode3);
//        doubleLinkedList.add(heroNode4);


//        ��˳�����ڵ�
        doubleLinkedList.addByOrder(heroNode1);
        doubleLinkedList.addByOrder(heroNode4);
        doubleLinkedList.addByOrder(heroNode2);
        doubleLinkedList.addByOrder(heroNode3);
        doubleLinkedList.addByOrder(heroNode4);


////        �޸Ľڵ�
//        DoubleHeroNode heroNode5 = new DoubleHeroNode(1, "����", "������");
//        DoubleHeroNode heroNode6 = new DoubleHeroNode(10, "�ƺ�", "������");
//        doubleLinkedList.update(heroNode5);
//        doubleLinkedList.update(heroNode6);
//
////        ɾ���ڵ�
//        doubleLinkedList.del(1);
//        doubleLinkedList.del(10);
//

//        ��ʾ˫����
        doubleLinkedList.show();
    }
}
