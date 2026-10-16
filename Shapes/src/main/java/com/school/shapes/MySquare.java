package com.school.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MySquare extends GeometricShape {
    private double dy = 2;

    public MySquare(double x, double y) {
        super(x, y, Color.GREEN);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x, y, 40, 40);
    }

    @Override
    public void move() {
        y += dy;
        if (y < 0) {
            dy = Math.abs(dy);
        }
        if (y > 360) {
            dy = -Math.abs(dy);
        }
    }
}