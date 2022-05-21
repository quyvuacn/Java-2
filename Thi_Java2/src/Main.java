import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        ListStudent listStudent = new ListStudent();

        int sl;
        do {
            System.out.println("Quản lí sinh viên");
            System.out.println("Mời bạn nhập lựa chọn bấm 5 để thoát");
            System.out.println("1.Thêm sinh viên vào danh sách");
            System.out.println("2.Sửa sinh viên trong danh sách");
            System.out.println("3.Hiển thị hồ sơ học sinh trong danh sách");
            System.out.println("4.Lưu danh sách đã thêm");
            System.out.println("5.Thoát");
            sl = in.nextInt();
            switch (sl){
                case 1:
                    listStudent.addStu();
                    break;
                case 2:
                    listStudent.updateStu();
                    break;
                case 3:
                    listStudent.display();
                    break;
                case 4:
                    listStudent.saveStu();
                    break;
                default:


            }

        } while (sl <5 && sl>=1);

    }
}
