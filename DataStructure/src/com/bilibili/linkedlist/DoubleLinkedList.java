package com.bilibili.linkedlist;

//�������ͷ�ڵ��˫��������
public class DoubleLinkedList {
    //    ��ʼ��һ���ڵ�ͷ
    private DoubleHeroNode head = new DoubleHeroNode(0, "", "");

//    �ṩget��set����
    
    public DoubleHeroNode getHead() {
        return head;
    }
    
    public void setHead(DoubleHeroNode head) {
        this.head = head;
    }
    
    
    //    ����˫����ķ���
//    ��������
    public void show() {
//        �ж������Ƿ�Ϊ��
        if (head.getNext() == null) {
            System.out.println("����Ϊ��");
            return;
        }
//        ��Ϊ����ʼ����
//        ��Ϊͷ�ڵ㲻�ܶ�������������Ҫһ����������������
        DoubleHeroNode temp = head.getNext();
        
        while (temp != null) {
//            �ж��Ƿ��������

//            ����ڵ���Ϣ
//            ��Ϊ������д��toString��������ӡ��ʱ����Զ�����toString���������Կ���ֱ�Ӵ�ӡtemp
            System.out.println(temp);

//            ��temp����
            temp = temp.getNext();
        }
    }
    
    
    //    ��ӽڵ㵽˫����������
//    �ҵ���ǰ��������һ���ڵ㣬Ȼ������ڵ��nextָ���µĽڵ㣬�����½ڵ��preָ��ǰ�ڵ�
    public void add(DoubleHeroNode heroNode) {

//        ��Ϊhead�ڵ㲻�ܶ�������������Ҫһ����������temp�ҵ���������
        DoubleHeroNode temp = head;
//        ���������ҵ����
        while (temp.getNext() != null) {
//            �ҵ����
//            ���û���ҵ�������temp����
            temp = temp.getNext();
        }
//        ���˳�whileѭ����ʱ��temp��ָ������������һ���ڵ�
//        ����˫������
        temp.setNext(heroNode);
        heroNode.setPre(temp);
    }
    
    
    //    ��ӽڵ㵽ָ����λ��
//    ����Ӣ��������Ӣ�۲���ָ����λ�ã��������������������ʧ�ܣ�������ʾ
    public void addByOrder(DoubleHeroNode heroNode) {
//        ��Ϊhead�ڵ㲻�ܶ�������������Ҫһ����������temp�ҵ���ӵ�λ��
//        ��Ϊ�ǵ���������Ҫ�ҵ�temp��Ҫ���λ�õ�ǰһ���ڵ�
        DoubleHeroNode temp = head;

//        flag��־��ӵı���Ƿ���ڣ�Ĭ��Ϊfalse
        boolean flag = false;
        
        while (true) {
//        ��ʱ˵��temp�Ѿ���������������
            if (temp.getNext() == null) {
                break;
            }
//        temp��ָ�����һ����no������ڴ����no����˵��temp�Ѿ��ҵ�
            if (temp.getNext().getNo() > heroNode.getNo()) {
                break;
                //            ��ʱ˵����Ҫ��ӵı���Ѿ�����
            } else if (temp.getNext().getNo() == heroNode.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }

//        �ж�flag��ֵ
        if (flag) {
//            ������ӣ�����Ѿ�����
            System.out.println("׼�������Ӣ�۱���Ѿ����ڣ����ܼ�������");
        } else {
//            ���뵽�����У�temp֮��
            
            heroNode.setNext(temp.getNext());
            heroNode.setPre(temp);
            temp.setNext(heroNode);
//            �˴��������������ʱ��ִ�У�������ֿ�ָ���쳣
            if (heroNode.getNext() != null) {
                heroNode.getNext().setPre(heroNode);
            }
        }
    }
    
    
    //    �޸Ľڵ���Ϣ������no������޸�
    public void update(DoubleHeroNode newHeroNode) {
        if (head.getNext() == null) {
//            �ж��Ƿ�Ϊ��
            System.out.println("����Ϊ��");
            return;
        }

//        ����no����ҵ���Ҫ�޸ĵĽڵ㣬�ø�������
        DoubleHeroNode temp = head.getNext();

//        flag�����Ƿ��ҵ��˸ýڵ㣬Ĭ��û�ҵ�
        boolean flag = false;
        
        while (true) {
            if (temp == null) {
//                �Ѿ��������б�
                break;
            }
            if (temp.getNo() == newHeroNode.getNo()) {
//                �ҵ���Ҫ�޸ĵĽڵ�
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
//        ����flag��ֵ�ж��Ƿ��ҵ�Ҫ�޸ĵĽڵ�
        if (flag) {
//            ����ҵ��˵Ļ����޸�
            temp.setName(newHeroNode.getName());
            temp.setNickName(newHeroNode.getNickName());
        } else {
//            û�ҵ������û���ҵ�
            System.out.println("û���ҵ�������������");
        }
        
    }
    
    
    //    ɾ���ڵ�
//    ��˫����������ֱ���ҵ�Ҫɾ��������ڵ㣬�ҵ�������ɾ������
    public void del(int no) {
//        ����ָ��
        DoubleHeroNode temp = head.getNext();

//        flag��־�Ƿ��ҵ���ɾ���Ľڵ�
        boolean flag = false;
        
        while (true) {
            if (temp == null) {
                //            �Ѿ����������
                break;
            }
            if (temp.getNo() == no) {
//                �ҵ��˴�ɾ���Ľڵ㣬��ʱtempΪ��ɾ���ڵ��ǰһ���ڵ�
                flag = true;
                break;
            }
//            temp����
            temp = temp.getNext();
        }
        
        if (flag) {
//            �ҵ���Ҫɾ���Ľڵ�Ϳ���ɾ��
            temp.getPre().setNext(temp.getNext());
//            �����з��գ���������һ���ڵ㣬�Ͳ���Ҫִ��������仰,�������ֿ�ָ��
            if (temp.getNext() != null) {
                temp.getNext().setPre(temp.getPre());
            }
        } else {
//            û���ҵ�Ҫɾ���Ľڵ�
            System.out.println("û���ҵ���ɾ���Ľڵ�");
        }
    }
}
