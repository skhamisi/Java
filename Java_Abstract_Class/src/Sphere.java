final class Sphere extends Shape {
    
    private double radius;
    private double surfaceArea;
    private double volume;
    private final double pi = Math.PI;

    Sphere(double radius) {
        this.radius = radius;
    }

    double getRadius() {
        return radius;
    }
    void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    double surfaceArea() {
        surfaceArea = 4.0 * pi * Math.pow(radius, 2);
        return surfaceArea;
    }

    @Override
    double volume() {
        volume = (4.0/3.0) * pi * Math.pow(radius, 3);
        return volume;
    }

    @Override
    public String toString() {
       return "Sphere Surface Area is: " + String.format("%.2f", this.surfaceArea()) +
        " || " + 
        "Sphere Volume is: " + String.format("%.2f", this.volume());
    }
}
