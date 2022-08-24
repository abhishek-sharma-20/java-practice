package com.generic;

import java.util.*;
import java.util.stream.Collectors;

public class Binary {
    public static void main(String[] args) {
        printBinary(100000000);
    }

    static void printBinary(int n) {
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.push(n % 2);
            n = n / 2;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

}

class MatchingParenthesis {
    public static void main(String[] args) {

        Map<Character,Character> blockMap = Map.of(']','[','}','{',')','(');
        System.out.println(checkParenthesis("{}[]()",blockMap));
        System.out.println(checkParenthesis("{[(({[]}))]}",blockMap));
        System.out.println(checkParenthesis("{[(({[}}))]}",blockMap));
        System.out.println(checkParenthesis("{}(](]",blockMap));

    }

    static boolean checkParenthesis(String s, Map<Character,Character> blockMap ) {
        Stack<Character> characterStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(blockMap.containsKey(c)){
                if(!characterStack.isEmpty() && characterStack.pop() != blockMap.get(c))
                    return false;
            }
            else
                characterStack.push(c);
        }
        return characterStack.isEmpty();
    }
}
class MostRepeatedWord{
    public static void main(String[] args) {

        System.out.println(getMostRepeatedWord("Students seek relief from rising prices through the purchase of used copies of textbooks, which tend to be less expensive. Most college bookstores offer used copies of textbooks at lower prices. Most bookstores will also buy used copies back from students at the end of a term if the book is going to be re-used at the school. Books that are not being re-used at the school are often purchased by an off-campus wholesaler for 0-30% of the new cost, for distribution to other bookstores where the books will be sold. Textbook companies have countered this by encouraging faculty to assign homework that must be done on the publisher's website. If a student has a new textbook, then he or she can use the pass code in the book to register on the site. If the student has purchased a used textbook, then he or she must pay money directly to the publisher in order to access the website and complete assigned homework. "));
    }
    static String getMostRepeatedWord(String s){
        int max = 0;
        String maxWord = "";
        HashMap<String,Integer> wordMap = new HashMap<>();
        List<String> stringList = List.of("the");
        List<String> normilized = Arrays.stream(s.split(" ")).filter(stringList::contains).collect(Collectors.toList());
        for(String str:normilized){
            wordMap.put(str,wordMap.getOrDefault(str,0)+1);
            if(max < wordMap.get(str)){
                max = wordMap.get(str);
                maxWord = str;
//                System.out.println(max +" "+maxWord+" "+str);
            }
        }
        System.out.println(max +" "+maxWord);
        return maxWord;
    }
}
