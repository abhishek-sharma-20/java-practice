package com.lld.splitwise;

public class ExactSplitStrategoy implements ComplexSplitStrateogy{
    @Override public float performSplit(float amount, int users, String[] splitValues) {
        return 0;
    }

    @Override public float performSplit(float amount, int users) {
        return 0;
    }
}
