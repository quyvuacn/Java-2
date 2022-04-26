import java.util.Scanner;

/*
Author : Quy Vu
*/
public class TestMenu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Menu menu = new Menu();
        System.out.println("Admin");
        int s;
        do {
            System.out.println("Mời nhập lựa chọn");
            System.out.println("1.Xem menu");
            System.out.println("2.Thêm món vào menu");
            System.out.println("3.Sửa món trong menu");
            System.out.println("4.Xóa món trong menu");
            System.out.println("5.Thoát");
            s = in.nextInt();

            switch (s){
                case 1: menu.getListMenu();
                    break;
                case 2: menu.addDish();
                    break;
                case 3: menu.updateDish();
                    break;
                case 4: menu.removeDish();
                    break;
                default:
                    System.out.println("Thoát thành công");
            }
        } while (s>0 && s<5);
    }
}
