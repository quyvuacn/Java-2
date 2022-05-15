import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

/*
Author : Quy Vu
*/
public class Crud {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
           String url = "jdbc:mysql://localhost:3306/my_music?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC" ;
           String user = "root";
           String password = "";

           Connection conn = DriverManager.getConnection(url,user,password);
           Statement stm = conn.createStatement();
            /**
             * Select author
             */
            System.out.println("Liệt kê các bài hát của ");
            String nameMusic = in.nextLine();
            String strSelect = "select * from music where author like '%"+nameMusic+"%'";
            ResultSet rset = stm.executeQuery(strSelect);
            ResultSetMetaData rsetMD = rset.getMetaData();
            int numCol = rsetMD.getColumnCount();
            for(int i=1;i<=numCol;i++){
                System.out.printf("%-30s", rsetMD.getColumnName (i));
            }
            System.out.println("\n");
            while (rset.next()) {
                for(int i=1;i<=numCol;i++){
                    System.out.printf("%-30s", rset.getString(i));
                }
                System.out.println("\n");

            }

            /**
             * Search music name
             */
            System.out.println("\nLiệt kê các bài hát có cụm từ ");
            String key = in.nextLine();
            strSelect = "select * from music where name like '%"+key+"%'";
            rset = stm.executeQuery(strSelect);
            while (rset.next()) {
                System.out.println(
                        rset.getString("name") + ","
                                + rset.getString("author") + ","
                                + rset.getString("year")
                );
            }
            /**
             * Search music ID
             */
            System.out.println("\nXem bài hát có ID ");
            int keyNum = in.nextInt();
            in.nextLine();
            strSelect = "select * from music where id=" + keyNum  ;
            rset = stm.executeQuery(strSelect);
            while (rset.next()) {
                System.out.println(
                        rset.getString("name") + ","
                                + rset.getString("author") + ","
                                + rset.getString("year")
                );
            }

            /**
             * Insert
             */
            System.out.println("\nThêm dữ liệu");
            System.out.println("\nMời nhập tên bài hát mới:");
            String name = in.nextLine();
            System.out.println("\nMời nhập tên tác giả:");
            String author = in.nextLine();
            System.out.println("Mời nhập ngày sáng tác");
            String date = in.nextLine();
            String sqlInsert = "Insert into music(name,author,year) values('"+name+"','"+author+"','"+date+"')";
            int countRecord = stm.executeUpdate(sqlInsert);
            System.out.println("\nSố bản ghi được thêm vào bảng = " + countRecord);

            /**
             * Delete : id
             */
            System.out.println("Xóa bài hát có Id");
            in.nextLine();
            int id = in.nextInt();
            String sqlDelete = "delete from music where id=" + id;
            countRecord = stm.executeUpdate(sqlDelete);
            System.out.println("\nSố bản ghi đã bị xóa = " + countRecord);
            /**
             * Update : id có ngày sx
             */
            System.out.println("Cập nhật bài hát có Id");
            id = in.nextInt();
            System.out.println("Nhập ngày sx có dạng yyyy-mm-dd");
            date  = in.nextLine();
            String sqlUpdate = "Update music Set year ='"+date+"' where id ="+id;
            countRecord = stm.executeUpdate(sqlUpdate);
            System.out.println("\nSố bản ghi cập nhập thành công = " + countRecord);



        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
