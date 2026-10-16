package com.school.animals;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Herbivore extends Animal {
    private double speed = 2;

    public Herbivore(double x, double y, int direction) {
        super(x, y, direction);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.fillOval(x, y, 30, 30);
    }

    @Override
    public void move() {
        switch (direction) {
            case 0:
                x += speed;
                if (x >= MAX_X) { x = MAX_X; direction = 1; }
                break;
            case 1:
                y += speed;
                if (y >= MAX_Y) { y = MAX_Y; direction = 2; }
                break;
            case 2:
                x -= speed;
                if (x <= MIN_X) { x = MIN_X; direction = 3; }
                break;
            case 3:
                y -= speed;
                if (y <= MIN_Y) { y = MIN_Y; direction = 0; }
                break;
        }
    }
}
