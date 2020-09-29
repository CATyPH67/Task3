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
        double x = Program.enterPointCoordinate('x');
        double y = Program.enterPointCoordinate('y');
        Program.printColorForPoint(x, y);
    }
}

