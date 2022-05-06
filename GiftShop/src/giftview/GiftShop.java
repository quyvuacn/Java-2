package giftview;

import giftcontroller.GiftController;

import java.sql.SQLException;

public class GiftShop {
    public static void main(String[] args) {
        String url = "";
        String user = "root";
        String password = "";

        try{
            GiftController controller = new GiftController(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
