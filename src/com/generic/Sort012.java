package com.generic;

public class Sort012 {
    public static void main(String[] args) {
        int[] input = {0,0,1,2,0,1,2,1,0};
        int zeroPointer = 0;
        int secondPointer = input.length-1;
        for(int i = 0;i<input.length;i++){
            if(input[i] == 0){
                int temp = input[zeroPointer];
                input[zeroPointer] = 0;
                input[i] = temp;
                zeroPointer++;
            }
            if(i >= secondPointer)
                break;
            if(input[i] == 2){
                int temp = input[secondPointer];
                input[secondPointer] = 2;
                input[i] = temp;
                secondPointer--;
            }
        }
        for(int i =0;i<input.length;i++)
            System.out.print(input[i]+" ");
    }
}
