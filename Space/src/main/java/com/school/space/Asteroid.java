package com.school.space;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Asteroid extends SpaceObject {

    private Color farba = Color.GRAY;
    private double dx = 3;
    private double dy = 3;

    public Asteroid(double x, double y, Pane plocha) {
        super(30, 30, x, y, plocha);
        vykresli();
    }

    @Override
    protected void vykresli() {
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.setFill(farba);
        gc.fillOval(0, 0, getWidth(), getHeight());
    }

    public void setFarba(Color farba) {
        this.farba = farba;
        vykresli();
    }

    @Override
    protected void pohni() {
        setLayoutX(getLayoutX() + dx);
        setLayoutY(getLayoutY() + dy);

        if (getLayoutX() <= 0) {
            dx = Math.abs(dx);
        }
        if (getLayoutX() + getWidth() >= plocha.getWidth()) {
            dx = -Math.abs(dx);
        }
        if (getLayoutY() <= HORE) {
            dy = Math.abs(dy);
        }
        if (getLayoutY() + getHeight() >= plocha.getHeight()) {
            dy = -Math.abs(dy);
        }
    }
}