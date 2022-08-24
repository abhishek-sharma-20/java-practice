package com.generic;

/*
Find the minimium no of deletions required to convert a string into a palindrome.

Input: "ABDCBA"
Output: 1
Input "ACBCDBAA" "ABCBA" "CDA"
output: 3


ACBCDBAA
 1    1

 */
public class MinimumDeletionToPalindrome {
    public static void main(String[] args) {
        String givenString = "ABDCBA";
        System.out.println("Minumun number of deletion to make String palindrome "+ minDeletion(givenString));
    }
    static int minDeletion(String s){
        if(s.length() <=1)
            return 0;
        int numberOfDeletion = 0;
        int start = 0,end = s.length()-1;
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{
                numberOfDeletion = Math.min(minDeletion(s.substring(start+1,end+1)),minDeletion(s.substring(start,end)))+1;
                break;
            }
        }
        return numberOfDeletion;

    }
}
