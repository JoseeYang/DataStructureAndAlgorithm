package com.bilibili.stack;

//计算器实现类
public class Calculator {
    public static void main(String[] args) {
//        定义表达式
        String expression = "30+20*6-20";

//        创建两个栈，一个数栈一个符号栈
        CalculatorStack numStack = new CalculatorStack(10);
        CalculatorStack operStack = new CalculatorStack(10);

//        初始化扫描索引，初始化为0
        int index = 0;
        int num1;
        int num2;
        int oper;
        int res;
//        用于拼接多位数
        String keepNum = "";
        
        //        每次扫描得到的字符保存到ch
        int ch;

//        开始循环扫描表达式
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
//            判断ch是什么，做相应的处理
//            如果是运算符
            if (operStack.isOper(ch)) {
//                判断当前符号栈是否为空
                if (operStack.isEmpty()) {
//                    为空则直接入栈
                    operStack.push(ch);
                } else {
//                    栈不为空就和栈中的操作符比较
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
//                        如果当前符号优先级小于等于符号栈的优先级，就从数栈中弹出两个数，和符号栈中的运算符计算，得到结果，入数栈，然后将当前运算符入符号栈
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
//                        如果当前操作符运算优先级大于栈中的操作符，就直接压入符号栈
                        operStack.push(ch);
                    }
                    
                }
            } else {
//                如果是数字就直接压入
//                asc码会比正常的数字大48，减掉即可
//                处理多位数，不能发现是一个数就入栈，需要向表达式index后再看一位，如果是数就继续扫描，如果是符号，就入栈
//                处理多位数
                keepNum = keepNum + (ch - 48);

//                如果ch已经是最后一个数了，就不需要判断是否为多位数，直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
//                    判断下一个字符是不是数字，如果是数字就继续扫描，如果是运算符就入栈
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
//                        如果后一位是运算符，则入栈
//                        首先要进行字符串转数字
                        numStack.push(Integer.parseInt(keepNum));
//                        清空keepNum
                        keepNum = "";
                    }
                }
            }

//            让index++，判断是否到最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

//        1. 当表达式索引完毕，就顺序的从数栈和符号栈中弹出对应的数和符号，并计算
//        2. 最后数字栈中只存在一个数字，就是表达式的结果
//        如果符号栈为空，则计算结束
        while (!operStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }

//        计算结束，数栈中唯一的数就是结果
        System.out.println(numStack.pop());
    }
}
