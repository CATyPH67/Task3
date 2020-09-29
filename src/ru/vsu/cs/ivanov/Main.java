package ru.vsu.cs.ivanov;

import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
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

