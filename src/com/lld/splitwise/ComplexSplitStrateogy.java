package com.lld.splitwise;

public interface ComplexSplitStrateogy extends SplitStrateogy{
    float performSplit(float amount, int users, String[] splitValues);
}
