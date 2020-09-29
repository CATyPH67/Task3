package ru.vsu.cs.ivanov;

public class Circle {
    double x0; // x coordinate for center of the circle
    double y0; // y coordinate for center of the circle
    double r; // radius of the circle

    public Circle(double x0, double y0, double r) {
        this.x0 = x0;
        this.y0 = y0;
        this.r = r;
    }

    public boolean isCircle(double x, double y) {
        return (Math.pow(x - x0, 2) + Math.pow(y - y0, 2)) <= Math.pow (r, 2);
    }
}
