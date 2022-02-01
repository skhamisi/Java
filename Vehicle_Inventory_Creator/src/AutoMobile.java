
public class AutoMobile {

    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;
    private int index = 0;

    // AutoMobile Object Constructor
    public AutoMobile(String make, String model, String color, int year, int mileage, int index) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
        this.index = index;
    }

    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

    // Overrides toString() to return values of arrayList
    @Override
    public String toString() {
       return this.getIndex() + "   " + this.getMake() + "  " + this.getModel() + "  " + this.getColor()+ "  " + this.getYear() + "  " + this.getMileage() + " mi.";
    }
}