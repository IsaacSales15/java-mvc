package com.sales.test;

import com.sales.DAO.ConnectionDB;

public class ConnectionDBTest {
    public static void main(String args[]){
        ConnectionDB connectionDB = new ConnectionDB();

        connectionDB.getConnection();
    }
}
