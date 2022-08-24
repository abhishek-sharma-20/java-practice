package com.vishal_practice;

//5
public class PermuteAlphabets {
    public static void main(String[] args) {
        permute("A1m2Z","",0);
    }
    public static void permute(String s, String comb,int index){
        if(comb.length() == s.length()){
            System.out.println(comb);
            return;
        }
        for(int i =index ;i<s.length();i++){
            if(Character.isAlphabetic(s.charAt(i))){
                permute(s,comb+""+Character.toLowerCase(s.charAt(i)),i+1);
                permute(s,comb+""+Character.toUpperCase(s.charAt(i)),i+1);
            }
            else{
                permute(s,comb+""+s.charAt(i),i+1);
            }
        }
    }
}
