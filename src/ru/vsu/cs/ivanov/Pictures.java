package ru.vsu.cs.ivanov;

public class Pictures {
    private static Square square = new Square (-2, 1, 8);
    private static HorizontalParabola parabola = new HorizontalParabola (4,6,-1);
    private static Circle circleBig = new Circle (-4,5,5);
    private static Circle circleSmall = new Circle (3,4,2);

    public static Main.SimpleColor getColor(double x, double y) {
        if ((parabola.isPointInside(x, y) && square.isPointInside(x, y) && circleBig.isPointInside(x, y))
                || (parabola.isPointInside(x, y) && !square.isPointInside(x, y) && !circleBig.isPointInside(x, y))) {
            return Main.SimpleColor.GREEN;
        }

        if (parabola.isPointInside(x, y) && !circleBig.isPointInside(x, y) && !circleSmall.isPointInside(x, y)) {
            return Main.SimpleColor.BLUE;
        }

        if ((circleBig.isPointInside(x, y) && square.isPointInside(x, y) && !parabola.isPointInside(x, y))
                || (circleBig.isPointInside(x, y) && !parabola.isPointInside(x, y) && (circleBig.isPointInsideLowerHalfCircle(y)))) {
            return Main.SimpleColor.WHITE;
        }

        if ((square.isPointInside(x, y) && !parabola.isPointInside(x, y) && !circleBig.isPointInside(x, y)
                && !circleSmall.isPointInside(x, y)) || (circleBig.isPointInside(x, y)
                && parabola.isPointInside(x, y) && !square.isPointInside(x, y))) {
            return Main.SimpleColor.GRAY;
        }

        if ((circleSmall.isPointInside(x, y) && !parabola.isPointInside(x, y)) || (circleBig.isPointInside(x, y)
                && !parabola.isPointInside(x, y) && !square.isPointInside(x, y) && (circleBig.isPointInsideUpperHalfCircle(y)))) {
            return Main.SimpleColor.YELLOW;
        }

        return Main.SimpleColor.ORANGE;
    }
}
