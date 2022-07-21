package com.bilibili.stack;

//������ר��ջ��
//�õ�������ģ��ջ
public class CalculatorStack {
    //    ����ջ�Ĵ�С
    private int maxSize;
    //    ģ�������
    private int[] stack;
    //    ջ��ָ��
    private int top;
    
    //    ������
    public CalculatorStack(int maxSize) {
//        ��ʼ��ջ�Ĵ�С������Ͷ�ָ��
        this.maxSize = maxSize;
        stack = new int[maxSize];
        top = -1;
    }
    
    //    ջ���ж�
    public boolean isFull() {
        return top == (maxSize - 1);
    }
    
    //    ջ���ж�
    public boolean isEmpty() {
        return top == -1;
    }
    
    //    ��ջ����
    public void push(int value) {
//        ���ж�ջ�Ƿ���
        if (isFull()) {
            System.out.println("ջ��");
            return;
        }
//        ��top����һλ��Ȼ������ݴ���topָ�������
        top++;
        stack[top] = value;
    }
    
    //    ��ջ����
    public int pop() {
//        ���ж��Ƿ�Ϊ��
        if (isEmpty()) {
//            �׳��쳣
            throw new RuntimeException("ջ�գ�û������");
        }
//        ȡ��ջ��Ԫ�أ�ջ��ָ���һ������ջ��Ԫ��
        int value = stack[top];
        top--;
        return value;
    }
    
    
    //    ����ջ
    public void show() {
//        �ж��Ƿ�Ϊ��
        if (isEmpty()) {
            System.out.println("ջ�գ�û������");
            return;
        }
//        ��Ҫ��ջ����ʼ��ʾ����
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
        
    }
    
    /**
     * ͨ������������ж�����������ȼ�
     *
     * @param oper ��Ҫ�ж����ȼ��ķ���
     * @return 1�����ȼ�����0������-1˵���������������
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }
    
    /**
     * �жϴ���������ǲ��ǲ�����
     *
     * @param val ���������
     * @return true��ʾʱ������ false��ʾ���ǲ�����
     */
    public boolean isOper(int val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }
    
    /**
     * ����������������һ�������������������
     * @param num1 ��һ��������
     * @param num2 �ڶ���������
     * @param oper ������
     * @return int���ͼ�����
     */
    public int cal(int num1, int num2, int oper) {
        return switch (oper) {
            case '+' -> num1 + num2;
            case '-' -> num2 - num1;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> 0;
        };
    }
    
//    ͵��һ��ջ����Ԫ�ز�����
    public int peek(){
        return stack[top];
    }
    
}
