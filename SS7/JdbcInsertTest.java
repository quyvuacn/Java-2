package Task07_Insert_and_Delete;

import java.sql.*;

public class JdbcInsertTest {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root",
                        "");
                Statement stmt = conn.createStatement();
        ){
            // Delete
            String sqlDelete = "delete from books where id >= 3000 and id < 4000";
            System.out.println("The SQL statement is: " + sqlDelete + "\n");
            int countDaleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDaleted + " records deleted.\n");

            // Insert
            String sqlInsert = "insert into books values (3001,'Gone Fishing','Kumar',11.11,11)";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " record inserted. \n");

            // Insert multiple records
            sqlInsert = "insert into books values "
                    + "(3002,'Gone Fishing 2', 'Kumar',22.22,22),"
                    + "(3003,'Gone Fishing 3', 'Kumar',33.33,33)";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " record inserted. \n");

            // Insert a partial record
            sqlInsert = "insert into books (id, title, author) values (3004,'Fishing 101', 'Kumar')";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " record inserted. \n");

            // Issue a SELECT to check the changes
            String strSelect = "select * from books";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()) {
                System.out.println(rset.getInt("id") + ","
                                 + rset.getString("author") + ","
                                 + rset.getString("title") + ","
                                 + rset.getDouble("price") + ","
                                 + rset.getInt("qty"));
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
