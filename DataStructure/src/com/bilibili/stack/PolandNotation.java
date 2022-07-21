package com.bilibili.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//逆波兰计算器实现类
public class PolandNotation {
    public static void main(String[] args) {
//        定义表达式
        String expression = "1+((2+3)*4)-5";
//        将中缀表达式转为后缀表达式
//        将1+((2+3)*4)-5 转为 1 2 3 + 4 * + 5 -
//        因为直接对str操作不方便，因此先将1+((2+3)*4)-5 转为 对应的List
        List<String> infixExpression = toInfixExpressionList(expression);
//        将中缀表达式List转为后缀表达式List
        List<String> suffixExpression = parseSuffixExpressionList(infixExpression);
//        计算出结果
        System.out.println(calculate(suffixExpression));
    }
    
    
    //    将一个中缀表达式转为对应的List
    public static List<String> toInfixExpressionList(String s) {
//        定义一个List，存放中缀表达式对应的内容
        ArrayList<String> list = new ArrayList<>();
//        i为一个指针，用于遍历中缀表达式字符串
//        str是对多位数的拼接
//        每遍历到一个字符，就放入到c
        int i = 0;
        String str;
        char c;
        
        while (i < s.length()) {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
//                如果c是一个非数字，就将其加入list
                list.add("" + c);
                i++;
            } else {
//                如果c是一个数，就要考虑多位数
//                先将str设置为空
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
    
    
    //    将一个中缀表达式的List转为后缀表达式的List
    public static List<String> parseSuffixExpressionList(List<String> prefixList) {
//        创建需要返回的List
        ArrayList<String> suffixList = new ArrayList<>();
//        初始化两个栈，运算符栈s1和存储中间结果的栈s2
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

//        从左到右遍历中缀表达式
        for (String item : prefixList) {
            if (item.matches("\\d+")) {
//                如果是操作数，就直接将其压入s2
                stack2.push(item);
            } else if (item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/")) {
//                如果是运算符，则比较其与s1栈顶运算符的优先级
                while (true) {
                    if (stack1.empty() || stack1.peek().equals("(")) {
//                    如果s1为空，或者栈顶元素为(，则直接压入栈s1
                        stack1.push(item);
                        break;
                    } else if (priority(item) > priority(stack1.peek())) {
//                    若不为空，且优先级比栈顶运算符的高，也将运算符压入s1
                        stack1.push(item);
                        break;
                    }
//                    都不满足则将s1栈顶的运算符弹出并压入到s2中，再次与s1中新的栈顶运算符比较
                    stack2.push(stack1.pop());
                }
            } else if (item.equals("(") || item.equals(")")) {
//                如果是括号
                if (item.equals("(")) {
//                    如果是左括号“(”，则直接压入s1
                    stack1.push(item);
                } else {
//                    如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，将这一对括号丢弃
                    while (!stack1.peek().equals("(")) {
                        stack2.push(stack1.pop());
                    }
//                    丢弃左括号
                    stack1.pop();
                }
            }
        }
//        代码执行到此处，已经遍历到了表达式的最右边
//        将s1中剩余的运算符依次弹出并压入s2
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }

//        依次弹出s2的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
        while (!stack2.empty()) {
            suffixList.add(0, stack2.pop());
        }
        return suffixList;
    }
    
    
    //    计算当前运算符的优先级
    public static int priority(String s) {
        int c = s.charAt(0);
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        }
        return -1;
    }
    
    
    //    将一个逆波兰表达式字符串，依次将数据和运算符放入到ArrayList中
    public static ArrayList<String> getListString(String suffixExpression) {
//        将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }
    
    
    //    计算函数，传入一个list，输出计算结果
    public static int calculate(List<String> list) {
//        创建一个栈，只需要一个栈
        Stack<String> stack = new Stack<>();
//        遍历list
        for (String item : list) {
//            这里使用正则表达式来取出数
            if (item.matches("\\d+")) {
//                如果匹配的是数字，就入栈
                stack.push(item);
            } else {
//                pop出两个数据，进行计算，再入栈
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
//        全部执行完后，弹出数据即为结果
        return Integer.parseInt(stack.pop());
    }
}
