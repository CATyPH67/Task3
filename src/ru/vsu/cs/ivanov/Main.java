package ru.vsu.cs.ivanov;

import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Program.printColorForPoint(0, 0);
        Program.printColorForPoint(-4, 1);
        Program.printColorForPoint(1, 2);
        Program.printColorForPoint(3, 3);
        Program.printColorForPoint(1, 7);
        Program.printColorForPoint(-1, 4);
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter x for point: ");
        double x = scanner.nextDouble();
        System.out.print("enter y for point: ");
        double y = scanner.nextDouble();
        Program.printColorForPoint(x, y);
    }

}

class Program {

    enum SimpleColor {
        BLUE, GREEN, WHITE, ORANGE, GRAY, YELLOW
    }

    private static class Square {
        double x0; // x for left down point
        double y0; // y for left down point
        double a; // square side length

        private Square(double x0, double y0, double a) {
            this.x0 = x0;
            this.y0 = y0;
            this.a = a;
        }

        private boolean isSquare(double x, double y) {
            return (x >= x0) && (x <= (x0 + a)) && (y >= y0) && (y <= (y0 + a));
        }
    }

    private static class Parabola {
        double x0;
        double y0;
        double a;

        private Parabola(double x0, double y0, double a) {
            this.x0 = x0;
            this.y0 = y0;
            this.a = a;
        }

        private boolean isParabola(double x, double y) {
            return (a * Math.pow(y - y0, 2) + x0) >= x;
        }
    }

    private static class Circle {
        double x0;
        double y0;
        double r;

        private Circle (double x0, double y0, double r) {
            this.x0 = x0;
            this.y0 = y0;
            this.r = r;
        }

        private boolean isCircle(double x, double y) {
            return (Math.pow(x - x0, 2) + Math.pow(y - y0, 2)) <= Math.pow (r, 2);
        }
    }

    private static final Square square = new Square (-2, 1, 8);
    private static final Parabola parabola = new Parabola (4,6,-1);
    private static final Circle circleBig = new Circle (-4,5,5);
    private static final Circle circleSmall = new Circle (3,4,2);

    public static SimpleColor getColor(double x, double y) {

        if ((parabola.isParabola(x, y) && square.isSquare(x, y) && circleBig.isCircle(x, y))
                || (parabola.isParabola(x, y) && !square.isSquare(x, y) && !circleBig.isCircle(x, y))) {
            return SimpleColor.GREEN;
        }
        if (parabola.isParabola(x, y) && !circleBig.isCircle(x, y) && !circleSmall.isCircle(x, y)) {
            return SimpleColor.BLUE;
        }
        if ((circleBig.isCircle(x, y) && square.isSquare(x, y) && !parabola.isParabola(x, y))
                || (circleBig.isCircle(x, y) && !parabola.isParabola(x, y) && (y < 5))) {
            return SimpleColor.WHITE;
        }
        if ((square.isSquare(x, y) && !parabola.isParabola(x, y) && !circleBig.isCircle(x, y)
                && !circleSmall.isCircle(x, y)) || (circleBig.isCircle(x, y)
                && parabola.isParabola(x, y) && !square.isSquare(x, y))) {
            return SimpleColor.GRAY;
        }
        if ((circleSmall.isCircle(x, y) && !parabola.isParabola(x, y)) || (circleBig.isCircle(x, y)
                && !parabola.isParabola(x, y) && !square.isSquare(x, y) && (y > 5))) {
            return SimpleColor.YELLOW;
        }
        return SimpleColor.ORANGE;
    }

    public static void printColorForPoint(double x, double y) {
        SimpleColor color = Program.getColor(x, y);
        System.out.printf("(%.1f, %.1f) -> %S%n", x, y, color);
    }

}
