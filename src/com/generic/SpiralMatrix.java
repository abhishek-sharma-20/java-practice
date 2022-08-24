package com.generic;

public class SpiralMatrix {
    static int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

    /***
     * 1  2  3  4
     * 5  6  7  8
     * 9 10 11 12
     * 13 14 15 16
     */
    public static void main(String[] args) {
        printSpiralMatrix();
    }
    static void printSpiralMatrix(){
        int t=0,b=matrix.length-1;
        int l=t , r = b;
        while(t<b){
            for(int i =l;i<=r;i++){
                System.out.println(matrix[t][i]);
            }
            t++;
            for(int i =t;i<=b;i++){
                System.out.println(matrix[i][r]);
            }
            r--;
            for(int i =r;i>=l;i--){
                System.out.println(matrix[b][i]);
            }
            b--;
            for(int i =b;i>=t;i--){
                System.out.println(matrix[i][l]);
            }
            l++;
        }
    }
}
