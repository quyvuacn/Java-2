import java.util.ArrayList;
import java.util.List;

/*
Author : Quy Vu
*/
public class SearchElement {
    public static void main(String[] args) {
        Student student1= new Student(1,"Vũ Viết Quý","T2109M");
        Student student2= new Student(2,"Tạ Duy Linh","T2109M");
        Student student3= new Student(3,"Nguyễ Đắc Dũng","T2109M");
        Student student4= new Student(4,"Nguyễn Quốc Anh","T2109M");

        /**
         * Tạo 1 list sinh viên
         */
        List<Student> BigClass = new ArrayList<>();
        BigClass.add(student1);
        BigClass.add(student2);
        BigClass.add(student3);
        BigClass.add(student4);
/**
 * contains(obj) : Kiểm tra xem phần tử có tồn tại trong List không. Có trả về true. Không có trả về false
 */
        BigClass.contains(student1); // true
        BigClass.contains(new Student(5,"Vũ Viết Sơn","T2108M")); //false
/**
 * indexOf(obj) : Tìm lần xuất hiện đầu tiên của đối tượng trong list. Nếu không có trả về -1
 */
        int index = BigClass.indexOf(new Student(5,"Vũ Viết Sơn","T2108M"));
        System.out.println(index);//-1
/**
 * lastIndexOf(obj) : Tìm lần xuất hiện cuối cùng của đối tượng trong list. Nếu không có trả về -1
 */
        index = BigClass.lastIndexOf(new Student(5,"Vũ Viết Sơn","T2108M"));
        System.out.println(index);//-1

    }
}
