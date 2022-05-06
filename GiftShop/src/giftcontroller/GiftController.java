package giftcontroller;

import java.sql.*;

public class GiftController {
    private Connection connection;

    public GiftController(String url,String user,String password) throws SQLException {
       connection = DriverManager.getConnection(url,user,password);
    }

    private Statement getStmt() throws SQLException {
        Statement stmt = connection.createStatement();
        return  stmt;
    }

    public void SELECT() throws SQLException {
        String strSelect = "select * from books";
        System.out.println("The SQL statement is: " + strSelect + "\n");
        ResultSet rset = getStmt().executeQuery(strSelect);
        while(rset.next()) {   // Move the cursor to the next row
            System.out.println(rset.getInt("id") + ", "
                    + rset.getString("name") + ", "
                    + rset.getDouble("price") + ", "
                    + rset.getInt("qty"));
        }
    }

    public void INSERT(Integer id,String name,float price,Integer qty) throws SQLException {
        String  sqlInsert = "insert into books (id, title, author) values ('"+id+","+name+","+price+","+qty+"')";
        int countInserted = getStmt().executeUpdate(sqlInsert);
        System.out.println(countInserted + " records inserted.\n");
    }

    public void DELETE(Integer id) throws SQLException {
        String sqlDelete = "delete from books where id =" + id;
        int countDeleted = getStmt().executeUpdate(sqlDelete);
        System.out.println(countDeleted + " records deleted.\n");
    }


}
