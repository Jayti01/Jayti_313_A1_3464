import java.util.Scanner;

public class Geometry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of triangles: ");
        int numTriangles = scanner.nextInt();
        Triangle[] triangles = new Triangle[numTriangles];

        for (int i = 0; i < numTriangles; i++) {
            System.out.println("Enter coordinates for Triangle " + (i + 1) + ":");
            System.out.print("Enter x-coordinate for Point A: ");
            double ax = scanner.nextDouble();
            System.out.print("Enter y-coordinate for Point A: ");
            double ay = scanner.nextDouble();
            System.out.print("Enter x-coordinate for Point B: ");
            double bx = scanner.nextDouble();
            System.out.print("Enter y-coordinate for Point B: ");
            double by = scanner.nextDouble();
            System.out.print("Enter x-coordinate for Point C: ");
            double cx = scanner.nextDouble();
            System.out.print("Enter y-coordinate for Point C: ");
            double cy = scanner.nextDouble();

            Point pointA = new Point(ax, ay);
            Point pointB = new Point(bx, by);
            Point pointC = new Point(cx, cy);

            triangles[i] = new Triangle(pointA, pointB, pointC);
        }

        System.out.println("Triangle Perimeters and Types:");
        for (int i = 0; i < numTriangles; i++) {
            double perimeter = triangles[i].calculatePerimeter();
            String triangleType = triangles[i].getType();
            System.out.println("Triangle " + (i + 1) + " - Perimeter: " + perimeter + ", Type: " + triangleType);
        }

        System.out.print("Enter x-coordinate for the point: ");
        double px = scanner.nextDouble();
        System.out.print("Enter y-coordinate for the point: ");
        double py = scanner.nextDouble();
        Point userPoint = new Point(px, py);

        for (int i = 0; i < numTriangles; i++) {
            if (triangles[i].isPointInside(userPoint)) {
                System.out.println("Point is inside Triangle " + (i + 1));
            } else {
                System.out.println("Point is not inside Triangle " + (i + 1));
            }
        }

        scanner.close();
    }
}
