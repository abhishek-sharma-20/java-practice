package com.generic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String str = "leetcode";
        Set<String> stringSet = new HashSet<>(Arrays.asList("leet","code"));
        boolean dp[] = new boolean[str.length()+1];
        dp[0] = true;
        for(int i =1;i<=str.length();i++){
            for(int j = i-1;j>=0;j--){
                if(dp[j] && stringSet.contains(str.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(dp[str.length()]);
    }
}
