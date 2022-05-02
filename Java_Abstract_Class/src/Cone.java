final class Cone extends Shape { 
    
    private final double pi = Math.PI;

    public Cone(double radius, double height) {
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
        surfaceArea = pi * radius * (radius + Math.sqrt((height * height) + Math.pow(radius, 2)));
        return surfaceArea;
    }

    double volume() {
        volume = pi * Math.pow(radius, 2) * (height / 3.0);
        return volume;
    }

    @Override
    public String toString() {
        return "Cone Surface Area is: " +
         String.format("%.2f", this.surfaceArea()) +
        " || " +
        "Cone Volume is: " + String.format("%.2f", this.volume());
    }
}
