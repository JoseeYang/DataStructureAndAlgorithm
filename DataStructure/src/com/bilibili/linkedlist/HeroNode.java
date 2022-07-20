package com.bilibili.linkedlist;

//链表的节点类
//英雄节点类
public class HeroNode {
    //    每个英雄有编号，姓名和绰号
    private int no;
    private String name;
    private String nickName;
    //    指向下一个节点的next指针
    private HeroNode next;
    
    //    get与sat方法
    public HeroNode getNext() {
        return next;
    }
    
    public void setNext(HeroNode next) {
        this.next = next;
    }
    
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
    
    //    构造器
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
    
    //    为了方便显示，重写toString方法
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", niceName='" + nickName + '\'' +
                '}';
    }
}
