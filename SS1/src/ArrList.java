import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/*
Author : Quy Vu
*/
public class ArrList {
    public static void main(String[] args) {
        List<String> group = new ArrayList<>();
/**
 * add(value) Thêm phần tử vào cuối list
 * add(index,value) Thêm phần tử vào vị trí index
 */
        group.add("Vũ Viết Quý");
        group.add("Tạ Duy Linh");
        group.add("Nguyễn Đắc Dũng");
        group.add(0,"Nguyễn Quốc Anh");
        System.out.println(group);
/**Class = group*/
//      List<String> Class = group;
        List<String> Class = new ArrayList<>(group);
        System.out.println(Class);
/**
 * addAll(List) : Thêm List truyền vào vào List cần thêm
 * addAll(index,List) : Thêm List truyền vào vào List cần thêm tại vị trí index
 */
        Class.addAll(group);
        System.out.println(Class);
/**
 *get(index) : Lấy ra phần tử đầu tiên trong list group
 * Note :Phần tử đầu tiên trong mảng index=0
 */
        System.out.println(group.get(0));
/**
 * set(index,value) : Đặt lại giá trị của phần từ có index được truyền vào
 */
        group.set(0,"Quốc Anh");
        System.out.println(group.get(0));
        //"Quốc Anh"
/**
 * isEmpty() : Kiểm tra xem List có rỗng không. Nếu có trả về true sau trả về false
 */
        System.out.println(group.isEmpty());
        //false
/**
 * remove(obj) : xóa 1 đối tượng đầu tiên trong List
 * remove(index) : xóa 1 đối tượng có index được truyền
 */
        Class.remove("Nguyễn Quốc Anh");
        Class.remove(1);


        System.out.println(Class);

/**
 * removeAll(collection) : xóa tất cả các phần tử tại trong bộ sư tập được truyền vào
 */
        Class.removeAll(group);
        System.out.println(Class);


/**
 * removeIf(filter) : xóa bỏ các phần tử thỏa mãn filter
 * Ví dụ này là xóa các tên có chiều dài chuỗi > 5
 */

        group.removeIf(element->(element.length()>5));
        System.out.println(group);
/**
 * clear() : Xóa list
 */
        Class.clear();
        System.out.println(Class);
    }
}
