package com.vishal_practice;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubSets {
    public static void main(String[] args) {
        String input = "xy";
        List<String> subsets = new ArrayList<>();
        subsets.add("");
        for(int i =1;i<=input.length();i++){
            int start = 0;
            for(int j = i;j<=input.length();j++){
                subsets.add(input.substring(start,j));
                start++;
            }
        }
        System.out.println(subsets);
    }
}
