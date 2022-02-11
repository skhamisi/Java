
public class AutoMobile {

    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;
    private int id = 0;

    // AutoMobile Object Constructor
    public AutoMobile(String make, String model, String color, int year, int mileage, int id) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
        this.id = id;
    }
    
    public String GetMake() {
        return make;
    }
    public void SetMake(String make) {
        this.make = make;
    }

    public String GetModel() {
        return model;
    }
    public void SetModel(String model) {
        this.model = model;
    }

    public String GetColor() {
        return color;
    }
    public void SetColor(String color) {
        this.color = color;
    }

    public int GetYear() {
        return year;
    }
    public void SetYear(int year) {
        this.year = year;
    }

    public int GetMileage() {
        return mileage;
    }
    public void SetMileage(int mileage) {
        this.mileage = mileage;
    }

    public int GetID() {
        return id;
    }
    public void SetID(int id) {
        this.id = id;
    }

    // Overrides toString() to return values of arrayList
    @Override
    public String toString() {
       return this.GetID() + "   " + this.GetMake() + "  " + this.GetModel() + "  " + this.GetColor()+ "  " + this.GetYear() + "  " + this.GetMileage() + " mi.";
    }
}