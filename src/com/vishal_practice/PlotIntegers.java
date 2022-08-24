package com.vishal_practice;

//Given positive set of integers find set of integers which can have maximum area between 2 bars
// [1, 2, 3 ,2,1] => 4
// [1,8,6,2,5,4,8,3,7] => 49
public class PlotIntegers {
    public static void main(String[] args) {
        int[] input = {1,8,6,2,5,4,8,3,7};
        System.out.println(getMaxArea(input));
    }
    public static int getMaxArea(int[] array){
        int maxArea = 0;
        int start = 0, end = array.length-1;
        while(start < end){
            int min = Math.min(array[start],array[end]);
            maxArea = Math.max(maxArea,min*(end-start));
            if(min == array[start])
                start++;
            else
                end--;
        }
        return maxArea;
    }
}
