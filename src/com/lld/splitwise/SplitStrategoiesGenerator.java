package com.lld.splitwise;

public class SplitStrategoiesGenerator {
    static SplitStrateogy getSplitStrategy(SplitStrategoies splitStrategoies){
        if(splitStrategoies == SplitStrategoies.EXACT)
            return new EqualSplitStrategoy();
        return null;
    }
}
