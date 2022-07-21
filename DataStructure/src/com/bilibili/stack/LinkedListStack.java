package com.bilibili.stack;

//链表模拟栈类
public class LinkedListStack {
    //    初始化头节点
    private LinkedListNode head = new LinkedListNode(0, null);
    
    
    //    判断栈空
    public boolean isEmpty() {
        return head.getNext() == null;
    }
    
    
    /**
     * 压栈函数，一共对栈压入sum个数据，默认编号从1开始.
     *
     * @param sum 表示需要压进去的数量
     */
    public void push(int sum) {
//        用头插法压入数据
        for (int i = 1; i <= sum; i++) {
//            新的节点的编号为i，且新的节点的next指向head的next
            LinkedListNode newNode = new LinkedListNode(i, head.getNext());
//            将head的next直指向新节点
            head.setNext(newNode);
        }
    }
    
    /**
     * 出栈函数，当栈不为空时返回栈顶的元素
     *
     * @return int类型的栈顶的数据
     */
    public int pop() {
//        判断是否为空
        if (isEmpty()) {
            throw new RuntimeException("栈为空，没有数据");
        }
//        保存要弹出的数据
        int result = head.getNext().getNo();
//        把弹出的节点删除
        head.setNext(head.getNext().getNext());
        return result;
    }
    
    /**
     * 将栈的内容遍历输出
     */
    public void show() {
//        判断是否为空
        if (isEmpty()) {
            System.out.println("栈空，无数据");
            return;
        }

//        循环遍历输出
//        head指针不能动，需要定义辅助指针
        LinkedListNode temp = head;
        while (temp.getNext() != null) {
            System.out.printf("%d ", temp.getNext().getNo());
//            temp后移
            temp = temp.getNext();
        }
        System.out.println();
    }
}
