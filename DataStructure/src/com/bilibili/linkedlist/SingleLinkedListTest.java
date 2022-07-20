package com.bilibili.linkedlist;

//���Դ���ͷ�ڵ�������
public class SingleLinkedListTest {
    public static void main(String[] args) {

//        �����ڵ�
        HeroNode heroNode1 = new HeroNode(1, "�ν�", "��ʱ��");
        HeroNode heroNode2 = new HeroNode(2, "¬����", "������");
        HeroNode heroNode3 = new HeroNode(3, "����", "�Ƕ���");
        HeroNode heroNode4 = new HeroNode(4, "�ֳ�", "����ͷ");

//        �����б�
        SingleLinkedList singleLinkedList = new SingleLinkedList();

//        ����ڵ�
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);

////        ��˳�����ڵ�
//        singleLinkedList.addByOrder(heroNode1);
//        singleLinkedList.addByOrder(heroNode2);
//        singleLinkedList.addByOrder(heroNode3);
//        singleLinkedList.addByOrder(heroNode4);
//        singleLinkedList.addByOrder(heroNode4);

////        �޸Ľڵ�
//        HeroNode heroNode5 = new HeroNode(1, "����", "������");
//        HeroNode heroNode6 = new HeroNode(10, "�ƺ�", "������");
//        singleLinkedList.update(heroNode5);
//        singleLinkedList.update(heroNode6);
//
////        ɾ���ڵ�
//        singleLinkedList.del(1);
//        singleLinkedList.del(10);
//
////        ��ȡ������ǰ�ڵ���
//        System.out.println(singleLinkedList.getLength());
//
////        ��ȡ������1���ڵ�
//        System.out.println(singleLinkedList.findLastIndexNode(3).toString());
//        System.out.println();


//        ��ת������
//        singleLinkedList.reverseList(singleLinkedList).show();


//        �ϲ�����������
//        HeroNode heroNode5 = new HeroNode(5, "����", "�����ʦ");
//        HeroNode heroNode6 = new HeroNode(6, "����", "����");
//        HeroNode heroNode7 = new HeroNode(7, "κ����", "���");
//        HeroNode heroNode8 = new HeroNode(8, "����", "������");
//        HeroNode heroNode9 = new HeroNode(9, "����", "�����ʥ");
//        HeroNode heroNode10 = new HeroNode(10, "�", "�׻���");
//        HeroNode heroNode11 = new HeroNode(11, "�ֺ�", "⟽���");
//        HeroNode heroNode12 = new HeroNode(12, "�´�", "С����");
//
//        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
//        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
//        singleLinkedList1.add(heroNode5);
//        singleLinkedList1.add(heroNode7);
//        singleLinkedList1.add(heroNode9);
//        singleLinkedList1.add(heroNode11);
//
//        singleLinkedList2.add(heroNode6);
//        singleLinkedList2.add(heroNode8);
//        singleLinkedList2.add(heroNode10);
//        singleLinkedList2.add(heroNode12);
//
//        System.out.println("�ϲ�ǰ�������б�");
//        singleLinkedList1.show();
//        System.out.println();
//        singleLinkedList2.show();
//
//        System.out.println("�ϲ�����б�");
//        SingleLinkedList mergeList = mergeList(singleLinkedList1, singleLinkedList2);
//        mergeList.show();

////        ��ʾ������
//        singleLinkedList.show();
        
    }
    
    
    //    �ϲ���������
    public static SingleLinkedList mergeList(SingleLinkedList list1, SingleLinkedList list2) {
        
        SingleLinkedList newList = new SingleLinkedList();

//        next��tempָ�����һ������
        HeroNode next;
//        �м����temp
        HeroNode temp = list1.getHead().getNext();
        while (temp != null) {
//            �ж��Ƿ��������
//            ��temp����һ��ָ��������next
            next = temp.getNext();

//            �����temp��next����Ϊ�գ�����һ�ξͰ����е�����ȫ���ƽ�����
            temp.setNext(null);
//            ���temp��������
            newList.addByOrder(temp);

//            ��temp����
            temp = next;
        }
        
        temp = list2.getHead().getNext();
        while (temp != null) {
//            �ж��Ƿ��������
            next = temp.getNext();
            temp.setNext(null);
            newList.addByOrder(temp);

//            ��temp����
            temp = next;
        }
        return newList;
    }
}
