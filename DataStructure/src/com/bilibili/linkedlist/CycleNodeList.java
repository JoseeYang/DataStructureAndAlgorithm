package com.bilibili.linkedlist;

//���ε���������
public class CycleNodeList {
    
    //    ����һ��first�ڵ㣬��ǰû�б��
    private CycleNode first = null;
    
    //    ��ӽڵ㺯������Ҫ����һ����������
    public void addNode(int nums) {
//        �������nums����У��
        if (nums < 1) {
            System.out.println("nums��ֵ����ȷ");
            return;
        }

//        ����ָ�룬ʼ��ָ���Ѿ������õ�����β
        CycleNode end = null;
//        ʹ��forѭ����������
        for (int i = 1; i <= nums; i++) {
//            ���ݱ�Ŵ����ڵ�
            CycleNode newNode = new CycleNode(i);

//            ����ǵ�һ���ڵ�,����firstָ������ڵ㣬���������ɻ�
            if (i == 1) {
                first = newNode;
                first.setNext(first);
                end = first;
            } else {
//                ���ǵ�һ���ڵ��������βָ���½ڵ㣬ͬʱ���½ڵ�ָ��first���ٴι��ɻ�
                end.setNext(newNode);
                newNode.setNext(first);
//                endָ�����
                end = newNode;
            }
        }
    }
    
    
    //    ��ʾ��������
    public void show() {
//        �ж������Ƿ�Ϊ��
        if (first == null) {
            System.out.println("����Ϊ��");
            return;
        }
//        ��Ҫ�õ�һ������ָ�븨������������ָ��ָ��first
        CycleNode temp = first;

//        ��ע�⣺����ط���ѭ���ж�������䲻�ܷ���true�ĵط����������ִ��һ��������
        while (true) {
            System.out.printf("���Ϊ%d�Ľڵ�\n", temp.getNo());
            if (temp.getNext() == first) {
//                ˵��ѭ�����
                break;
            }
//            temp����
            temp = temp.getNext();
        }
    }
    
    
    /**
     * @param startNo  ��ʾ�ӵڼ������ڵ㿪ʼ��
     * @param countNum ��ʾ������
     * @param nums     ��ʾ����ж��ٸ��ڵ�
     */
    public void countNode(int startNo, int countNum, int nums) {
//        �ȶ����ݽ���У��
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("����������������������");
            return;
        }
//        ��������ָ��temp
        CycleNode temp = first;
//        ��temp���ָ��ָ����е����һ���ڵ�,ͬʱҲ��first��ǰһ���ڵ�
        while (temp.getNext() != first) {
            temp = temp.getNext();
        }
//        ��first��tempͬʱ�ƶ�(startNo-1)�Σ�������ʼλ��
        for (int i = 0; i < (startNo - 1); i++) {
            temp = temp.getNext();
            first = first.getNext();
        }

//        ��ʼѭ����Ȧ��ֱ��Ȧ�н�ʣһ���ڵ�ֹͣ
        while (temp != first) {
//            ��first��tempͬʱ�ƶ�(countNum-1)�Σ���firstָ��ָ��Ҫ��Ȧ�Ľڵ㣬tempָ��Ҫ��Ȧ�Ľڵ��ǰһ���ڵ�
            for (int i = 0; i < (countNum - 1); i++) {
                temp = temp.getNext();
                first = first.getNext();
            }
            System.out.printf("�ڵ�%d��Ȧ\n", first.getNo());
//            ��firstǰ��һλ��Ȼ����temp��nextָ��first
            first = first.getNext();
            temp.setNext(first);
        }

//        ��ʱȦ�н�ʣһ���ڵ�
        System.out.printf("�ڵ�%d��Ȧ\n", first.getNo());
    }
}
