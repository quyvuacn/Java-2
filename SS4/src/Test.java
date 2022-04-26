import java.util.Scanner;

/*
Author : Quy Vu
*/
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Menu menu = new Menu();
        Customer customer = new Customer(menu);
        int s;
        System.out.println("Chào mừng đên với quán\n");
        customer.getPresentMenu();
        do {
            System.out.println("Mời bạn nhập lựa chọn");
            System.out.println("1.Thêm món");
            System.out.println("2.Xóa món");
            System.out.println("3.Sửa số lượng");
            System.out.println("4.Xem danh sách chọn và tính tiền");
            System.out.println("5.Thoát\n");


            s= in.nextInt();


            switch (s){
                case 1:
                    customer.addDish();
                    break;
                case 2:
                    customer.removeDish();
                    break;
                case 3:
                    customer.updateDish();
                    break;
                case 4:
                    customer.getPickList();
                    System.out.println("Cảm ơn đã sử dụng dịch vụ.Mong bạn sẽ quay lại quán");
                    s=5;
                    break;
                default:
                    s=5;
                    System.out.println("Cảm ơn đã sử dụng dịch vụ.Mong bạn sẽ quay lại quán");
                    break;
            }

        }while (s!=5);





    }
}
