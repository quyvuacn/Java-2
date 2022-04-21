import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
Author : Quy Vu
*/
public class ArrayIteration {
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
 * forEach : duyệt các phần tử của List
 */
        for (Student student : BigClass) {
            System.out.println(student);
        }

        BigClass.forEach(element -> {
            System.out.println(element);
        });

/**
 * Duyệt List bằng iterator + while
 * hasNext() : Trả về true nếu còn phần tử tiếp theo. false nếu không còn
 * next() : Trả về phần tử tiếp theo
 */
        Iterator<Student> iterator = BigClass.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
/**
 * ListIterator : cho phép người dùng có thể duyệt qua List theo các chiều ngược xuôi bằng hasNext,hasPrevious,next,previous
 * Iterator thì chỉ có hasNext và next
 */
        ListIterator<Student> listIterator = BigClass.listIterator(BigClass.size());
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }



    }
}
