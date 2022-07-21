package com.bilibili.stack;

//������ʵ����
public class Calculator {
    public static void main(String[] args) {
//        ������ʽ
        String expression = "30+20*6-20";

//        ��������ջ��һ����ջһ������ջ
        CalculatorStack numStack = new CalculatorStack(10);
        CalculatorStack operStack = new CalculatorStack(10);

//        ��ʼ��ɨ����������ʼ��Ϊ0
        int index = 0;
        int num1;
        int num2;
        int oper;
        int res;
//        ����ƴ�Ӷ�λ��
        String keepNum = "";
        
        //        ÿ��ɨ��õ����ַ����浽ch
        int ch;

//        ��ʼѭ��ɨ����ʽ
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
//            �ж�ch��ʲô������Ӧ�Ĵ���
//            ����������
            if (operStack.isOper(ch)) {
//                �жϵ�ǰ����ջ�Ƿ�Ϊ��
                if (operStack.isEmpty()) {
//                    Ϊ����ֱ����ջ
                    operStack.push(ch);
                } else {
//                    ջ��Ϊ�վͺ�ջ�еĲ������Ƚ�
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
//                        �����ǰ�������ȼ�С�ڵ��ڷ���ջ�����ȼ����ʹ���ջ�е������������ͷ���ջ�е���������㣬�õ����������ջ��Ȼ�󽫵�ǰ����������ջ
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
//                        �����ǰ�������������ȼ�����ջ�еĲ���������ֱ��ѹ�����ջ
                        operStack.push(ch);
                    }
                    
                }
            } else {
//                ��������־�ֱ��ѹ��
//                asc�������������ִ�48����������
//                �����λ�������ܷ�����һ��������ջ����Ҫ����ʽindex���ٿ�һλ����������ͼ���ɨ�裬����Ƿ��ţ�����ջ
//                �����λ��
                keepNum = keepNum + (ch - 48);

//                ���ch�Ѿ������һ�����ˣ��Ͳ���Ҫ�ж��Ƿ�Ϊ��λ����ֱ����ջ
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
//                    �ж���һ���ַ��ǲ������֣���������־ͼ���ɨ�裬��������������ջ
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
//                        �����һλ�������������ջ
//                        ����Ҫ�����ַ���ת����
                        numStack.push(Integer.parseInt(keepNum));
//                        ���keepNum
                        keepNum = "";
                    }
                }
            }

//            ��index++���ж��Ƿ����
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

//        1. �����ʽ������ϣ���˳��Ĵ���ջ�ͷ���ջ�е�����Ӧ�����ͷ��ţ�������
//        2. �������ջ��ֻ����һ�����֣����Ǳ��ʽ�Ľ��
//        �������ջΪ�գ���������
        while (!operStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }

//        �����������ջ��Ψһ�������ǽ��
        System.out.println(numStack.pop());
    }
}
