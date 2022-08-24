package com.generic;

import java.util.ArrayDeque;
import java.util.Deque;

public class RobotsAndStrings {
    public static void main(String[] args) {
        System.out.println(lex(3,"cba"));

    }
    static String lex(int input1, String input2){
        char[] ch = input2.toCharArray();
        Deque<Character> ben = new ArrayDeque<>();
        Deque<Character> kevin = new ArrayDeque<>();
        ben.add(ch[1]);
        kevin.add(ch[0]);
        int rayIndex = 2;
        while(kevin.size() < input1){
            if(rayIndex < input1 && ben.getLast() <= ch[rayIndex]){
                ben.add(ch[rayIndex]);
                rayIndex++;
            }
            else if(kevin.getLast() >= ben.getLast()){
                    kevin.add(ben.removeLast());
                    if(ben.isEmpty() && rayIndex < input1){
                        ben.add(ch[rayIndex]);
                        rayIndex++;
                    }
            }
            else
                break;

//            System.out.println("Ben " + ben.getLast());
//            System.out.println("Kevin " + kevin.getLast());
//            System.out.println("RayIndex " + rayIndex);
        }
        while(!kevin.isEmpty()){
            System.out.println(kevin.poll());
        }
        return "Hello";
    }
}
