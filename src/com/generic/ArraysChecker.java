package com.generic;

import java.util.Arrays;

public class ArraysChecker {

    static int getMaxMul(int[] nums){
        int len = nums.length-1;
        Arrays.sort(nums);
        return nums[len]*nums[len-1];
    }

    static int getMinMul(int[] nums){
        Arrays.sort(nums);
        return nums[0]*nums[1];
    }


    public static void main(String[] args) {
        int[] nums = {1,2,4,2,5,7,9,8};
        System.out.println(getMaxMul(nums));
        System.out.println(getMinMul(nums));
    }
}
