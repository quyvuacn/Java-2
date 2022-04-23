import javax.swing.*;

/*
Author : Quy Vu
*/
public class TestManagement{
    public static void main(String args[]) {
        Student student1 = new Student("01","quý","Thái Bình","vuvietquyacn@gmail.com","09/01/2003",1);
        StudentManagement studentManagement = new StudentManagement();

        studentManagement.addStudent(student1);
        System.out.println(studentManagement.getStudentList());
        studentManagement.setStudent();
        System.out.println(student1);

    }

}