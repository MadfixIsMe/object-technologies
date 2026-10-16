package com.school.space;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Planet extends SpaceObject {

    private double stredX, stredY;
    private double polomer = 50;
    private double uhol = 0;

    public Planet(double stredX, double stredY, Pane plocha) {
        super(40, 40, stredX, stredY, plocha);
        this.stredX = stredX;
        this.stredY = stredY;
        vykresli();
    }

    @Override
    protected void vykresli() {
        gc.setFill(Color.BLUE);
        gc.fillOval(0, 0, getWidth(), getHeight());
        gc.setFill(Color.LIGHTGREEN);
        gc.fillOval(10, 8, 12, 10);
    }

    @Override
    protected void pohni() {
        uhol += 0.05;
        setLayoutX(stredX + polomer * Math.cos(uhol) - getWidth() / 2);
        setLayoutY(stredY + polomer * Math.sin(uhol) - getHeight() / 2);
    }
}