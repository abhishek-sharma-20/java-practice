package com.generic;

import java.util.*;
import java.util.stream.Collectors;

public class Knapsack {
    public static void main(String[] args) {
        int[][] items = { { 1, 2 }, { 4, 3 }, { 5, 6 }, { 6, 9 } };
        int size = 11;

        List<List<Integer>> res = new ArrayList<>();
        Integer[][] matrix = new Integer[items.length+1][size+1];
        for (Integer[] integers : matrix) {
            Arrays.fill(integers,0);
        }
        for(int i=1;i<= items.length;i++){
            int currweight = items[i-1][1];
            int currvalue = items[i-1][0];
            for(int j =0;j<=size;j++){
                if(currweight > j){
                    matrix[i][j]= matrix[i-1][j];
                }
                else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i-1][j-currweight]+currvalue);
                }
            }
        }
        for(Integer[] temp : matrix)
        {
            System.out.println(Arrays.deepToString(temp));
        }
        res.add(Collections.singletonList(matrix[items.length][size]));
        res.addAll(getSeq(matrix,items));
        System.out.println(res);
    }
    static List<List<Integer>> getSeq(Integer[][] matrix, int[][] items){
        List<List<Integer>> res = new ArrayList<>();
        int i = matrix.length-1;
        int j = matrix[0].length-1;
        while (matrix[i][j]!=0){
            if(!Objects.equals(matrix[i - 1][j], matrix[i][j])){
                if(!Objects.equals(matrix[i][j - 1], matrix[i][j])){
                    res.add(Arrays.stream(items[i-1]).boxed().collect(Collectors.toList()));
                    j-=items[i-1][1];
                    i--;
                }
                else
                    j--;
            }
            else
                i--;
        }
        return res;
    }
}