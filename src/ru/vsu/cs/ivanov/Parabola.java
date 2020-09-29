package ru.vsu.cs.ivanov;

public class Parabola {
    double x0; // x coordinate for vertex of the parabola
    double y0; // y coordinate for vertex of the parabola
    double a; // the coefficient of the parabola

    public Parabola(double x0, double y0, double a) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    public boolean isParabola(double x, double y) {
        return (a * Math.pow(y - y0, 2) + x0) >= x;
    }
}
