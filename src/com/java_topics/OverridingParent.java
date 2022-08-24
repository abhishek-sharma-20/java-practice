package com.java_topics;

interface Test1{
    void print();
}
interface Test2{
    void print();
}
public class OverridingParent implements Test1,Test2 {

    public static void main(String[] args) {
        OverridingParent overridingParent = new OverridingParent();
        overridingParent.print();
    }

    @Override public void print() {
        System.out.println("Test World");
    }
}
