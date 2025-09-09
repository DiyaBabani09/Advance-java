import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class UpdateRecord {
    public static void main(String[] args) {

        try {
            Connection con1= DriverManager.
                    getConnection(JdbcTest.url,JdbcTest.user,JdbcTest.password);
             String sql="update Student1 set name=?,age=? where id=?";
            PreparedStatement st=con1.prepareStatement(sql);
            st.setInt(3,1);
            st.setString(1,"Priya");
            st.setInt(2,25);
st.execute();

String sql2="Select * From Student1";
PreparedStatement ps=con1.prepareStatement(sql2);
            ResultSet s=ps.executeQuery();
            while(s.next()){
                System.out.println(s.getInt("id"));
                System.out.println(s.getString("name"));
                System.out.println(s.getInt("age"));
                
            }



        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
