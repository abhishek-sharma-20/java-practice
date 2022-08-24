package com.vishal_practice;

import java.util.ArrayList;
import java.util.List;

public class NChooseK {
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int n = 5, k = 2;
        choose(n,k,1,new ArrayList<>());
        for(List<Integer> integers : res){
            System.out.println(integers);
        }
    }

    public static void choose(int n , int k, int i, List<Integer> temp){
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(;i<=n;i++){
            temp.add(i);
            choose(n,k,i+1,temp);
            temp.remove(temp.size()-1);
        }
    }
}
