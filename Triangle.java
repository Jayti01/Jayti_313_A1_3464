
public class Triangle {
    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public double calculatePerimeter() {
        double sideAB = calculateDistance(pointA, pointB);
        double sideBC = calculateDistance(pointB, pointC);
        double sideCA = calculateDistance(pointC, pointA);
        return sideAB + sideBC + sideCA;
    }

    public String getType() {
        double sideAB = calculateDistance(pointA, pointB);
        double sideBC = calculateDistance(pointB, pointC);
        double sideCA = calculateDistance(pointC, pointA);

        if (sideAB == sideBC && sideBC == sideCA) {
            return "Equilateral";
        } else if (sideAB == sideBC || sideBC == sideCA || sideCA == sideAB) {
            return "Isosceles";
        } else {
            return "Unknown";
        }
    }

    public boolean isPointInside(Point p) {
        double areaABC = calculateArea(pointA, pointB, pointC);
        double areaPAB = calculateArea(p, pointA, pointB);
        double areaPBC = calculateArea(p, pointB, pointC);
        double areaPCA = calculateArea(p, pointC, pointA);

        return areaPAB + areaPBC + areaPCA == areaABC;
    }

    private double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }

    private double calculateArea(Point p1, Point p2, Point p3) {
        return 0.5 * Math.abs((p1.getX() * (p2.getY() - p3.getY()) + p2.getX() * (p3.getY() - p1.getY()) + p3.getX() * (p1.getY() - p2.getY())));
    }
}
