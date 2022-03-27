public class Student {

    String name;
    String address;
    double rollno;
    
    public Student(double rollno, String name, String address){

        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    public double getRollNo() {
        return rollno;
    }

    public void setRollNo(double rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + "\n" +
        "Address: " + this.getAddress() + "\n" +
        "Roll Number: " + this.getRollNo();
    }
}