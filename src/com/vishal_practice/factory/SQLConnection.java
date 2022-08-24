package com.vishal_practice.factory;

public class SQLConnection  implements  DBConnection{
    @Override public void connect() {
        System.out.println("SQL DB Connection created");
    }
}
