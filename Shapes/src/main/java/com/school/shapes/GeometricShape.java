package com.school.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class GeometricShape {
    protected double x, y;
    protected Color color;

    public GeometricShape(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public abstract void draw(GraphicsContext gc);
    public abstract void move();

    public void moveDown(double d) {
        y += d;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}