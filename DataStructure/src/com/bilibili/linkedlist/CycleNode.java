package com.bilibili.linkedlist;

//约瑟夫问题
//循环单链表节点类
public class CycleNode {
    //    一个编号，一个指针指向后一个节点
    private int no;
    private CycleNode next;
    
    //    构造器
    public CycleNode(int no) {
        this.no = no;
    }
    
    //    get和set方法
    public int getNo() {
        return no;
    }
    
    public void setNo(int no) {
        this.no = no;
    }
    
    public CycleNode getNext() {
        return next;
    }
    
    public void setNext(CycleNode next) {
        this.next = next;
    }
}
