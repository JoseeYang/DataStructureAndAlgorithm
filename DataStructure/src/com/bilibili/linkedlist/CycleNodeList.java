package com.bilibili.linkedlist;

//环形单向链表类
public class CycleNodeList {
    
    //    创建一个first节点，当前没有编号
    private CycleNode first = null;
    
    //    添加节点函数，需要构成一个环形链表
    public void addNode(int nums) {
//        对输入的nums进行校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }

//        辅助指针，始终指向已经创建好的链表尾
        CycleNode end = null;
//        使用for循环创建链表
        for (int i = 1; i <= nums; i++) {
//            根据编号创建节点
            CycleNode newNode = new CycleNode(i);

//            如果是第一个节点,则让first指向这个节点，并让自身构成环
            if (i == 1) {
                first = newNode;
                first.setNext(first);
                end = first;
            } else {
//                不是第一个节点就让链表尾指向新节点，同时让新节点指向first，再次构成环
                end.setNext(newNode);
                newNode.setNext(first);
//                end指针后移
                end = newNode;
            }
        }
    }
    
    
    //    显示环形链表
    public void show() {
//        判断链表是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
//        需要用到一个辅助指针辅助遍历，辅助指针指向first
        CycleNode temp = first;

//        请注意：这个地方的循环判断跳出语句不能放在true的地方，否则会少执行一次输出语句
        while (true) {
            System.out.printf("编号为%d的节点\n", temp.getNo());
            if (temp.getNext() == first) {
//                说明循环完成
                break;
            }
//            temp后移
            temp = temp.getNext();
        }
    }
    
    
    /**
     * @param startNo  表示从第几个个节点开始数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少个节点
     */
    public void countNode(int startNo, int countNum, int nums) {
//        先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
//        创建辅助指针temp
        CycleNode temp = first;
//        让temp这个指针指向队列的最后一个节点,同时也是first的前一个节点
        while (temp.getNext() != first) {
            temp = temp.getNext();
        }
//        让first和temp同时移动(startNo-1)次，到达起始位置
        for (int i = 0; i < (startNo - 1); i++) {
            temp = temp.getNext();
            first = first.getNext();
        }

//        开始循环出圈，直到圈中仅剩一个节点停止
        while (temp != first) {
//            让first和temp同时移动(countNum-1)次，让first指针指向要出圈的节点，temp指向要出圈的节点的前一个节点
            for (int i = 0; i < (countNum - 1); i++) {
                temp = temp.getNext();
                first = first.getNext();
            }
            System.out.printf("节点%d出圈\n", first.getNo());
//            让first前移一位，然后让temp的next指向first
            first = first.getNext();
            temp.setNext(first);
        }

//        此时圈中仅剩一个节点
        System.out.printf("节点%d出圈\n", first.getNo());
    }
}
