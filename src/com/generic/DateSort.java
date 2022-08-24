package com.generic;

import java.util.*;
import java.util.stream.Collectors;

public class DateSort {
    public static void main(String[] args)
    {

        ArrayList<String> dateList = new ArrayList<>();

        dateList.add("03-2020");
        dateList.add("10-2019");
        dateList.add("01-1998");
        dateList.add("02-1998");
        dateList.add("02-2020");
        dateList.add("11-2019");
        dateList.add("01-1999");
        dateList.add("02-2000");
        dateList.add("03-2022");
        dateList.add("10-2020");
        dateList.add("11-2998");
        dateList.add("12-3998");

        List<String> dateList2 = dateList.stream().map(DateSort::reverseString).sorted(String::compareTo).map(DateSort::reOrder).collect(Collectors.toList());

        System.out.println(dateList2);
    }
    public static String reverseString(String s){
        String[] temp = s.split("-");
        Collections.reverse(Arrays.asList(temp));
        return String.join("-",temp);
    }
    public static String reOrder(String s){
        String[] temp = s.split("-");
        Arrays.sort(temp);
        return String.join("-",temp);
    }
}
