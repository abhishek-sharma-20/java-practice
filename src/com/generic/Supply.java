package com.generic;

import java.util.Arrays;

public class Supply {
    public static void main(String[] args) {
        int[][] input = { {4,-2} ,{4,3} ,{-2,5} ,{-2,-3}};
        Integer[] res = new Integer[input.length];
        for(int i =0;i<input.length;i++){
            res[i]= input[i][0] > 0 && input[i][1] < 0 ? input[i][0]+input[i][1] : 0;
        }
        System.out.println(Arrays.deepToString(res));
    }
}
