package org.example;
import java.sql.*;
import java.util.Scanner;

public class CrudOperation {
    Scanner sc=new Scanner(System.in);
    static String url = "jdbc:mysql://localhost:3306/Testbd";
    static String user = "root";
    static String password = "root12";
     Connection con=null;
    public void createconnection(){
        try{
            con=DriverManager.getConnection(url,user,password);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public void addStudent(){
        this.createconnection();
        try{
            String sql="Insert into Student1 Values(?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            for(int i=1;i<=3;i++){
                System.out.println("enter Name");
             String names=sc.next();
                ps.setInt(1,i+101);
                ps.setString(2,names);
                ps.setInt(3,i+20);
                ps.setString(4,"A");
                ps.addBatch();
            }
            int arr[]=ps.executeBatch();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public void showdata(){
        try{
         Statement stmt  = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Student1");

//        System.out.println("Connection Successful!");

            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("age"));
            }
    }
        catch(SQLException e){
            System.out.println(e );
        }
    }
    public static void main(String[] args) {
        CrudOperation c=new CrudOperation();
        c.addStudent();
        c.showdata();


    }
}
