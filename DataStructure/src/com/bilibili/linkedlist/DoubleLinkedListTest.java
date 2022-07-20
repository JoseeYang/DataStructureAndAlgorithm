package com.bilibili.linkedlist;

//双链表的测试类
public class DoubleLinkedListTest {
    public static void main(String[] args) {
//        创建节点
        DoubleHeroNode heroNode1 = new DoubleHeroNode(1, "宋江", "及时雨");
        DoubleHeroNode heroNode2 = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
        DoubleHeroNode heroNode3 = new DoubleHeroNode(3, "吴用", "智多星");
        DoubleHeroNode heroNode4 = new DoubleHeroNode(4, "林冲", "豹子头");

//        创建列表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

////        加入节点
//        doubleLinkedList.add(heroNode1);
//        doubleLinkedList.add(heroNode2);
//        doubleLinkedList.add(heroNode3);
//        doubleLinkedList.add(heroNode4);


//        按顺序加入节点
        doubleLinkedList.addByOrder(heroNode1);
        doubleLinkedList.addByOrder(heroNode4);
        doubleLinkedList.addByOrder(heroNode2);
        doubleLinkedList.addByOrder(heroNode3);
        doubleLinkedList.addByOrder(heroNode4);


////        修改节点
//        DoubleHeroNode heroNode5 = new DoubleHeroNode(1, "长江", "老下雨");
//        DoubleHeroNode heroNode6 = new DoubleHeroNode(10, "黄河", "不下雨");
//        doubleLinkedList.update(heroNode5);
//        doubleLinkedList.update(heroNode6);
//
////        删除节点
//        doubleLinkedList.del(1);
//        doubleLinkedList.del(10);
//

//        显示双链表
        doubleLinkedList.show();
    }
}
