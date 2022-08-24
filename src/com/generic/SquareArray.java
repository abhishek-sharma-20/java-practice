package com.generic;

public class SquareArray {
    public static void main(String[] args) {
        int[] array = new int[]{-10,5,0,5,10,12};
        int start = 0, end = array.length-1,index = end;
        int[] res = new int[array.length];
        while(start < end){
            if(Math.pow(array[start],2) < Math.pow(array[end],2)){
                res[index] = (int)Math.pow(array[end],2);
                end--;
            }
            else{
                res[index] = (int)Math.pow(array[start],2);
                start++;
            }
            index--;
        }
        for (int re : res)
            System.out.print(re + " ");
    }
}
