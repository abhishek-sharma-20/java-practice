package com.vishal_practice;

import java.util.Stack;

// Given a String validate if it has valid brackets
// {()[]{()}[]} true
// {()[]{)(}[]} false
public class ValidBrackets {
    public static void main(String[] args) {
        System.out.println(validBrackets("{()[]{()}[]}"));
        System.out.println(validBrackets("{()[]{)(}[]}"));
    }
    public static boolean validBrackets(String string){
        char[] ch = string.toCharArray();
        char bracket;
        Stack<Character> characterStack = new Stack<>();
        for (char c : ch) {
            switch (c) {
            case '}':
                bracket = characterStack.pop();
                if (bracket != '{')
                    return false;
                break;
            case ']':
                bracket = characterStack.pop();
                if (bracket != '[')
                    return false;
                break;
            case ')':
                bracket = characterStack.pop();
                if (bracket != '(')
                    return false;
                break;
            default:
                characterStack.push(c);
            }
        }
        return characterStack.isEmpty();
    }
}
