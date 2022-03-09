public class ShapeArray {
    public static void main(String[] args) throws Exception {
        
        Object[] shapeArray = {new Sphere(8), new Cylinder(9, 3), new Cone(5, 4)};

        for (Object i : shapeArray) {
            System.out.println(i + "\n");
        }
    }
}
