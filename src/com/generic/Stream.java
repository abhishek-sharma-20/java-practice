package com.generic;

import java.util.*;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<Integer> dataList = Arrays.asList(1,10,12,7,10,118,3,0,-10,2,-11);
        //Sort
        List<Integer> dataList1 = dataList.stream().sorted().collect(Collectors.toList());
        System.out.println(dataList1);

        //Top 3
        dataList1 = dataList.stream().sorted().limit(3).collect(Collectors.toList());
        System.out.println(dataList1);

        //Bottom 3
        dataList1 = dataList.stream().sorted().collect(Collectors.collectingAndThen(
                Collectors.toList(),
                l->{Collections.reverse(l); return l ;}
        ));
        System.out.println(dataList1.stream().limit(3).collect(Collectors.toList()));

        //Minimun value
        System.out.println(dataList.stream().sorted().reduce((a,b)->a<b ? a : b).get());


        //Match value in stream
        System.out.println(dataList.stream().anyMatch(a->a==1));

        List<String> dataString = dataList.stream().map(Object::toString).filter(a->a.charAt(0) =='1').collect(Collectors.toList());
        System.out.println(dataString);
        System.out.println(dataString.stream().distinct().collect(Collectors.toList()));
        System.out.println(Integer.valueOf('a'));
//        System.out.println(bo);
        TreeSet<String> treeSet = new TreeSet<>(dataString);
        System.out.println(treeSet.stream().limit(3).collect(Collectors.toList()));
    }

}
