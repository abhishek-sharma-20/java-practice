package com.lld.splitwise;

public class SplitCalculator {
    static float performSplit(float amout , int numberOfUsers, SplitStrategoies splitStrategoies){
        SplitStrateogy splitStrateogy = SplitStrategoiesGenerator.getSplitStrategy(splitStrategoies);
        if(splitStrateogy != null)
            return splitStrateogy.performSplit(amout,numberOfUsers);

        System.out.println("Invalid SplitStrateogy"+splitStrategoies);
        return  0 ;

    }
}
