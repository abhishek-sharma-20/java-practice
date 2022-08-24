package com.generic;

import java.util.Arrays;

public class ShiftArray {
    public static void main(String[] args) {
        Integer[] test = new Integer[]{2,3,4,5,6,7,8,1};
        Integer[] test2 = new Integer[]{10,2,3,4,5,6,7,8};
        System.out.println(Arrays.deepToString(test));
        shiftArray(test,7,false);
        System.out.println(Arrays.deepToString(test));

    }
    public static void shiftArray(Integer[] candies, int index, boolean dir){
        if(dir){
            for(int i = index ;i<candies.length-1;i++){
                System.out.println(candies[i]);
                if(candies[i] > candies[i+1])
                {
                    int temp = candies[i];
                    candies[i] = candies[i+1];
                    candies[i+1] = temp;
                }
            }
        }
        else
        {
            for(int i = index ;i>0;i--){
                if(candies[i] < candies[i-1])
                {
                    int temp = candies[i];
                    candies[i] = candies[i-1];
                    candies[i-1] = temp;
                }
            }
        }
    }
}
