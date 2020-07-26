package com.study.spring.testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/spring_security_plaintext?useSSL=false";
        String driver = "com.mysql.cj.jdbc.Driver";

        String user = "securitymanager";
        String pass = "securitymanager";

        // get connection to database
        try {

            Class.forName(driver);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            myConn.close();

            System.out.println("Connection success");

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}

