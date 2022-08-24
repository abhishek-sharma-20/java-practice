package com.lld.splitwise;

public class EqualSplitStrategoy implements SplitStrateogy{
    @Override public float performSplit(float amount, int users) {
        return amount/users;
    }
}
