package com.generic;

import java.util.stream.IntStream;

public enum StringChecker {
    TRUE,
    FALSE;
    static StringChecker palindromChecker(String s){
        int i = 0;
        int j = s.length()-1;
        s=s.toLowerCase();
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return StringChecker.FALSE;
            i++;
            j--;
        }
        return StringChecker.TRUE;
    }
    static boolean palindromCheckerStream(String s){
        int len = s.length();
        final String normilized = s.toLowerCase();
        return IntStream.range(0,len/2).allMatch(
                i-> normilized.charAt(i)==normilized.charAt(len-i-1)
        );
    }

    static void vowelAndConsonantsChecker(String s){
        String vowels = "aeiou";
        System.out.println("Number of Vowels are "+s.toLowerCase().chars().filter(a->vowels.indexOf(a)!=-1).count());
        System.out.println("Number of Consonants are "+s.toLowerCase().chars().filter(a->vowels.indexOf(a)==-1).count());
    }

    public static void main(String[] args) {
//        System.out.println(palindromChecker("racecar"));
//        System.out.println(palindromChecker("cat"));
//        System.out.println(palindromCheckerStream("racecar"));
//        System.out.println(palindromCheckerStream("cat"));
        vowelAndConsonantsChecker("hello");
        vowelAndConsonantsChecker("Hello World");
    }
}
