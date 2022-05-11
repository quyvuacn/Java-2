import java.sql.*;

/*
Author : Quy Vu
*/
public class JdbcSelectTest {
    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
            String user = "admin_ebook";
            String password = "123456";
            Connection connection = DriverManager.getConnection(url,user,password);
            System.out.println("connect successfully!\n");

            Statement stmt = connection.createStatement();
            String strSelect = "select title, price, qty from books";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println(rset);
            System.out.println("The records selected are:");
            int rowCount = 0;
            while(rset.next()) {
                String title = rset.getString("title");
                double price = rset.getDouble("price");
                int    qty   = rset.getInt("qty");
                System.out.println(title + ", " + price + ", " + qty);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);
            connection.close();
            System.out.println("\nClosed");
        } catch (SQLException e) {
            System.out.println("Truy vấn không thành công");
            System.out.println(e.getErrorCode());
        }
    }
}
