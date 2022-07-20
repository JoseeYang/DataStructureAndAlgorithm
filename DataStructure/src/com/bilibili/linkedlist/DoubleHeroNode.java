package com.bilibili.linkedlist;

//˫����Ľڵ���
//Ӣ�۽ڵ���
public class DoubleHeroNode {
    //    ÿ��Ӣ���б�ţ������ʹº�
    private int no;
    private String name;
    private String nickName;
    //    ָ����һ���ڵ��nextָ�룬ָ����һ���ڵ��preָ��
    private DoubleHeroNode next;
    private DoubleHeroNode pre;
    
//    ������
    public DoubleHeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
    
//    get��set����
    
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
    
    //    Ϊ�˷�����ʾ����дtoString����
    @Override
    public String toString() {
        return "DoubleHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
