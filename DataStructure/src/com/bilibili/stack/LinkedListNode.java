package com.bilibili.stack;

//����ģ��ջ�Ľڵ���
//��������
public class LinkedListNode {
    //    �ڵ�ı��
    private int no;
    //    ָ����һ���ڵ��ָ��
    private LinkedListNode next;

//    ������
    
    public LinkedListNode(int no, LinkedListNode next) {
        this.no = no;
        this.next = next;
    }
    
    //    get��set����
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
