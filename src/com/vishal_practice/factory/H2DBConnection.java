package com.vishal_practice.factory;

public class H2DBConnection  implements DBConnection{
    @Override public void connect() {
        System.out.println("H2 DB Connection created");
    }
}
