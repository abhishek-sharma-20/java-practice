package com.vishal_practice;

import java.util.HashSet;

public class VerbalKhoKho {
    public static void main(String[] args) {
        int[] input = {1,2,3,2,2};
        System.out.println(getDistinct(input));
    }

    public static int getDistinct(int[] array){
        int max = 0;
        for(int i = 1;i<array.length-1;i++){
            if(array[i] != array[i+1])
                max = Math.max(max,i+1);
        }
        return  max;
    }
}
