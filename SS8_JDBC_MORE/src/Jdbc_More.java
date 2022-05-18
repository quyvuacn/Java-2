/*
Author : Quy Vu
*/
import java.sql.*;
import java.util.Arrays;

public class Jdbc_More {
    static  Connection conn;
    public static void main(String[] args) throws SQLException {

        try{
            String url = "jdbc:mysql://localhost:3306/my_music" ;
            String user = "root";
            String password = "";

            conn = DriverManager.getConnection(url,user,password);
            /**
             * setAutoCommit :  mặc định sẽ là true. Chạy xong execute thì commit luôn
             */

            conn.setAutoCommit(false);

            PreparedStatement psSelect = conn.prepareStatement("select * from music where id = ?");
            psSelect.setInt(1,3);
            ResultSet resultSet = psSelect.executeQuery();
            while (resultSet.next()){
                System.out.println(
                    resultSet.getInt("id")+","+
                    resultSet.getString("name")+","+
                    resultSet.getString("author")+","+
                    resultSet.getString("year")
                    );
            }

            /**
             * PreparedStatement
             */

            PreparedStatement psInsert = conn.prepareStatement("INSERT INTO music(name,author,year) values(?,?,?)");
            psInsert.setString(1,"Người lạ ơi");
            psInsert.setString(2,"Karik");
            psInsert.setString(3,"2020-12-12");
            psInsert.executeUpdate();
            conn.commit();

            PreparedStatement psUpdate = conn.prepareStatement("UPDATE music SET year = ? WHERE id = ?");
            psUpdate.setString(1,"2020-12-12");
            psUpdate.setInt(2,2);
            psUpdate.executeUpdate();
            conn.commit();

            PreparedStatement psDelete = conn.prepareStatement("DELETE FROM music WHERE id = ?");
            psDelete.setInt(1,2);
            psDelete.executeUpdate();
            conn.commit();

            /**
             * Batch Processing : Thực thi nhiều câu lệnh cùng lúc
             */

            Statement stm = conn.createStatement();
            stm.addBatch("INSERT INTO music(name,author,year) values('Đau vậy đủ rồi','Karik','2020-11-11')");
            stm.addBatch("INSERT INTO music(name,author,year) values ('Từng là tất cả','Karik','2019-11-11') , ('Cạn cả nước mắt','Karik','2018-11-11')");
            int[] returnCode = stm.executeBatch();
            System.out.println("returnCode: " + Arrays.toString(returnCode));
            conn.commit();

            // psInsert = conn.prepareStatement("INSERT INTO music(name,author,year) values(?,?,?)")
            psInsert.setString(1,"OK");
            psInsert.setString(2,"Binz");
            psInsert.setString(3,"2019-03-03");
            psInsert.addBatch();

            psInsert.setString(1,"Sao cũng được");
            psInsert.setString(2,"Binz");
            psInsert.setString(3,"2019-03-03");
            psInsert.addBatch();

            returnCode = psInsert.executeBatch();
            System.out.println("returnCode: " + Arrays.toString(returnCode));
            conn.commit();


            resultSet = stm.executeQuery("SELECT * FROM music");
            ResultSetMetaData resultMD = resultSet.getMetaData();
            int countRow = resultMD.getColumnCount();
            /**
             * getColumnName : Trả về tên cột
             */
            for (int i=1;i<= countRow; ++i){
                System.out.printf("%-30s", resultMD.getColumnName(i));
            }
            System.out.println();
            /**
             * getColumnClassName : Trả về kiểu dữ của cột
             */
            for (int i=1;i<= countRow; ++i){
                System.out.printf("%-30s",
                        "("+resultMD.getColumnClassName(i)+")");
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= countRow; ++i) {
                    System.out.printf("%-30s", resultSet.getString(i));
                }
                System.out.println();
            }


        } catch (SQLException e) {
            conn.rollback();
            System.err.println(e);
        }
    }
}
