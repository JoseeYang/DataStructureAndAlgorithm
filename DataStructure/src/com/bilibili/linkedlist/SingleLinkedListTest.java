package com.bilibili.linkedlist;

//测试带有头节点链表类
public class SingleLinkedListTest {
    public static void main(String[] args) {

//        创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

//        创建列表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

//        加入节点
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);

////        按顺序加入节点
//        singleLinkedList.addByOrder(heroNode1);
//        singleLinkedList.addByOrder(heroNode2);
//        singleLinkedList.addByOrder(heroNode3);
//        singleLinkedList.addByOrder(heroNode4);
//        singleLinkedList.addByOrder(heroNode4);

////        修改节点
//        HeroNode heroNode5 = new HeroNode(1, "长江", "老下雨");
//        HeroNode heroNode6 = new HeroNode(10, "黄河", "不下雨");
//        singleLinkedList.update(heroNode5);
//        singleLinkedList.update(heroNode6);
//
////        删除节点
//        singleLinkedList.del(1);
//        singleLinkedList.del(10);
//
////        获取单链表当前节点数
//        System.out.println(singleLinkedList.getLength());
//
////        获取倒数第1个节点
//        System.out.println(singleLinkedList.findLastIndexNode(3).toString());
//        System.out.println();


//        反转单链表
//        singleLinkedList.reverseList(singleLinkedList).show();


//        合并两个单链表
//        HeroNode heroNode5 = new HeroNode(5, "朱武", "神机军师");
//        HeroNode heroNode6 = new HeroNode(6, "宣赞", "丑郡马");
//        HeroNode heroNode7 = new HeroNode(7, "魏定国", "神火将");
//        HeroNode heroNode8 = new HeroNode(8, "凌振", "轰天雷");
//        HeroNode heroNode9 = new HeroNode(9, "李衮", "飞天大圣");
//        HeroNode heroNode10 = new HeroNode(10, "杨春", "白花蛇");
//        HeroNode heroNode11 = new HeroNode(11, "乐和", "鉄叫子");
//        HeroNode heroNode12 = new HeroNode(12, "穆春", "小遮拦");
//
//        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
//        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
//        singleLinkedList1.add(heroNode5);
//        singleLinkedList1.add(heroNode7);
//        singleLinkedList1.add(heroNode9);
//        singleLinkedList1.add(heroNode11);
//
//        singleLinkedList2.add(heroNode6);
//        singleLinkedList2.add(heroNode8);
//        singleLinkedList2.add(heroNode10);
//        singleLinkedList2.add(heroNode12);
//
//        System.out.println("合并前的两个列表：");
//        singleLinkedList1.show();
//        System.out.println();
//        singleLinkedList2.show();
//
//        System.out.println("合并后的列表：");
//        SingleLinkedList mergeList = mergeList(singleLinkedList1, singleLinkedList2);
//        mergeList.show();

////        显示单链表
//        singleLinkedList.show();
        
    }
    
    
    //    合并两个链表
    public static SingleLinkedList mergeList(SingleLinkedList list1, SingleLinkedList list2) {
        
        SingleLinkedList newList = new SingleLinkedList();

//        next存temp指向的下一个对象
        HeroNode next;
//        中间变量temp
        HeroNode temp = list1.getHead().getNext();
        while (temp != null) {
//            判断是否到链表最后
//            将temp的下一个指向对象存入next
            next = temp.getNext();

//            必须把temp的next设置为空，否则一次就把所有的链表全复制进来了
            temp.setNext(null);
//            添加temp到新链表
            newList.addByOrder(temp);

//            将temp后移
            temp = next;
        }
        
        temp = list2.getHead().getNext();
        while (temp != null) {
//            判断是否到链表最后
            next = temp.getNext();
            temp.setNext(null);
            newList.addByOrder(temp);

//            将temp后移
            temp = next;
        }
        return newList;
    }
}
