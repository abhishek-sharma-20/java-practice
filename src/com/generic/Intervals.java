package com.generic;
import java.util.*;

public class Intervals {
    public static void main(String[] args) {
        //[[1,3],[6,9]]
        List<int[]> matrixList = new ArrayList<>();
        matrixList.add(new int[]{1,2});
        matrixList.add(new int[]{3,4});
        matrixList.add(new int[]{6,7});
        matrixList.add(new int[]{10,11});
        matrixList.add(new int[]{12,16});
        //[1,2],[3,5],[6,7],[8,10],[12,16]
        int[] newInterval = new int[]{4,11};

        for(int i=0;i<matrixList.size();i++){
            if(matrixList.get(i)[0] > newInterval[0])
            {matrixList.add(i,newInterval);
                break;}
        }

        for(int i =1;i<matrixList.size();){
            if(matrixList.get(i)[0] <= matrixList.get(i-1)[1]){
                int[] temp = matrixList.get(i-1);
                temp[1] = Math.max(temp[1],matrixList.get(i)[1]);
                matrixList.set(i-1,temp);
                matrixList.remove(i);
            }
            else
                i++;
        }
                 for(int[] i : matrixList){
                     System.out.println(i[0]+" "+i[1]);

                 }
    }
}
