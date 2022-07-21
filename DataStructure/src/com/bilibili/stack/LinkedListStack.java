package com.bilibili.stack;

//����ģ��ջ��
public class LinkedListStack {
    //    ��ʼ��ͷ�ڵ�
    private LinkedListNode head = new LinkedListNode(0, null);
    
    
    //    �ж�ջ��
    public boolean isEmpty() {
        return head.getNext() == null;
    }
    
    
    /**
     * ѹջ������һ����ջѹ��sum�����ݣ�Ĭ�ϱ�Ŵ�1��ʼ.
     *
     * @param sum ��ʾ��Ҫѹ��ȥ������
     */
    public void push(int sum) {
//        ��ͷ�巨ѹ������
        for (int i = 1; i <= sum; i++) {
//            �µĽڵ�ı��Ϊi�����µĽڵ��nextָ��head��next
            LinkedListNode newNode = new LinkedListNode(i, head.getNext());
//            ��head��nextֱָ���½ڵ�
            head.setNext(newNode);
        }
    }
    
    /**
     * ��ջ��������ջ��Ϊ��ʱ����ջ����Ԫ��
     *
     * @return int���͵�ջ��������
     */
    public int pop() {
//        �ж��Ƿ�Ϊ��
        if (isEmpty()) {
            throw new RuntimeException("ջΪ�գ�û������");
        }
//        ����Ҫ����������
        int result = head.getNext().getNo();
//        �ѵ����Ľڵ�ɾ��
        head.setNext(head.getNext().getNext());
        return result;
    }
    
    /**
     * ��ջ�����ݱ������
     */
    public void show() {
//        �ж��Ƿ�Ϊ��
        if (isEmpty()) {
            System.out.println("ջ�գ�������");
            return;
        }

//        ѭ���������
//        headָ�벻�ܶ�����Ҫ���帨��ָ��
        LinkedListNode temp = head;
        while (temp.getNext() != null) {
            System.out.printf("%d ", temp.getNext().getNo());
//            temp����
            temp = temp.getNext();
        }
        System.out.println();
    }
}
