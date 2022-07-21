package com.bilibili.linkedlist;

//定义带有头节点的双向链表类
public class DoubleLinkedList {
    //    初始化一个节点头
    private DoubleHeroNode head = new DoubleHeroNode(0, "", "");

//    提供get和set方法
    
    public DoubleHeroNode getHead() {
        return head;
    }
    
    public void setHead(DoubleHeroNode head) {
        this.head = head;
    }
    
    
    //    遍历双链表的方法
//    遍历链表
    public void show() {
//        判断链表是否为空
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
//        不为空则开始遍历
//        因为头节点不能动，所以我们需要一个辅助变量来遍历
        DoubleHeroNode temp = head.getNext();
        
        while (temp != null) {
//            判断是否到链表最后

//            输出节点信息
//            因为我们重写了toString方法，打印的时候会自动调用toString方法，所以可以直接打印temp
            System.out.println(temp);

//            将temp后移
            temp = temp.getNext();
        }
    }
    
    
    //    添加节点到双向链表的最后
//    找到当前链表的最后一个节点，然后将这个节点的next指向新的节点，并将新节点的pre指向当前节点
    public void add(DoubleHeroNode heroNode) {

//        因为head节点不能动，所以我们需要一个辅助变量temp找到链表的最后
        DoubleHeroNode temp = head;
//        遍历链表，找到最后
        while (temp.getNext() != null) {
//            找到最后
//            如果没有找到，就让temp后移
            temp = temp.getNext();
        }
//        当退出while循环的时候，temp就指向了链表的最后一个节点
//        构成双向链表
        temp.setNext(heroNode);
        heroNode.setPre(temp);
    }
    
    
    //    添加节点到指定的位置
//    根据英雄排名将英雄插入指定的位置，如果有这个排名，则添加失败，给出提示
    public void addByOrder(DoubleHeroNode heroNode) {
//        因为head节点不能动，所以我们需要一个辅助变量temp找到添加的位置
//        因为是单链表，所以要找的temp是要添加位置的前一个节点
        DoubleHeroNode temp = head;

//        flag标志添加的编号是否存在，默认为false
        boolean flag = false;
        
        while (true) {
//        此时说明temp已经到达了链表的最后
            if (temp.getNext() == null) {
                break;
            }
//        temp所指向的下一个的no如果大于传入的no，则说明temp已经找到
            if (temp.getNext().getNo() > heroNode.getNo()) {
                break;
                //            此时说明想要添加的编号已经存在
            } else if (temp.getNext().getNo() == heroNode.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }

//        判断flag的值
        if (flag) {
//            不能添加，编号已经存在
            System.out.println("准备插入的英雄编号已经存在，不能继续加入");
        } else {
//            插入到链表中，temp之后
            
            heroNode.setNext(temp.getNext());
            heroNode.setPre(temp);
            temp.setNext(heroNode);
//            此处代码在最后加入的时候不执行，否则出现空指针异常
            if (heroNode.getNext() != null) {
                heroNode.getNext().setPre(heroNode);
            }
        }
    }
    
    
    //    修改节点信息，根据no编号来修改
    public void update(DoubleHeroNode newHeroNode) {
        if (head.getNext() == null) {
//            判断是否为空
            System.out.println("链表为空");
            return;
        }

//        根据no编号找到需要修改的节点，用辅助变量
        DoubleHeroNode temp = head.getNext();

//        flag代表是否找到了该节点，默认没找到
        boolean flag = false;
        
        while (true) {
            if (temp == null) {
//                已经遍历完列表
                break;
            }
            if (temp.getNo() == newHeroNode.getNo()) {
//                找到了要修改的节点
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
//        根据flag的值判断是否找到要修改的节点
        if (flag) {
//            如果找到了的话就修改
            temp.setName(newHeroNode.getName());
            temp.setNickName(newHeroNode.getNickName());
        } else {
//            没找到就输出没有找到
            System.out.println("没有找到，请重新输入");
        }
        
    }
    
    
    //    删除节点
//    对双向链表，可以直接找到要删除的这个节点，找到后自我删除即可
    public void del(int no) {
//        辅助指针
        DoubleHeroNode temp = head.getNext();

//        flag标志是否找到待删除的节点
        boolean flag = false;
        
        while (true) {
            if (temp == null) {
                //            已经到链表最后
                break;
            }
            if (temp.getNo() == no) {
//                找到了待删除的节点，此时temp为待删除节点的前一个节点
                flag = true;
                break;
            }
//            temp后移
            temp = temp.getNext();
        }
        
        if (flag) {
//            找到了要删除的节点就可以删除
            temp.getPre().setNext(temp.getNext());
//            这里有风险，如果是最后一个节点，就不需要执行下面这句话,否则会出现空指针
            if (temp.getNext() != null) {
                temp.getNext().setPre(temp.getPre());
            }
        } else {
//            没有找到要删除的节点
            System.out.println("没有找到待删除的节点");
        }
    }
}
