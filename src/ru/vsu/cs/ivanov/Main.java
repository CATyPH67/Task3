package ru.vsu.cs.ivanov;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        printColorForPoint(0, 0);
        printColorForPoint(-4, 1);
        printColorForPoint(1, 2);
        printColorForPoint(3, 3);
        printColorForPoint(1, 7);
        printColorForPoint(-1, 4);
        double x = enterPointCoordinate('x');
        double y = enterPointCoordinate('y');
        printColorForPoint(x, y);
    }

    public static double enterPointCoordinate(char coordinateName) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input %S: ", coordinateName);
        return scanner.nextDouble();
    }

    public static void printColorForPoint(double x, double y) {
        Locale.setDefault(Locale.ROOT);
        SimpleColor color = Pictures.getColor(x, y);
        System.out.printf("(%.1f, %.1f) -> %S%n", x, y, color);
    }

    enum SimpleColor {
        BLUE, GREEN, WHITE, ORANGE, GRAY, YELLOW
    }
}

