package bookview;

import java.sql.*;

public class BookView {
    public String bookNew(){
        return "SELECT * FROM `booknew`";
    }
    public String bookTop(){
        return "SELECT * FROM `booktop`";
    }

}
