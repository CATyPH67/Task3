package ru.vsu.cs.ivanov;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Picture picture = new Picture(new Square(-2, 1, 8), new HorizontalParabola (4,6,-1),
                                        new Circle (-4,5,5), new Circle (3,4,2));
        test(new double[6][2], picture);
        double x = enterPointCoordinate('x');
        double y = enterPointCoordinate('y');
        outputColorForPoint(x, y, picture);
    }

    private static void test (double[][] arrayOfPoints, Picture picture) {
        arrayOfPoints[0][0] = 0;
        arrayOfPoints[0][1] = 0;
        arrayOfPoints[1][0] = -4;
        arrayOfPoints[1][1] = 1;
        arrayOfPoints[2][0] = 1;
        arrayOfPoints[2][1] = 2;
        arrayOfPoints[3][0] = 3;
        arrayOfPoints[3][1] = 3;
        arrayOfPoints[4][0] = 1;
        arrayOfPoints[4][1] = 7;
        arrayOfPoints[5][0] = -1;
        arrayOfPoints[5][1] = 4;
        for (int i = 0; i <= 5; i++) {
            outputColorForPoint(arrayOfPoints[i][0], arrayOfPoints[i][1], picture);
        }
    }

    private static void outputColorForPoint (double x, double y, Picture picture) {
        Locale.setDefault(Locale.ROOT);
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

