import java.sql.*;

public class AddRecord {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Testbd";
        String user = "root";
        String password = "root12";
        try{
            Connection con= DriverManager.getConnection(url,user,password);
            String sql="Insert into Student1 value(?,?,?,?)";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, 11);
            st.setString(2,"Kajal");
            st.setInt(3,38);
            st.setString(4,"A");
            st.execute();
            System.out.println("record Created");
        }catch(SQLException e){
            System.out.println(e);
        }

    }
}
