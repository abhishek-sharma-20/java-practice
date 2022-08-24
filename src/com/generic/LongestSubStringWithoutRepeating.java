package com.generic;

// String of characters , a longest sub string without any reapeating characters
//aabbcdebf
//cdebf
public class LongestSubStringWithoutRepeating {
    public static void main(String[] args) {
        System.out.println(getMaxString("aabb"));
    }
    static int getMaxString(String str){
        String test = "";
        int maxLen = 0;
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            if(test.contains(String.valueOf(ch))){
                test=test.substring(test.indexOf(ch));
            }
            else
                test+=ch;
            if(maxLen < test.length())
                maxLen = test.length();
        }
        return maxLen;
    }
}
/*
*  ""   "b" ""
*
*
*
*
* */

