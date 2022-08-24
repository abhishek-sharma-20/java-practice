package com.generic;

public class PickEmlements {
    public static void main(String[] args) {
        int n = 5, k = 3;
        int[] list = new int[]{6,7,8,9,10};
        long res = 0L;
        int mod =(int) Math.pow(10,9)+7;
        for(int i =0;i<n;i++){
            res+=sum(list,k,i,0);
            res%=mod;
        }
        System.out.println(res);
    }
    static int sum(int[] list, int k, int i, int listSum){
        if(i<0 || i>=list.length)
            return 0;
        listSum+=list[i];
        k--;
        if(k==0) {
            return listSum;
        }
        return sum(list,k,i+1,listSum) + sum(list,k,i-1,listSum);
    }
}
