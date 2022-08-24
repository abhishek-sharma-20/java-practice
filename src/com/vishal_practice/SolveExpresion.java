package com.vishal_practice;

import java.util.Stack;

/*
Given a string s which represents an expression, evaluate this expression and return its value. 
The integer division should truncate toward zero.
You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

Example 1:
Input: s = "3+2*2"
Output: 7
Example 2:
Input: s = " 3/2 "
Output: 1
Example 3:
Input: s = " 3+5 / 2 "
Output: 5

 */
public class SolveExpresion {
    public static void main(String[] args) {
        String input = "33+20*20";
        Stack<String> characterStack = new Stack<>();
        String temp ="";
        for(int i =0;i<input.length();) {
            if(Character.isDigit(input.charAt(i))){
                temp = getNextNumber(input,i);
                characterStack.push(temp);
            }
            else if (input.charAt(i) == '*') {
                int tempNum1 = Integer.parseInt(characterStack.pop());
                temp = getNextNumber(input,i+1);
                i++;
                characterStack.push(String.valueOf(tempNum1*(Integer.parseInt(temp))));
            }
            else if(input.charAt(i) == '+') {
                temp = getNextNumber(input, i + 1);
                i++;
                characterStack.push(temp);
            }
            i+=temp.length();

        }


        int sum = 0;
        while(!characterStack.isEmpty()){
//            System.out.println(characterStack.pop());
            sum+=Integer.parseInt(characterStack.pop());
        }
        System.out.println("Sum is "+sum);

    }
    public static String getNextNumber(String input,int i){
        StringBuilder tempNum = new StringBuilder();
        while (Character.isDigit(input.charAt(i))){
            tempNum.append(input.charAt(i));
            i++;
            if(i >= input.length())
                break;
        }
        return tempNum.toString();

    }
}
