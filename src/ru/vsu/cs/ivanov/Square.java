package ru.vsu.cs.ivanov;

public class Square {
    private double x0; // x coordinate for the left down point of square
    private double y0; // y coordinate for the left down point of square
    private double a; // square side length

    public Square(double x0, double y0, double a) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    public boolean isPointInside(double x, double y) {
        return (x >= x0) && (x <= (x0 + a)) && (y >= y0) && (y <= (y0 + a));
    }
}
