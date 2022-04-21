import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
Author : Quy Vu
*/
public class SortArrList {
    public static void main(String[] args) {
        List<Integer> listNum = new ArrayList<>();
        listNum.add(5);
        listNum.add(4);
        listNum.add(6);
        listNum.add(8);
        listNum.add(1);
        listNum.add(2);

        List<Integer> listNum2  = listNum;
/**
 * Collections.sort : Sắp xếp mảng theo thứ tự tăng dần
 * Collections.reverse: Sắp xếp mảng theo thứ tự giảm dần
 */
        System.out.println(listNum);
        Collections.sort(listNum);
        System.out.println(listNum);
        Collections.reverse(listNum);
        System.out.println(listNum);
/**
 * sort(): đổi chỗ nếu trả về duong,còn lại thì không
 * compareTo() : trả về 0,âm hoặc dương bằng việc so sánh num1 với num2
 */
        System.out.println(listNum2);
        listNum2.sort( (num1,num2) -> num1.compareTo(num2));
        System.out.println(listNum2);




    }
}
