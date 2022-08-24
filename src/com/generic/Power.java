package com.generic;

public class Power {
    public static void main(String args[]){
        int k = Integer.parseInt(args[0]), n = Integer.parseInt(args[1]);
        int main = 1, prev = k;

        if((n & 1) == 1)
            main = k;
        n = n >> 1;
        while(n>0){
            prev = prev * prev;
            if((n & 1) == 1)
                main = prev*main;
            n = n >> 1;
        }
        System.out.println(args[0]+" to the power of "+args[1]+" is : "+main);
    }
}
