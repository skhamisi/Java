public class Student {

    String name;
    String address;
    int rollno;
    
    public Student(int rollno, String name, String address) {

        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    public int getRollNo() {
        return rollno;
    }

    public void setRollNo(int rollno) {
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