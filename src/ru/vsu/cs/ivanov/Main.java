package ru.vsu.cs.ivanov;

import java.awt.geom.Area;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print("enter x for point: ");
        double x = scanner.nextDouble();
        System.out.print("enter y for point: ");
        double y = scanner.nextDouble();
        System.out.println(findArea(x, y));
    }

    enum Color {
        BLUE, GREEN, WHITE, ORANGE, GRAY, YELLOW
    }

    static Color findArea (double x, double y) {
        if ((isParabola(x, y) && isSquare(x, y) && isCircleBig(x, y))
                                    || (isParabola(x, y) && !isSquare(x, y) && !isCircleBig(x, y))) {
            return Color.GREEN;
        }
        if (isParabola(x, y) && !isCircleBig(x, y) && !isCircleSmall(x, y)) {
            return Color.BLUE;
        }
        if ((isCircleBig(x, y) && isSquare(x, y) && !isParabola(x, y))
                                    || (isCircleBig(x, y) && !isParabola(x, y) && (y < 5))) {
            return Color.WHITE;
        }
        if ((isSquare(x, y) && !isParabola(x, y) && !isCircleBig(x, y) && !isCircleSmall(x, y))
                                    || (isCircleBig(x, y) && isParabola(x, y) && !isSquare(x, y))) {
            return Color.GRAY;
        }
        if ((isCircleSmall(x, y) && !isParabola(x, y))
                                    || (isCircleBig(x, y) && !isParabola(x, y) && !isSquare(x, y) && (y > 5))) {
            return Color.YELLOW;
        }
        return Color.ORANGE;
    }

    static boolean isSquare (double x, double y) {
        return (x >= -2) && (x <= 6) && (y >= 1) && (y <= 9);
    }

    static boolean isParabola (double x, double y) {
        return (x <= 4) && ((-1 * (y - 6) * (y - 6) + 4) >= x);
    }

    static boolean isCircleBig (double x, double y) {
        return ((x + 4) * (x + 4) + (y - 5) * (y - 5)) <= 25;
    }

    static boolean isCircleSmall (double x, double y) {
        return ((x - 3) * (x - 3) + (y - 4) * (y - 4)) <= 4;
    }

}
