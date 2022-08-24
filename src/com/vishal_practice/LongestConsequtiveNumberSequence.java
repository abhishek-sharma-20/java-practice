package com.vishal_practice;

import java.util.HashSet;

public class LongestConsequtiveNumberSequence {
    public static void main(String[] args) {
        int[] array = {-10,6,-9,0,7,9,21,3,8,4};// distinct numbers
        HashSet<Integer> hashSet = new HashSet<>();
        int maxLen = 0;
        for (int j : array)
            hashSet.add(j);
        for (int j : array) {
            int temp = j;
            int currLen = 1;
            if (!hashSet.contains(temp - 1)) {
                temp++;
                while (hashSet.contains(temp)) {
                    currLen++;
                    temp++;
                }
            }
            maxLen = Math.max(maxLen, currLen);
        }
        System.out.println("Max Length "+maxLen);
    }
}
