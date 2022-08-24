package com.vishal_practice;
/*
Given a string s, find the length of the longest substring t that contains at most 2 distinct characters.
Example 1:
Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:
Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
 */
public class NewClass {
    public static void main(String[] args) {
        String input = "ccaabbb";
        System.out.println(longString(input));
    }
    public static int longString(String input){
        String temp = "";
        int maxLen = 0;
        int left = 0, right = left+1,len = input.length();
        temp+=""+input.charAt(0);
        while(right < len){
            while(right < len && temp.contains(""+input.charAt(right))){
                right++;
            }
            maxLen = Math.max(right-left,maxLen);
            if(right == len)
                break;

            temp+=""+input.charAt(right);
            if(temp.length() > 2) {
                char ch = input.charAt(left);
                while(left < len-1 && temp.contains(""+ch))
                {
                    left++;
                }

                switch (temp.indexOf(ch)){
                case 0 : temp = temp.substring(1);
                        break;
                case 1: temp = temp.substring(0,1)+temp.substring(2);
                        break;

                }
//                temp = temp.substring(0,temp.indexOf(ch))+ temp.substring(temp.indexOf(ch)+1);
            }
            System.out.println(temp);
//            maxLen = Math.max(right-left+1,maxLen);
//            right++;

        }
        return maxLen;
    }
}
/*
                4 digit number
                Node int digit , boolean end , String Name children[] NOdes
                1234 => A
                1237 => B
                1375 =>C
                1234
                     0
                1
              2  3
            3      7
          4   7      5



          Table 1
                    Id , Name , AddressId
          Table 2
                    AddressId Street


           Inner Join: Select t1.Id , t1.Name , t2.Street from Table1  as  t1 inner join Table2 as t2 on t1.addressId = t2.AddressId
           Outer Join:
           Left Outer Join:
           Right Outer Join:









 */
