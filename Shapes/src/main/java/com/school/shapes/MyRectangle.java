package com.school.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyRectangle extends GeometricShape {
    private double dx = 2;

    public MyRectangle(double x, double y) {
        super(x, y, Color.ORANGE);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x, y, 60, 30);
    }

    @Override
    public void move() {
        x += dx;
        if (x > 540 || x < 0) {
            dx = -dx;
        }
    }
}