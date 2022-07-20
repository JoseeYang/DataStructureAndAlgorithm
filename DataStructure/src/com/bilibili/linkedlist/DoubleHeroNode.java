package com.bilibili.linkedlist;

//双链表的节点类
//英雄节点类
public class DoubleHeroNode {
    //    每个英雄有编号，姓名和绰号
    private int no;
    private String name;
    private String nickName;
    //    指向下一个节点的next指针，指向上一个节点的pre指针
    private DoubleHeroNode next;
    private DoubleHeroNode pre;
    
//    构造器
    public DoubleHeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
    
//    get与set方法
    
    public int getNo() {
        return no;
    }
    
    public void setNo(int no) {
        this.no = no;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getNickName() {
        return nickName;
    }
    
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public DoubleHeroNode getNext() {
        return next;
    }
    
    public void setNext(DoubleHeroNode next) {
        this.next = next;
    }
    
    public DoubleHeroNode getPre() {
        return pre;
    }
    
    public void setPre(DoubleHeroNode pre) {
        this.pre = pre;
    }
    
    //    为了方便显示，重写toString方法
    @Override
    public String toString() {
        return "DoubleHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
