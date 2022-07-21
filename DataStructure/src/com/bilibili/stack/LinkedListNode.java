package com.bilibili.stack;

//链表模拟栈的节点类
//单向链表
public class LinkedListNode {
    //    节点的编号
    private int no;
    //    指向下一个节点的指针
    private LinkedListNode next;

//    构造器
    
    public LinkedListNode(int no, LinkedListNode next) {
        this.no = no;
        this.next = next;
    }
    
    //    get与set方法
    public int getNo() {
        return no;
    }
    
    public void setNo(int no) {
        this.no = no;
    }
    
    public LinkedListNode getNext() {
        return next;
    }
    
    public void setNext(LinkedListNode next) {
        this.next = next;
    }
}
