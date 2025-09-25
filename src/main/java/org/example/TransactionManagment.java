package org.example;

import java.sql.Connection;
import java.sql.*;

public class TransactionManagment {
//    public static void showdata() throws SQLException {
//        try {
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM Account");
//
////        System.out.println("Connection Successful!");
//
//            while (rs.next()) {
//                System.out.println(rs.getInt("AccNO"));
//                System.out.println(rs.getDouble("Balance"));
//                System.out.println(rs.getInt("Amount"));
//            }
//        }catch(SQLException e){
//            System.out.println(e);
//        }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/userDb";
        String user = "root";
        String password = "root12";
        String sql="Update Account set Balance =Balance-? where AccNO=?";
        String depostit="update Account set Balance =Balance +? where AccNO=?";
        try {
//
            Connection con = DriverManager.getConnection(url, user, password);

            con.setAutoCommit(false);

            try {
                PreparedStatement withdraw = con.prepareStatement(sql);
                PreparedStatement depositst = con.prepareStatement(depostit);
                withdraw.setDouble(1, 500.00);
                withdraw.setInt(2, 123);

                depositst.setDouble(1, 500.00);
                depositst.setInt(2, 124);
                withdraw.executeUpdate();
                depositst.executeUpdate();
                con.commit();
                con.close();
                System.out.println("transaction succesfully");

//            String sql="Update Account set balance =balance-? where AccNo=?";
            } catch (SQLException e) {
                con.rollback();
                System.out.println(e+ "transaction failed");
            }
            finally {
                if(con!=null) con.close();
                System.out.println("database closed succesfully");
            }
        }catch(SQLException e){
            System.out.println(e);
            }

    }
}
