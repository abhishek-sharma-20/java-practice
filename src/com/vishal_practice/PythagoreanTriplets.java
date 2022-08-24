package com.vishal_practice;

import java.util.*;

// Given an array of numbers , find triplets which justify a*a = b*b + c*c;
// [ 1,2,3,4,5] => {3,4,5}
public class PythagoreanTriplets {
    public static void main(String[] args) {
        int[] input = {3,7, 2,24,12,1,5,6,4,9,13,10,25};
        List<List<Integer>> result = getTriplets(input);
        for(List<Integer> numberList : result)
            System.out.println(numberList);

    }
    public static List<List<Integer>> getTriplets(int[] array){
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> numberSet = new HashSet<>();
        for (int j : array)
            numberSet.add(j * j);

        for(int i = array.length-1;i>=0;i--){
            List<Integer> tempList = getSum(numberSet,array[i]*array[i]);
            if(tempList.size() != 0){
                tempList.add(array[i]);
                result.add(tempList);
            }
        }
        return result;
    }
    public static List<Integer> getSum(HashSet<Integer> numberSet, int target){
        List<Integer> numberList = new ArrayList<>();
        for (int temp : numberSet) {
            if (numberSet.contains(target - temp)) {
                numberList.add((int) Math.sqrt(temp));
                numberList.add((int) Math.sqrt(target - temp));
                return numberList;
            }
        }
        return numberList;
    }
}
