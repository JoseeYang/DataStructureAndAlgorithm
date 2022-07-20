package com.bilibili.linkedlist;

//����Ľڵ���
//Ӣ�۽ڵ���
public class SingleHeroNode {
    //    ÿ��Ӣ���б�ţ������ʹº�
    private int no;
    private String name;
    private String nickName;
    //    ָ����һ���ڵ��nextָ��
    private SingleHeroNode next;
    
    //    get��set����
    public SingleHeroNode getNext() {
        return next;
    }
    
    public void setNext(SingleHeroNode next) {
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
    
    //    ������
    public SingleHeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
    
    //    Ϊ�˷�����ʾ����дtoString����
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", niceName='" + nickName + '\'' +
                '}';
    }
}
