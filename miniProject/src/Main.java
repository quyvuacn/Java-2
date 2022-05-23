import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            Scanner in = new Scanner(System.in);
            Controller controller = new Controller();
            System.out.println("Chào mừng bạn đến với cửa hàng trực tuyến");
            System.out.println("Đăng nhập");
            System.out.println("Tên tài khoản");
            String username = in.nextLine();
            System.out.println("Mật khẩu");
            String password = in.nextLine();
            if(controller.checkLogin(username,password)){
                System.out.println("Đăng nhập thành công");
                int sl ;
                do {
                    System.out.println("Mời bạn nhập lựa chọn");
                    System.out.println("1.Xem sản phẩm gợi ý");
                    System.out.println("2.Tìm kiếm sản phẩm");
                    System.out.println("3.Thêm sản phẩm vào giỏ hàng");
                    System.out.println("4.Xem giỏ hàng");
                    System.out.println("5.Chỉnh sửa giỏ hàng");
                    System.out.println("6.Thanh toán");
                    System.out.println("7.Thoát");
                    sl= in.nextInt();
                    switch (sl){
                        case 1:
                            controller.GET_Product();
                            break;
                        case 2:
                            System.out.println("Nhập từ khóa tìm kiếm");
                            in.nextLine();
                            String key = in.nextLine();
                            controller.GET_Product(key);
                            break;
                        case 3:
                            System.out.println("Nhập mã sản phẩm");
                            in.nextLine();
                            String ID = in.nextLine();
                            System.out.println("Nhập số lượng");
                            int qty = in.nextInt();
                            try {
                                controller.POST_Cart(ID,qty);
                                System.out.println("Thêm thành công");
                            }catch (SQLException err){
                                System.out.println("Lỗi không thêm được sản phẩm");
                            }
                            break;
                        case 4 :
                            controller.GET_Cart();
                            break;
                        case 5 :
                            System.out.println("Nhập lựa chọn");
                            System.out.println("1.Chỉnh sửa số lượng");
                            System.out.println("2.Xóa sản phẩm trong giỏ hàng");
                            in.nextLine();
                            int sl2 = in.nextInt();
                            if(sl2==1){
                                System.out.println("Nhập mã sản phẩm");
                                in.nextLine();
                                String productID = in.nextLine();
                                System.out.println("Nhập số lượng cần chỉnh sửa");
                                qty = in.nextInt();
                                try {
                                    controller.PUT_Cart(productID,qty);
                                }catch (SQLException err){
                                    System.out.println("Chỉnh sửa thất bại");
                                }
                            }else if(sl2==2){
                                System.out.println("Nhập mã sản phẩm cần xóa");
                                in.nextLine();
                                String productID = in.nextLine();
                                try {
                                    controller.DELETE_Cart(productID);
                                }catch (SQLException err){
                                    System.out.println("Xóa thất bại. Hoặc mã sp không đúng");
                                }
                            }else {
                                System.out.println("Nhập sai lựa chọn");
                            }
                            break;

                        case 6 :
                            break;
                        default:
                            System.out.println("Cảm ơn đã sử dụng dịch vụ");
                            break;

                    }
                }while (sl>=1 && sl<=6);


            }else {
                System.out.println("Sai tài khoản hoặc mật khẩu");
            }



        }catch (SQLException err){
            System.err.println(err);
        }

    }
}
