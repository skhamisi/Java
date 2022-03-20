public class Student {

    String name;
    String address;
    double gpa;
    
    public Student(String name, String address, double gpa){

        this.name = name;
        this.address = address;
        this.gpa = gpa;
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

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + "\n" +
        "Address: " + this.getAddress() + "\n" +
        "GPA: " + this.getGpa();
    }
}
