public class Student {
    private String ID,name,address,phone;

    public Student(String ID, String name, String address, String phone) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
