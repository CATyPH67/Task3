package ru.vsu.cs.ivanov;

import java.util.Locale;
import java.util.Scanner;

class Program
{
    public static double enterPointCoordinate(char coordinateName) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input %S: ", coordinateName);
        return scanner.nextDouble();
    }

    public static void printColorForPoint(double x, double y)
    {
        Locale.setDefault(Locale.ROOT);
        SimpleColor color = Program.getColor(x, y);
        System.out.printf("(%.1f, %.1f) -> %S%n", x, y, color);
    }

    enum SimpleColor
    {
        BLUE, GREEN, WHITE, ORANGE, GRAY, YELLOW
    }

    private static SimpleColor getColor(double x, double y)
    {
        Square square = new Square (-2, 1, 8);
        Parabola parabola = new Parabola (4,6,-1);
        Circle circleBig = new Circle (-4,5,5);
        Circle circleSmall = new Circle (3,4,2);

        if ((parabola.isParabola(x, y) && square.isSquare(x, y) && circleBig.isCircle(x, y))
                || (parabola.isParabola(x, y) && !square.isSquare(x, y) && !circleBig.isCircle(x, y)))
        {
            return SimpleColor.GREEN;
        }
        if (parabola.isParabola(x, y) && !circleBig.isCircle(x, y) && !circleSmall.isCircle(x, y))
        {
            return SimpleColor.BLUE;
        }
        if ((circleBig.isCircle(x, y) && square.isSquare(x, y) && !parabola.isParabola(x, y))
                || (circleBig.isCircle(x, y) && !parabola.isParabola(x, y) && (circleBig.isLowerHalfCircle(y))))
        {
            return SimpleColor.WHITE;
        }
        if ((square.isSquare(x, y) && !parabola.isParabola(x, y) && !circleBig.isCircle(x, y)
                && !circleSmall.isCircle(x, y)) || (circleBig.isCircle(x, y)
                && parabola.isParabola(x, y) && !square.isSquare(x, y)))
        {
            return SimpleColor.GRAY;
        }
        if ((circleSmall.isCircle(x, y) && !parabola.isParabola(x, y)) || (circleBig.isCircle(x, y)
                && !parabola.isParabola(x, y) && !square.isSquare(x, y) && (circleBig.isUpperHalfCircle(y))))
        {
            return SimpleColor.YELLOW;
        }
        return SimpleColor.ORANGE;
    }
}

