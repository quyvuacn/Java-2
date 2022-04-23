/*
Author : Quy Vu
*/
public class Student {
    private String rollNo,fullName,address,email;
    private String DBO; //dd/MM/yyyy
    private int Status;

    public Student(String rollNo, String fullName, String address, String email, String DBO, int status) {
        this.rollNo = rollNo;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.DBO = DBO;
        Status = status;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getDBO() {
        return DBO;
    }

    public int getStatus() {
        return Status;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDBO(String DBO) {
        this.DBO = DBO;
    }

    public void setStatus(int status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo='" + rollNo + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", DBO='" + DBO + '\'' +
                ", Status=" + Status +
                '}';
    }
}
