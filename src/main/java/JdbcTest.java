import java.sql.*;

public class JdbcTest {
    static String url = "jdbc:mysql://localhost:3306/Testbd";
    static String user = "root";
     static String password = "root12";
    public static void main(String[] args) throws Exception {

    // Load MySQL JDBC driver
    Class.forName("com.mysql.cj.jdbc.Driver");

    // Connect to database
    try (Connection con = DriverManager.getConnection(url, user, password);

         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM Student1")) {

//        System.out.println("Connection Successful!");

        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
