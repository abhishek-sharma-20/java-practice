package com.vishal_practice.factory;

public class DBConnectionFactory {
    static DBConnection getDBConnection(String dbName) throws FactoryException {
        DBConnection dbConnection ;
        switch (dbName){
        case "SQL" : dbConnection = new SQLConnection();
            break;
        case "H2": dbConnection = new H2DBConnection();
            break;
        default: throw new FactoryException("Invalid DB");
        }
        return dbConnection;
    }
}
/*
Factory Pattern
GC how and when it works
When can we have out of heap memory error
How static variable work and how they are stored
Memories in JVM
How multi threading work
cna we use multithreading in a single thread cpu
how to troubleshoot out of heap memory error
 */
