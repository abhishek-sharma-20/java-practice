package com.vishal_practice.factory;

public class FactoryClient {
    public static void main(String[] args) {
        try {
            DBConnection dbConnection = DBConnectionFactory.getDBConnection("SQL");
            dbConnection.connect();
            dbConnection = DBConnectionFactory.getDBConnection("H2");
            dbConnection.connect();
            dbConnection = DBConnectionFactory.getDBConnection("H3");
        }catch (FactoryException exception){
            System.out.println("Error : "+exception.getLocalizedMessage());
        }

    }
}
