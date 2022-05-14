import java.sql.*;

/*
Author : Quy Vu
*/
public class Crud {
    public static void main(String[] args) {
        try {
           String url = "jdbc:mysql://localhost:3306/my_music?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC" ;
           String user = "root";
           String password = "";

           Connection conn = DriverManager.getConnection(url,user,password);
           Statement stm = conn.createStatement();
            /**
             * Select
             */
            System.out.println("Các bài hát của Sơn Tùng\n");
            String strSelect = "select * from music where author like '%son tung%'";
            ResultSet rset = stm.executeQuery(strSelect);
            while (rset.next()) {
                System.out.println(
                        rset.getInt("id") + ","
                        + rset.getString("name") + ","
                        + rset.getString("author") + ","
                        + rset.getString("year")
                );
            }

            /**
             * Insert
             */
            String sqlInsert = "Insert into music(name,author,year) values('Em gì ơi','Jack','2020-05-05')";
            int countRecord = stm.executeUpdate(sqlInsert);
            System.out.println("\nSố bản ghi được thêm vào bảng = " + countRecord);

            /**
             * Delete
             */
            String sqlDelete = "delete from music where name='Em gì ơi'";
            countRecord = stm.executeUpdate(sqlDelete);
            System.out.println("\nSố bản ghi đã bị xóa = " + countRecord);
            /**
             * Update
             */
            String sqlUpdate = "Update music Set year = '2020-09-02' where name='Em của ngày hôm qua'";
            countRecord = stm.executeUpdate(sqlUpdate);
            System.out.println("\nSố bản ghi cập nhập thành công = " + countRecord);

            /**
             * Search music name
             */
            System.out.println("\nCác bài hát có cụm từ cơn mưa\n");
            strSelect = "select * from music where name like '%con mua%'";
            rset = stm.executeQuery(strSelect);
            while (rset.next()) {
                System.out.println(
                        rset.getString("name") + ","
                        + rset.getString("author") + ","
                        + rset.getString("year")
                );
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
