package com.school.animals;

import javafx.scene.canvas.GraphicsContext;

public abstract class Animal {
    protected static final double MIN_X = 10;
    protected static final double MAX_X = 560;
    protected static final double MIN_Y = 10;
    protected static final double MAX_Y = 360;

    protected double x, y;
    protected int direction;

    public Animal(double x, double y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public abstract void draw(GraphicsContext gc);
    public abstract void move();
}