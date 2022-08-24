package com.generic;
/*
Array of ints containing durations of song played
[40,90,30,150,20]
[40,30,30,30,20]
40 20
90 30
90 150
30 150
Return pair of ints which are multiple of 60.
90 30
30 150
40 20
150 90
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
public class Problem {
    public static void main(String[] args) {
        System.out.println(getSongLengthPairs(new int[]{40,90,30,150,20}));

    }
    public static List<List<Integer>> getSongLengthPairs(int[] songLengths){
        List<List<Integer>> resultList = new ArrayList<>();
        HashMap<Integer,List<Integer>> lengthMap = new HashMap<>();
        int[] tempSongLengthsArray = new int[songLengths.length];
        for(int i =0;i< tempSongLengthsArray.length;i++)
            tempSongLengthsArray[i]= songLengths[i]%60;
        for(int i =0;i< tempSongLengthsArray.length;i++){
            if(!lengthMap.containsKey(tempSongLengthsArray[i])) {
                List<Integer> integerList = new ArrayList<>();
                integerList.add(i);
                lengthMap.put(tempSongLengthsArray[i], integerList);
            }
            else{
                List<Integer> integerList = lengthMap.get(tempSongLengthsArray[i]);
                integerList.add(i);
                lengthMap.put(tempSongLengthsArray[i], integerList);
            }
        }
        for(int i =0;i< tempSongLengthsArray.length;i++){
            int temptarget = 60-tempSongLengthsArray[i];
            if(lengthMap.containsKey(temptarget)){
                for(Integer integer : lengthMap.get(temptarget)){
                    if(integer > i)
                        resultList.add(new ArrayList<>(Arrays.asList(songLengths[i],songLengths[integer])));
                }
            }
        }
        return resultList;



    }

}
