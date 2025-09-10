package org.example;

import java.sql.*;

public class TransactionData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/userDb";
        String user = "root";
        String password = "root12";

        try {
//
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Account");

//        System.out.println("Connection Successful!");

            while (rs.next()) {
                System.out.println(rs.getInt("AccNO"));
                System.out.println(rs.getDouble("Balance"));
//                System.out.println(rs.getInt("Amount"));
            }
            System.out.println("done successfully");
        }catch(SQLException e){
            System.out.println(e);
        }

        }

        }

