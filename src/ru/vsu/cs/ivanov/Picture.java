package ru.vsu.cs.ivanov;

public class Picture {
    private Square square;
    private HorizontalParabola parabola;
    private Circle circleBig;
    private Circle circleSmall;

    public Picture (Square square, HorizontalParabola parabola, Circle circleBig, Circle circleSmall) {
        this.square = square;
        this.parabola = parabola;
        this.circleBig = circleBig;
        this.circleSmall = circleSmall;
    }

    public Main.SimpleColor getColor(double x, double y) {
        if ((parabola.isPointInside(x, y) && square.isPointInside(x, y) && circleBig.isPointInside(x, y))
                || (parabola.isPointInside(x, y) && !square.isPointInside(x, y) && !circleBig.isPointInside(x, y))) {
            return Main.SimpleColor.GREEN;
        }

        if (parabola.isPointInside(x, y) && !circleBig.isPointInside(x, y) && !circleSmall.isPointInside(x, y)) {
            return Main.SimpleColor.BLUE;
        }

        if ((circleBig.isPointInside(x, y) && square.isPointInside(x, y) && !parabola.isPointInside(x, y))
                || (circleBig.isPointInside(x, y) && !parabola.isPointInside(x, y) && (circleBig.isPointInsideLowerHalfCircle(x, y)))) {
            return Main.SimpleColor.WHITE;
        }

        if ((square.isPointInside(x, y) && !parabola.isPointInside(x, y) && !circleBig.isPointInside(x, y)
                && !circleSmall.isPointInside(x, y)) || (circleBig.isPointInside(x, y)
                && parabola.isPointInside(x, y) && !square.isPointInside(x, y))) {
            return Main.SimpleColor.GRAY;
        }

        if ((circleSmall.isPointInside(x, y) && !parabola.isPointInside(x, y)) || (circleBig.isPointInside(x, y)
                && !parabola.isPointInside(x, y) && !square.isPointInside(x, y) && (circleBig.isPointInsideUpperHalfCircle(x, y)))) {
            return Main.SimpleColor.YELLOW;
        }

        return Main.SimpleColor.ORANGE;
    }
}
