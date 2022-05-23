import cart.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Convert {

    public static ArrayList<Product> toArrayList(ResultSet resultSet) throws SQLException {
        ArrayList<Product> result = new ArrayList<>();
        while (resultSet.next()){
            Product newProduct = new Product();
            newProduct.setProductID(resultSet.getString(1));
            newProduct.setTypeID(resultSet.getString(2));
            newProduct.setProductName(resultSet.getString(3));
            newProduct.setQuantity(resultSet.getInt(4));
            newProduct.setPrice(resultSet.getInt(5));
            result.add(newProduct);
        }
        return result;
    }

}
