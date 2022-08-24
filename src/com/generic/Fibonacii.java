package com.generic;

public class Fibonacii {
    public static void main(String[] args) {
        int n = 14;
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for(int i =2;i<=n;i++){
            f[i] = f[i-1] + f[i-2];
        }
        System.out.println(f[n]);
        int[][] first = { { 1, 1 }, { 1, 0 } };
        int[][] r = matrixMul(first,n-1);

        System.out.println(r[0][0]);
    }

    static  int[][] matrixMul(int[][] k, int n){
        // k = number/matrix
        // n = power
        int[][] main = { { 1, 0 }, { 0, 1 } };  //  Identity matrix
        int[][] prev = k;

        if((n & 1) == 1)
            main = k;
        n = n >> 1;
        while(n>0){
            {
                prev = mul(prev,prev);
            }
            if((n & 1) == 1)
                main = mul(prev,main);
            n = n >> 1;
        }
        return main;
    }

    static int[][] mul(int[][] i, int[][] j){
        int[][] res = new int[2][2];
        res[0][0] = i[0][0] * j[0][0] + i[0][1] * j[1][0];
        res[0][1] = i[0][0] * j[0][1] + i[0][1] * j[1][1];
        res[1][0] = i[1][0] * j[0][0] + i[1][1] * j[1][0];
        res[1][1] = i[1][0] * j[0][1] + i[1][1] * j[1][1];

        return res;
    }
    /*
    f(2) = x y  f (1)   = x.f(1) + y.f(0) = x(1) + y (0) = x
           1 0  f (0)   =  f(1)
    *
    * */
}
