package com.bilibili.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//�沨��������ʵ����
public class PolandNotation {
    public static void main(String[] args) {
//        ������ʽ
        String expression = "1+((2+3)*4)-5";
//        ����׺���ʽתΪ��׺���ʽ
//        ��1+((2+3)*4)-5 תΪ 1 2 3 + 4 * + 5 -
//        ��Ϊֱ�Ӷ�str���������㣬����Ƚ�1+((2+3)*4)-5 תΪ ��Ӧ��List
        List<String> infixExpression = toInfixExpressionList(expression);
//        ����׺���ʽListתΪ��׺���ʽList
        List<String> suffixExpression = parseSuffixExpressionList(infixExpression);
//        ��������
        System.out.println(calculate(suffixExpression));
    }
    
    
    //    ��һ����׺���ʽתΪ��Ӧ��List
    public static List<String> toInfixExpressionList(String s) {
//        ����һ��List�������׺���ʽ��Ӧ������
        ArrayList<String> list = new ArrayList<>();
//        iΪһ��ָ�룬���ڱ�����׺���ʽ�ַ���
//        str�ǶԶ�λ����ƴ��
//        ÿ������һ���ַ����ͷ��뵽c
        int i = 0;
        String str;
        char c;
        
        while (i < s.length()) {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
//                ���c��һ�������֣��ͽ������list
                list.add("" + c);
                i++;
            } else {
//                ���c��һ��������Ҫ���Ƕ�λ��
//                �Ƚ�str����Ϊ��
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str = str + c;
                    i++;
                }
                list.add(str);
            }
        }
        return list;
    }
    
    
    //    ��һ����׺���ʽ��ListתΪ��׺���ʽ��List
    public static List<String> parseSuffixExpressionList(List<String> prefixList) {
//        ������Ҫ���ص�List
        ArrayList<String> suffixList = new ArrayList<>();
//        ��ʼ������ջ�������ջs1�ʹ洢�м�����ջs2
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

//        �����ұ�����׺���ʽ
        for (String item : prefixList) {
            if (item.matches("\\d+")) {
//                ����ǲ���������ֱ�ӽ���ѹ��s2
                stack2.push(item);
            } else if (item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/")) {
//                ��������������Ƚ�����s1ջ������������ȼ�
                while (true) {
                    if (stack1.empty() || stack1.peek().equals("(")) {
//                    ���s1Ϊ�գ�����ջ��Ԫ��Ϊ(����ֱ��ѹ��ջs1
                        stack1.push(item);
                        break;
                    } else if (priority(item) > priority(stack1.peek())) {
//                    ����Ϊ�գ������ȼ���ջ��������ĸߣ�Ҳ�������ѹ��s1
                        stack1.push(item);
                        break;
                    }
//                    ����������s1ջ���������������ѹ�뵽s2�У��ٴ���s1���µ�ջ��������Ƚ�
                    stack2.push(stack1.pop());
                }
            } else if (item.equals("(") || item.equals(")")) {
//                ���������
                if (item.equals("(")) {
//                    ����������š�(������ֱ��ѹ��s1
                    stack1.push(item);
                } else {
//                    ����������š�)���������ε���s1ջ�������������ѹ��s2��ֱ������������Ϊֹ������һ�����Ŷ���
                    while (!stack1.peek().equals("(")) {
                        stack2.push(stack1.pop());
                    }
//                    ����������
                    stack1.pop();
                }
            }
        }
//        ����ִ�е��˴����Ѿ��������˱��ʽ�����ұ�
//        ��s1��ʣ�����������ε�����ѹ��s2
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }

//        ���ε���s2��Ԫ�ز���������������Ϊ��׺���ʽ��Ӧ�ĺ�׺���ʽ
        while (!stack2.empty()) {
            suffixList.add(0, stack2.pop());
        }
        return suffixList;
    }
    
    
    //    ���㵱ǰ����������ȼ�
    public static int priority(String s) {
        int c = s.charAt(0);
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        }
        return -1;
    }
    
    
    //    ��һ���沨�����ʽ�ַ��������ν����ݺ���������뵽ArrayList��
    public static ArrayList<String> getListString(String suffixExpression) {
//        ��suffixExpression�ָ�
        String[] split = suffixExpression.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }
    
    
    //    ���㺯��������һ��list�����������
    public static int calculate(List<String> list) {
//        ����һ��ջ��ֻ��Ҫһ��ջ
        Stack<String> stack = new Stack<>();
//        ����list
        for (String item : list) {
//            ����ʹ��������ʽ��ȡ����
            if (item.matches("\\d+")) {
//                ���ƥ��������֣�����ջ
                stack.push(item);
            } else {
//                pop���������ݣ����м��㣬����ջ
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = switch (item) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "*" -> num1 * num2;
                    case "/" -> num1 / num2;
                    default -> 0;
                };
                stack.push(res + "");
            }
        }
//        ȫ��ִ����󣬵������ݼ�Ϊ���
        return Integer.parseInt(stack.pop());
    }
}
