package com.generic;

import java.util.ArrayList;
import  java.util.List;
public class StringProblem {
    public static void main(String[] args) {
//        printBracketPair(1,0,4,"(");
        getComb("106",0,new ArrayList<>(),"");
    }
    static void printBracketPair(int openbracket,int closebrakcet,int n,String comb){
        if(comb.length() == 2*n || (openbracket==n && closebrakcet == n))
            System.out.println(comb);

        if(openbracket < n){
            openbracket++;
            comb+="(";
            printBracketPair(openbracket,closebrakcet,n,comb);
            comb=comb.substring(0,comb.length()-1);
            openbracket--;
        }
        if(closebrakcet<openbracket){
            closebrakcet++;
            comb+=")";
            printBracketPair(openbracket,closebrakcet,n,comb);
            closebrakcet--;
            comb=comb.substring(0,comb.length()-1);
        }
    }
    static void getComb(String s , int index,List<String> res, String comb) {
        if (index == s.length()) {
            String word = comb.substring(0,comb.length()-1);
            System.out.println(word);
            res.add(new String(word));
            return;
        }

        if(s.charAt(index) != '0') {
            comb += s.charAt(index) + ",";
            getComb(s, index + 1, res, comb);
            comb = comb.substring(0, comb.length() - 2);
        }

        if (index+2 <= s.length() && Integer.parseInt(s.substring(index, index + 2)) >= 10 && Integer.parseInt(s.substring(index, index + 2)) < 26) {
            comb += s.substring(index, index + 2) + ",";
            getComb(s, index + 2, res, comb);
            comb = comb.substring(0, comb.length() - 3);
        }
    }
}
//From Krishnakanth Chinnamsetti to Everyone 02:29 PM
//restore
