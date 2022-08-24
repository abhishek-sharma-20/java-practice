package com.generic;

import java.util.*;

public class FrequencySort {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5,1,3,8};
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i =0;i<input.length;i++){
            if(hashMap.containsKey(input[i]))
                hashMap.put(input[i],hashMap.get(input[i])+1);
            else
                hashMap.put(input[i],1);
        }

        List<Integer> list = new LinkedList(hashMap.entrySet());

        Collections.sort(list, (Comparator) (o1, o2) -> {
            int res = ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
            if( res!= 0)
                return res;
            else
                return ((Comparable) ((Map.Entry) (o1)).getKey()).compareTo(((Map.Entry) (o2)).getKey());
        });
        HashMap sortedHashMap = new LinkedHashMap();
        List<Integer> resList = new ArrayList<>();
        for (Iterator it = list.iterator(); it.hasNext();)
        {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
            for(int i =0;i<(Integer) entry.getValue();i++)
                resList.add((Integer) entry.getKey());
        }
        System.out.println(resList);

    }
}
