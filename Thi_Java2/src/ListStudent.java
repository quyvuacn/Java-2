import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import  java.sql.*;

public class ListStudent {
    private static Connection conn;
    private Scanner in = new Scanner(System.in);
    private ArrayList<Student> ListStudent;
    public ListStudent(){
        ListStudent = new ArrayList<Student>();
    }
    public void addStu(){
        System.out.println("Nhập mã sinh viên");
        String ID = in.nextLine();
        System.out.println("Nhập tên sinh viên");
        String name = in.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = in.nextLine();
        System.out.println("Nhập phone");
        String phone = in.nextLine();
        Student student = new Student(ID,name,address,phone);
        ListStudent.add(student);
    }

    public void updateStu(){
        System.out.println("Nhập ID sinh viên cần chỉnh sửa");
        String ID = in.nextLine();
        if(ListStudent.stream().anyMatch(student -> student.getID().equals(ID))){
            for (Student stu:ListStudent) {
                if(stu.getID().equals(ID)){
                    System.out.println("Mời bạn nhập lựa chọn");
                    System.out.println("1.Để sửa địa chỉ");
                    System.out.println("2.Để sửa phone");
                    int sl = in.nextInt();
                    switch (sl){
                        case 1 :
                            System.out.println("Mời nhập địa chỉ mới của sinh viên");
                            in.nextLine();
                            String address = in.nextLine();
                            stu.setAddress(address);
                            System.out.println("Sửa thành công");
                            break;
                        case 2:
                            System.out.println("Mời nhập phone mới của sinh viên");
                            in.nextLine();
                            String phone = in.nextLine();
                            stu.setPhone(phone);
                            System.out.println("Sửa thành công");
                            break;
                        default:
                            System.out.println("Nhập sai lựa chọn");
                            break;
                    }
                }
            }
        }else {
            System.out.println("Sinh viên không tồn tại trong bộ sưu tập");
        }
    }

    public void display(){
        System.out.printf("%-30s%-30s%-30s%-30s","ID","Name","Address","Phone");
        System.out.println();
        for (Student student: ListStudent) {
            System.out.printf("%-30s%-30s%-30s%-30s",student.getID(),student.getName(),student.getAddress(),student.getPhone());
            System.out.println();
        }
    }

    public void saveStu() throws SQLException {
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "");
            conn.setAutoCommit(false);
            String insert = "insert into student(ID, name , address, phone) values (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(insert);
            for (Student stu:ListStudent) {
                System.out.println(stu.getID());
                ps.setString(1,stu.getID());
                ps.setString(2,stu.getName());
                ps.setString(3,stu.getAddress());
                ps.setString(4,stu.getPhone());
                ps.addBatch();
            }
            int[] count = ps.executeBatch();
            int sum = 0;
            for (int i: count) {
                sum += i;
            }
            conn.commit();
            System.out.println("Số bản ghi được thêm thành công: " + sum);
        }
        catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
            System.out.println("Thêm dữ liệu thất bại");

        }

    }


}
