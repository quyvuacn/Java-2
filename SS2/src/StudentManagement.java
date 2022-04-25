import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Author : Quy Vu
*/
public class StudentManagement {
    private List<Student> studentList;
    private static Scanner in = new Scanner(System.in);

    public StudentManagement() {
        this.studentList = new ArrayList<>();
    }

    public void getStudentList() {
        for (Student stu: studentList) {
            System.out.println("RollNo("+stu.getRollNo()+"): "+stu.getFullName());
        }
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
        if(studentList.stream().allMatch(student -> !student.getRollNo().equals(rollNo))){
                    System.out.println("Nhap fullName sv dạng chuỗi");
                    fullName = in.next();
                    System.out.println("Nhap address sv dạng chuỗi");
                    address = in.next();
                    System.out.println("Nhap email sv dạng chuỗi");
                    email = in.next();
                    System.out.println("Nhap ngay sinh sv dạng chuỗi");
                    DBO = in.next();
                    System.out.println("Nhap status sv dạng số");
                    status = in.nextInt();
                    Student stu = new Student(rollNo,fullName,address,email,DBO,status);
                    studentList.add(stu);
                    System.out.println("Thêm sinh viên thành công");
        }else {
            System.out.printf("Sinh viên đã tồn tại");
        }

    }

    public void removeStudent(){
        System.out.println("Xóa học sinh");
        System.out.println("Mời bạn nhập rollNo:");
        String rollNo = in.next();
        if(studentList.stream().anyMatch(student -> student.getRollNo().equals(rollNo))){
            for (Student student : studentList) {
                if(student.getRollNo().equals(rollNo)){
                    studentList.remove(student);
                    System.out.printf("Xóa sinh viên thành công");
                    break;
            }
        }
        }else {
            System.out.printf("Sinh viên đã tồn tại");
        }
    }

    public void sortStudent(){
        studentList.sort((stu1,stu2)->stu1.getFullName().compareTo(stu2.getFullName()));
        getStudentList();
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

    public void searchStudent(){
        System.out.println("Chọn tìm kiếm học sinh theo:");
        System.out.println("1.RollNo");
        System.out.println("2.Tên");
        int selection = in.nextInt();
        System.out.println("Nhập nội dung tìm kiếm");
        String key = in.next();
        switch (selection){
            case 1:
                    for (Student student:studentList) {
                        if(student.getRollNo().contains(key)){
                            System.out.println("RollNo("+student.getRollNo()+") "+student.getFullName());
                        }
                    }
                break;
            case 2:
                    for (Student student:studentList) {
                        if(student.getFullName().contains(key)){
                            System.out.println("RollNo("+student.getRollNo()+") "+student.getFullName());
                        }
                    }

                    break;
            default:
                System.out.println("Nhập sai");
        }

    }


}
