package com.generic;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueue {
    static Queue<Integer> numberQueue = new LinkedList<>();
    public static void main(String[] args) {
        push(6);
        System.out.println(numberQueue.remove());

        push(7);
        push(1);
        push(8);

        System.out.println(numberQueue.remove());
    }

    public static void push(int num){
        if(numberQueue.isEmpty()){
            numberQueue.add(num);
            return;
        }

        int temp = numberQueue.poll();
        push(num);
        numberQueue.add(temp);
        return;

    }
}
