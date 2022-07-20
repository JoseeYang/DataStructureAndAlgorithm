package com.bilibili.linkedlist;

//�������ͷ�ڵ��������
public class SingleLinkedList {
    //    �ȳ�ʼ��һ��ͷ�ڵ㣬ͷ�ڵ�һ�㲻�ܶ�������ž��������
    private HeroNode head = new HeroNode(0, "", "");
    
    //    ��head���get��sat����
    public HeroNode getHead() {
        return head;
    }
    
    public void setHead(HeroNode head) {
        this.head = head;
    }
    
    //    ��ӽڵ㵽������������
//    �ҵ���ǰ��������һ���ڵ㣬Ȼ������ڵ��nextָ���µĽڵ�
    public void add(HeroNode heroNode) {

//        ��Ϊhead�ڵ㲻�ܶ�������������Ҫһ����������temp�ҵ���������
        HeroNode temp = head;
//        ���������ҵ����
        while (temp.getNext() != null) {
//            �ҵ����
            //            ���û���ҵ�������temp����
            temp = temp.getNext();
        }
//        ���˳�whileѭ����ʱ��temp��ָ������������һ���ڵ�
//        ������ڵ��nextָ���µĽڵ�
        temp.setNext(heroNode);
    }
    
    
    //    ��ӽڵ㵽ָ����λ��
//    ����Ӣ��������Ӣ�۲���ָ����λ�ã��������������������ʧ�ܣ�������ʾ
    public void addByOrder(HeroNode heroNode) {
//        ��Ϊhead�ڵ㲻�ܶ�������������Ҫһ����������temp�ҵ���ӵ�λ��
//        ��Ϊ�ǵ���������Ҫ�ҵ�temp��Ҫ���λ�õ�ǰһ���ڵ�
        HeroNode temp = head;

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
//            �µĽڵ�.next = temp.next
//            temp.next = �½ڵ�
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
        }
    }
    
    
    //    �޸Ľڵ���Ϣ������no������޸�
    public void update(HeroNode newHeroNode) {
        if (head.getNext() == null) {
//            �ж��Ƿ�Ϊ��
            System.out.println("����Ϊ��");
            return;
        }

//        ����no����ҵ���Ҫ�޸ĵĽڵ㣬�ø�������
        HeroNode temp = head.getNext();

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
    //        ��Ϊhead�ڵ㲻�ܶ�������������Ҫһ����������temp�ҵ���ɾ���Ľڵ��ǰһ���ڵ�
    public void del(int no) {
        HeroNode temp = head;

//        flag��־�Ƿ��ҵ���ɾ���Ľڵ�
        boolean flag = false;
        
        while (true) {
            if (temp.getNext() == null) {
                //            �Ѿ����������
                break;
            }
            if (temp.getNext().getNo() == no) {
//                �ҵ��˴�ɾ���Ľڵ㣬��ʱtempΪ��ɾ���ڵ��ǰһ���ڵ�
                flag = true;
                break;
            }
//            temp����
            temp = temp.getNext();
        }
        
        if (flag) {
//            �ҵ���Ҫɾ���Ľڵ�Ϳ���ɾ��
            temp.setNext(temp.getNext().getNext());
        } else {
//            û���ҵ�Ҫɾ���Ľڵ�
            System.out.println("û���ҵ���ɾ���Ľڵ�");
        }
    }
    
    
    //    ��������Ľڵ����
    public int getLength() {
//        index��ʾ���ĸ���
        int index = 0;
//        �����м����
        HeroNode temp = head;
        
        //            Ϊ��������
        while (temp.getNext() != null) {
//        �ж��Ƿ�Ϊ��
            //            ��Ϊ�վ�temp������index++
            temp = temp.getNext();
            index++;
        }
        return index;
    }
    
    
    //    ��ȡ������k���ڵ�
    public HeroNode findLastIndexNode(int index) {
//        �ж������Ƿ�Ϊ��
        if (head.getNext() == null) {
//            Ϊ���򷵻�null
            return null;
        }
//        �����Ϊ�գ���������������Ч�ڵ����
        int size = getLength();

//        �ж�index�Ƿ�Ϸ�
        if (index > size || index <= 0) {
            return null;
        }

//        �����м����temp
        HeroNode temp = head.getNext();

//        �ٱ���(size - index)�μ��ɵõ�������k���ڵ�
        for (int i = 0; i < size - index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }
    
    
    //    ������ķ�ת
    public SingleLinkedList reverseList(SingleLinkedList oldList) {

//        �����б�
//        �ж������Ƿ�Ϊ�ջ�ֻ��һ���ڵ�
        if (oldList.head.getNext() == null || oldList.head.getNext().getNext() == null) {
            System.out.println("����Ϊ�ջ�ֻ��һ���ڵ�");
        }

//        newList��ʾ�µ�����
        SingleLinkedList newList = new SingleLinkedList();
//        tempΪ�м�����������洢����ѡ�еĽڵ�
        HeroNode temp = oldList.head.getNext();
//        next����浱ǰѡ�нڵ����һ���ڵ�
        HeroNode next;
        
        while (temp != null) {
//            �ж��Ƿ��������
//            �Ȱ�temp��ָ����next
            next = temp.getNext();
//            Ȼ���head��next����temp��next
            temp.setNext(newList.head.getNext());
//            ����head��ָ��ָ��temp
            newList.head.setNext(temp);

//            ��temp����
            temp = next;
        }
//        ��oldList��ͷ��ָ��ָ���������ͷ�ڵ�ָ��
        oldList.head.setNext(newList.head.getNext());
        
        return oldList;
    }
    
    
    //    ��������
    public void show() {
//        �ж������Ƿ�Ϊ��
        if (head.getNext() == null) {
            System.out.println("����Ϊ��");
            return;
        }
//        ��Ϊ����ʼ����
//        ��Ϊͷ�ڵ㲻�ܶ�������������Ҫһ����������������
        HeroNode temp = head.getNext();
        
        while (temp != null) {
//            �ж��Ƿ��������

//            ����ڵ���Ϣ
//            ��Ϊ������д��toString��������ӡ��ʱ����Զ�����toString���������Կ���ֱ�Ӵ�ӡtemp
            System.out.println(temp);

//            ��temp����
            temp = temp.getNext();
        }
    }
    
}
