package com.bilibili.linkedlist;

//Լɪ������
//ѭ��������ڵ���
public class CycleNode {
    //    һ����ţ�һ��ָ��ָ���һ���ڵ�
    private int no;
    private CycleNode next;
    
    //    ������
    public CycleNode(int no) {
        this.no = no;
    }
    
    //    get��set����
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
