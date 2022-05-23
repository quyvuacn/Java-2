import cart.Product;
import user.Customer;

import java.sql.*;
import java.util.ArrayList;

public class Controller {
    private static PreparedStatement ps;
    private static Connection conn;
    private Customer customer ;
    private ArrayList<Product> ListProduct;
    private ArrayList<Product> Cart;

    public Controller() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "");
        customer = new Customer();
        ListProduct = new ArrayList<>();
        Cart = new ArrayList<>();
    }

    public boolean checkLogin(String user,String passWord) throws SQLException {
        ps = conn.prepareStatement("select * from customer where UserName = ? and PassWords = ?");
        ps.setString(1,user);
        ps.setString(2,passWord);
        ResultSet resultSet = ps.executeQuery();
        if(!resultSet.next()){
            return false;
        }
        customer.setCusID(resultSet.getString(1));
        customer.setCusName(resultSet.getString(2));
        ps = conn.prepareStatement("select * from  trendcustomer where CusID = ?");
        ps.setString(1,customer.getCusID());
        resultSet = ps.executeQuery();
        while (resultSet.next()){
            customer.addListTrend(resultSet.getString(2));
        }
    return true;
    }

    public void GET_Product() throws SQLException {
        ps = conn.prepareStatement("select  * from product where TypeID = ?");
        ps.setString(1,customer.getListTrend().get(1));
        ResultSet resultSet = ps.executeQuery();
        ListProduct = Convert.toArrayList(resultSet);
        System.out.println("Sản phẩm yêu thích");
        for (Product product: ListProduct) {
            System.out.printf("%-10s%-30s%-30s",product.getProductID(),product.getProductName(),product.getPrice());
            System.out.println();
        }
    }

    public void GET_Product(String key) throws SQLException {
        ps = conn.prepareStatement("select  * from product " +
                "join producttype on product.TypeID = producttype.TypeID where TypeName like ?");
        ps.setString(1,"%"+key+"%");
        ResultSet resultSet = ps.executeQuery();
        ListProduct = Convert.toArrayList(resultSet);
        System.out.println("Sản phẩm yêu thích");
        for (Product product: ListProduct) {
            System.out.printf("%-10s%-30s%-30s",product.getProductID(),product.getProductName(),product.getPrice());
            System.out.println();
        }
    }

    public void POST_Cart(String productID,int qty) throws SQLException {
        ps = conn.prepareStatement("insert  into cart(CusID,ProductID,productQty,CartStatus) value (?,?,?,?)");
        ps.setString(1,customer.getCusID());
        ps.setString(2,productID);
        ps.setInt(3,qty);
        ps.setInt(4,1);//1 trong giỏ hàng
        ps.executeUpdate();
    }

    public void PUT_Cart(String productID,int qty) throws SQLException {
        ps = conn.prepareStatement("update cart set productQty = ? where productID = ? and CusID = ?");
        ps.setInt(1,qty);
        ps.setString(2,productID);
        ps.setString(3,customer.getCusID());
        ps.executeUpdate();
    }
    public void DELETE_Cart(String productID) throws SQLException {
        ps = conn.prepareStatement("delete from cart where ProductID = ? and CusID = ?");
        ps.setString(1,productID);
        ps.setString(2,customer.getCusID());
        ps.executeUpdate();
    }

    public void GET_Cart() throws SQLException {
        ps =conn.prepareStatement("select ProductID,TypeID,ProductName,productQty,Price from viewcart where CusID = ?");
        ps.setString(1,customer.getCusID());
        ResultSet resultSet = ps.executeQuery();
        Cart = Convert.toArrayList(resultSet);
        System.out.printf("%-10s%-30s%-20s%-20s%-10s","ID","Name","Price","Quantity","Calc");
        System.out.println();
        int calc = 0;
        for (Product product: Cart) {
            System.out.printf("%-10s%-30s%-20s%-20s%-10s",product.getProductID(),product.getProductName(),product.getPrice(),product.getQuantity(),product.getPrice()*product.getQuantity());
            System.out.println();
            calc+=product.getPrice()*product.getQuantity();
        }
        System.out.println();
        System.out.printf("%-80s%s","Total: ",calc);
        System.out.println();
    }




}
