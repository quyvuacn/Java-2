package user;

import java.util.ArrayList;

public class Customer {
    private String CusID,CusName;
    private ArrayList<String> ListTrend;
    public Customer(){
        ListTrend = new ArrayList<>();
    }

    public String getCusID() {
        return CusID;
    }

    public void setCusID(String cusID) {
        CusID = cusID;
    }

    public String getCusName() {
        return CusName;
    }

    public void setCusName(String cusName) {
        CusName = cusName;
    }

    public ArrayList<String> getListTrend() {
        return ListTrend;
    }

    public void addListTrend(String trend) {
        ListTrend.add(trend);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CusID='" + CusID + '\'' +
                ", CusName='" + CusName + '\'' +
                '}';
    }
}
