package com.bilibili.linkedlist;

//定义带有头节点的链表类
public class SingleLinkedList {
    //    先初始化一个头节点，头节点一般不能动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");
    
    //    给head添加get和sat方法
    public HeroNode getHead() {
        return head;
    }
    
    public void setHead(HeroNode head) {
        this.head = head;
    }
    
    //    添加节点到单向链表的最后
//    找到当前链表的最后一个节点，然后将这个节点的next指向新的节点
    public void add(HeroNode heroNode) {

//        因为head节点不能动，所以我们需要一个辅助变量temp找到链表的最后
        HeroNode temp = head;
//        遍历链表，找到最后
        while (temp.getNext() != null) {
//            找到最后
            //            如果没有找到，就让temp后移
            temp = temp.getNext();
        }
//        当退出while循环的时候，temp就指向了链表的最后一个节点
//        把这个节点的next指向新的节点
        temp.setNext(heroNode);
    }
    
    
    //    添加节点到指定的位置
//    根据英雄排名将英雄插入指定的位置，如果有这个排名，则添加失败，给出提示
    public void addByOrder(HeroNode heroNode) {
//        因为head节点不能动，所以我们需要一个辅助变量temp找到添加的位置
//        因为是单链表，所以要找的temp是要添加位置的前一个节点
        HeroNode temp = head;

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
//            新的节点.next = temp.next
//            temp.next = 新节点
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
        }
    }
    
    
    //    修改节点信息，根据no编号来修改
    public void update(HeroNode newHeroNode) {
        if (head.getNext() == null) {
//            判断是否为空
            System.out.println("链表为空");
            return;
        }

//        根据no编号找到需要修改的节点，用辅助变量
        HeroNode temp = head.getNext();

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
    //        因为head节点不能动，所以我们需要一个辅助变量temp找到待删除的节点的前一个节点
    public void del(int no) {
        HeroNode temp = head;

//        flag标志是否找到待删除的节点
        boolean flag = false;
        
        while (true) {
            if (temp.getNext() == null) {
                //            已经到链表最后
                break;
            }
            if (temp.getNext().getNo() == no) {
//                找到了待删除的节点，此时temp为待删除节点的前一个节点
                flag = true;
                break;
            }
//            temp后移
            temp = temp.getNext();
        }
        
        if (flag) {
//            找到了要删除的节点就可以删除
            temp.setNext(temp.getNext().getNext());
        } else {
//            没有找到要删除的节点
            System.out.println("没有找到待删除的节点");
        }
    }
    
    
    //    返回链表的节点个数
    public int getLength() {
//        index表示结点的个数
        int index = 0;
//        定义中间变量
        HeroNode temp = head;
        
        //            为空则跳出
        while (temp.getNext() != null) {
//        判断是否为空
            //            不为空就temp后移且index++
            temp = temp.getNext();
            index++;
        }
        return index;
    }
    
    
    //    获取倒数第k个节点
    public HeroNode findLastIndexNode(int index) {
//        判断链表是否为空
        if (head.getNext() == null) {
//            为空则返回null
            return null;
        }
//        如果不为空，则遍历获得链表有效节点个数
        int size = getLength();

//        判断index是否合法
        if (index > size || index <= 0) {
            return null;
        }

//        定义中间变量temp
        HeroNode temp = head.getNext();

//        再遍历(size - index)次即可得到倒数第k个节点
        for (int i = 0; i < size - index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }
    
    
    //    单链表的反转
    public SingleLinkedList reverseList(SingleLinkedList oldList) {

//        遍历列表
//        判断链表是否为空或只有一个节点
        if (oldList.head.getNext() == null || oldList.head.getNext().getNext() == null) {
            System.out.println("链表为空或只有一个节点");
        }

//        newList表示新的链表
        SingleLinkedList newList = new SingleLinkedList();
//        temp为中间变量，用来存储现在选中的节点
        HeroNode temp = oldList.head.getNext();
//        next里面存当前选中节点的下一个节点
        HeroNode next;
        
        while (temp != null) {
//            判断是否到链表最后
//            先把temp的指针存进next
            next = temp.getNext();
//            然后把head的next存入temp的next
            temp.setNext(newList.head.getNext());
//            最后把head的指针指向temp
            newList.head.setNext(temp);

//            将temp后移
            temp = next;
        }
//        把oldList的头的指针指向新链表的头节点指针
        oldList.head.setNext(newList.head.getNext());
        
        return oldList;
    }
    
    
    //    遍历链表
    public void show() {
//        判断链表是否为空
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
//        不为空则开始遍历
//        因为头节点不能动，所以我们需要一个辅助变量来遍历
        HeroNode temp = head.getNext();
        
        while (temp != null) {
//            判断是否到链表最后

//            输出节点信息
//            因为我们重写了toString方法，打印的时候会自动调用toString方法，所以可以直接打印temp
            System.out.println(temp);

//            将temp后移
            temp = temp.getNext();
        }
    }
    
}
