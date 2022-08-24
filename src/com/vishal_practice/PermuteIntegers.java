package com.vishal_practice;

//12
public class PermuteIntegers {
    public static void main(String[] args)
    {
        int[] input = {1,2,3};
        permute(input,"");
    }
    public static void permute(int[] input,String comb){
        if(comb.length() == 3)
        {
            System.out.println(comb);
            return;
        }
        for (int j : input) {
            if(comb.length() == 0 || !comb.contains(String.valueOf(j))) {
                comb += "" + j;
                permute(input, comb);
                comb = comb.substring(0, comb.length() - 1);
            }
        }

    }
}