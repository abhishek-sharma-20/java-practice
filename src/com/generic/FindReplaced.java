package com.generic;

/*
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

Example 1:

Input: nums = [1,2,3,3]
Output: [3,4]

Example 2:

input : [2,3,2,1]  // givenSum = 8 requiredSum = 10  // 2   Misiing values = requiredSum - (givenSum-repeatedValue) = > 10 -(8-2) = > 4
out: [2,4]

input : [ 1,2,3,4,3]
out [3,5]
 */
public class FindReplaced {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,3};
        int[] result = getRepeatedAndMissingValue(input);
        System.out.println(result[0]+" "+result[1]);
    }

    public static int[] getRepeatedAndMissingValue(int[] input){
        int len = input.length;
        int requiredSum = (int)len*(len+1)/2,givenSum=0;
        int repeatedValue = -1;
        for(int i =0;i<input.length;i++){
            int temp = Math.abs(input[i]);
            givenSum+=temp;
            if(input[temp] < 0){
                repeatedValue = temp;
            }
            else
                input[temp]*=-1;
        }
        int missingValue = requiredSum - (givenSum-repeatedValue);
        return new int[]{repeatedValue,missingValue};
    }

}
