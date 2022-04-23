import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

/*
Author : Quy Vu
*/
public class StudentManagement {
    private List<Student> studentList;
    private static Scanner in = new Scanner(System.in);

    public StudentManagement() {
        this.studentList = new ArrayList<>();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void addStudent(Student student){
        studentList.add(student);
    }

    public void addStudent(){
        String rollNo;
        String fullName;
        String address;
        String email;
        String DBO;
        int status;

        System.out.println("Thêm sinh viên");
        System.out.println("Nhap rollNo sv dạng chuỗi");
        rollNo = in.next();
        for (Student student: studentList) {
            if(student.getRollNo().equals(rollNo)){
                System.out.println("Sinh viên đã tồn tại.Thêm thất bại");
            }else {
                System.out.println("Nhap fullName sv dạng chuỗi");
                fullName = in.next();
                System.out.println("Nhap fullName sv dạng chuỗi");
                address = in.next();
                System.out.println("Nhap fullName sv dạng chuỗi");
                email = in.next();
                System.out.println("Nhap fullName sv dạng chuỗi");
                DBO = in.next();
                System.out.println("Nhap fullName sv dạng số");
                status = in.nextInt();
                addStudent(new Student(rollNo,fullName,address,email,DBO,status));
                System.out.println("Thêm sinh viên thành công");
            }
        }


    }



    public void setStudent(){

        System.out.println("Mời bạn nhập id sinh viên cần chỉnh sửa");
        String id = in.next();
        boolean check =false;
        Student stu = null;
        /**
         * Kiểm tra sự tồn tại của id
         */
        for (Student student:studentList) {
            if(student.getRollNo().equals(id)){
                check = true;
                stu = student;
                break;
            }
        }

        if(check){
            System.out.println("Mời bạn chọn:");
            System.out.println("1: Thay đổi email");
            System.out.println("2: Thay dổi status");
            System.out.println("3: Thay đổi address");
            int selection = in.nextInt();
            switch (selection){
               case 1 :
                   System.out.println("Mời bạn nhập thay đổi");
                   String email = in.next();
                   for (Student student :studentList) {
                       if(student.equals(stu)){
                           student.setEmail(email);
                       }

                   }
                   break;
                case 2 :
                    System.out.println("Mời bạn nhập thay đổi");
                    int st = in.nextInt();
                    for (Student student :studentList) {
                        if(student.equals(stu)){
                            student.setStatus(st);
                        }

                    }
                    break;

                case 3 :
                    System.out.println("Mời bạn nhập thay đổi");
                    String address = in.next();
                    for (Student student :studentList) {
                        if(student.equals(stu)){
                            student.setAddress(address);
                        }

                    }
                    break;
                default:
                    System.out.println("Bạn đã chọn sai");

            }
        }else {
            System.out.println("ID bạn chọn không tồn tại");
        }

    }


}
