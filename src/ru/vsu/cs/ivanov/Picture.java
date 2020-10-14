package ru.vsu.cs.ivanov;

public class Picture {
    private Square square;
    private HorizontalParabola parabola;
    private Circle circleBig;
    private Circle circleSmall;

    public Picture(Square square, HorizontalParabola parabola, Circle circleBig, Circle circleSmall) {
        this.square = square;
        this.parabola = parabola;
        this.circleBig = circleBig;
        this.circleSmall = circleSmall;
    }

    public Enum.SimpleColor getColor(double x, double y) {
        if ((parabola.isPointInside(x, y) && square.isPointInside(x, y) && circleBig.isPointInside(x, y))
                || (parabola.isPointInside(x, y) && !square.isPointInside(x, y) && !circleBig.isPointInside(x, y))) {
            return Enum.SimpleColor.GREEN;
        }

        if (parabola.isPointInside(x, y) && !circleBig.isPointInside(x, y) && !circleSmall.isPointInside(x, y)) {
            return Enum.SimpleColor.BLUE;
        }

        if ((circleBig.isPointInside(x, y) && square.isPointInside(x, y) && !parabola.isPointInside(x, y))
                || (circleBig.isPointInside(x, y) && !parabola.isPointInside(x, y) && (circleBig.isPointInsideLowerHalf(x, y)))) {
            return Enum.SimpleColor.WHITE;
        }

        if ((square.isPointInside(x, y) && !parabola.isPointInside(x, y) && !circleBig.isPointInside(x, y)
                && !circleSmall.isPointInside(x, y)) || (circleBig.isPointInside(x, y)
                && parabola.isPointInside(x, y) && !square.isPointInside(x, y))) {
            return Enum.SimpleColor.GRAY;
        }

        if ((circleSmall.isPointInside(x, y) && !parabola.isPointInside(x, y)) || (circleBig.isPointInside(x, y)
                && !parabola.isPointInside(x, y) && !square.isPointInside(x, y) && (circleBig.isPointInsideUpperHalf(x, y)))) {
            return Enum.SimpleColor.YELLOW;
        }

        return Enum.SimpleColor.ORANGE;
    }
}