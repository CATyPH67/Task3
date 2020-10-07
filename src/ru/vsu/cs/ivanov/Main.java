package ru.vsu.cs.ivanov;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Locale.setDefault(Locale.ROOT);
        Picture picture = new Picture(new Square(-2, 1, 8), new HorizontalParabola (4,6,-1),
                                        new Circle (-4,5,5), new Circle (3,4,2));
        test(picture);
        double x = enterPointCoordinate('x');
        double y = enterPointCoordinate('y');
        outputColorForPoint(x, y, picture);
    }

    private static void test (Picture picture) {
        double[][] arrayOfPoints = {{0,-4, 1, 3, 1,-1},
                                    {0, 1, 2, 3, 7, 4}};
        for (int i = 0; i <= 5; i++) {
            outputColorForPoint(arrayOfPoints[0][i], arrayOfPoints[1][i], picture);
        }
    }

    private static void outputColorForPoint (double x, double y, Picture picture) {
        System.out.printf("(%.1f, %.1f) -> %S%n", x, y, picture.getColor(x, y));
    }

    private static double enterPointCoordinate(char coordinateName) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input %S: ", coordinateName);
        return scanner.nextDouble();
    }

    enum SimpleColor {
        BLUE, GREEN, WHITE, ORANGE, GRAY, YELLOW
    }
}

