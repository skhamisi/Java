final class Cylinder extends Shape {

    private final double pi = Math.PI;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

   
    double surfaceArea() {
        surfaceArea = (2.0 * pi * radius * height) + (2.0 * pi * Math.pow(radius, 2));
        return surfaceArea;
    }
    
    double volume() {
        volume = height * pi * Math.pow(radius, 2);
        return volume;
    }

    @Override
    public String toString() {
        return "Cylinder Surface Area is: " + String.format("%.2f", this.surfaceArea()) +
        " || " +
        "Cylinder Volume is: " + String.format("%.2f", this.volume());
    }
}
