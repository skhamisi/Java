public class Student implements Comparable<Student>{

    protected String name;
    protected String address;
    protected Integer rollno;
    
    public Student(Integer rollno, String name, String address) {

        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    public Integer getRollNo() {
        return rollno;
    }

    public void setRollNo(Integer rollno) {
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

    @Override
    public int compareTo(Student s) {
        return this.getRollNo().compareTo(s.getRollNo());
    }
}