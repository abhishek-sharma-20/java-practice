package com.vishal_practice;

import java.util.Stack;

/*
The Longest Increasing Subsequence (LIS) problem is to find the length of the
longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order. For example, the length of LIS for
 { 10, 67, 9, 2, 15, 17,  3, 33, 21, 50, 41, 45, 46, 47, 48, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.=> 5
 10 => 11
 9 => 10
 2 => 10

  2 , 21 , 41  , 60 , 80 => 5

 maxLen = max of maxlen or len
 */
public class Temp {
    public static void main(String[] args) {
//        int[] input= {10, 67, 9, 2, 15, 17,  3, 33, 21, 50, 41, 45, 46, 47, 48, 60, 80};
//        int maxLen = 0;
//        Stack<Integer> integerStack = new Stack<>();
//        integerStack.push(input[0]);
//        for(int i =1;i<input.length;i++){
//            while(!integerStack.isEmpty() && integerStack.peek() > input[i]){
//                integerStack.pop();
//            }
//            integerStack.push(input[i]);
//            maxLen = Math.max(maxLen,integerStack.size());
//        }
//
//        System.out.println(" Longest Increasing Subsequence "+maxLen);
        spiralMatrix();

    }
    /*
    Spiral Traversal of Matrix
    [[1,2,3,4],
    [5,6,7,8],
    [9,10,11,12]]

    Output: [1,2,3,4,8,12,11,10,9,5,6,7]

     */
    public static void spiralMatrix(){
        int[][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int left = 0, right = input[0].length-1;
        int top = 0, bottom = input.length-1;
        while(left < right && top <= bottom){
            for(int i =left;i<=right;i++){
                System.out.print(input[top][i]+" ");
            }
            top++;
            for(int i = top;i<=bottom;i++){
                System.out.print(input[i][right]+" ");
            }
            right--;
            for(int i =right;i>=left;i--){
                System.out.print(input[bottom][i]+" ");
            }
            bottom--;
            for(int i =bottom;i>=top;i--){
                System.out.print(input[i][left]+" ");
            }
            left++;

        }
    }
}

