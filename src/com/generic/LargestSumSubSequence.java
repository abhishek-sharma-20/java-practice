package com.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestSumSubSequence {

    public static void main(String[] args) {
        Integer[] array = {100, 60, 20, 70, 50, 80, 30};
        Integer[] sums =array.clone();
        Integer[] sequences = new Integer[array.length];
        Arrays.fill(sequences,-1);
        int maxIdx = 0,curr=0,other =0;
        for(int i =0;i<array.length;i++){
            curr = array[i];
            for(int j =0;j<i;j++) {
                other = array[j];
                if (other < curr && sums[j] + curr >= sums[i]) {
                    sums[i] =  sums[j] + curr;
                    sequences[i]=j;
                }
            }
            if(sums[maxIdx] < sums[i]) {
                maxIdx = i;
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(0,new ArrayList<>());
        res.add(0,new ArrayList<>());
        res.get(0).add(sums[maxIdx]);
        res.set(1,getSequence(array,sequences,maxIdx));
        System.out.println(res);
    }
    static List<Integer> getSequence(Integer[] arrays,Integer[] sequence,int maxIndex){
        List<Integer> res = new ArrayList<>();
        while(maxIndex != -1 ){
            res.add(0,arrays[maxIndex]);
            maxIndex = sequence[maxIndex];
        }
        return res;

    }
}
