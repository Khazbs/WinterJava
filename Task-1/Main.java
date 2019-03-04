import java.util.Scanner;

class Main {
    public static class Point {
        double x;
        double y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    public static double distanceBetweenPoints(Point a, Point b) {
        double dx = b.x - a.x;
        double dy = b.y - a.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    public static double areaOfTriangle(Point a, Point b, Point c) {
        double ab = distanceBetweenPoints(a, b);
        double bc = distanceBetweenPoints(b, c);
        double ca = distanceBetweenPoints(c, a);
        double p = (ab + bc + ca) / 2;
        return Math.sqrt(p * (p - ab) * (p - bc) * (p - ca));
    }
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            Point a = new Point(in.nextDouble(), in.nextDouble());
            Point b = new Point(in.nextDouble(), in.nextDouble());
            Point c = new Point(in.nextDouble(), in.nextDouble());
            System.out.println(areaOfTriangle(a, b, c));
        }
    }
}

