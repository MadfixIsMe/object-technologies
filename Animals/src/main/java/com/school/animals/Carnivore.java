package com.school.animals;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Carnivore extends Animal {
    private double speed = 3;
    private boolean clockwise = true;

    public Carnivore(double x, double y, int direction) {
        super(x, y, direction);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillRect(x, y, 35, 25);
    }

    // zmena smeru pohybu - otočí zviera opačne
    public void changeDirection() {
        clockwise = !clockwise;
        direction = (direction + 2) % 4;
    }

    @Override
    public void move() {
        if (clockwise) {
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
        } else {
            switch (direction) {
                case 0:
                    x += speed;
                    if (x >= MAX_X) { x = MAX_X; direction = 3; }
                    break;
                case 3:
                    y -= speed;
                    if (y <= MIN_Y) { y = MIN_Y; direction = 2; }
                    break;
                case 2:
                    x -= speed;
                    if (x <= MIN_X) { x = MIN_X; direction = 1; }
                    break;
                case 1:
                    y += speed;
                    if (y >= MAX_Y) { y = MAX_Y; direction = 0; }
                    break;
            }
        }
    }
}