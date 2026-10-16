package com.school.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyCircle extends GeometricShape {
    private double centerX, centerY;
    private double angle = 0;
    private double radius = 40;

    public MyCircle(double x, double y) {
        super(x, y, Color.RED);
        centerX = x;
        centerY = y;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(x, y, 30, 30);
    }

    @Override
    public void move() {
        angle += 0.05;
        x = centerX + radius * Math.cos(angle);
        y = centerY + radius * Math.sin(angle);
    }

    @Override
    public void moveDown(double d) {
        centerY += d;
        y += d;
    }
}