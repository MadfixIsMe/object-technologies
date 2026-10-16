package com.school.space;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Satellite extends SpaceObject {

    private int smer = 1;
    private double rychlost = 2;

    public Satellite(double x, double y, Pane plocha) {
        super(40, 40, x, y, plocha);
        vykresli();
    }

    @Override
    protected void vykresli() {
        // telo
        gc.setFill(Color.SILVER);
        gc.fillRect(15, 10, 10, 20);
        // solárne panely
        gc.setFill(Color.DARKBLUE);
        gc.fillRect(0, 15, 12, 10);
        gc.fillRect(28, 15, 12, 10);
    }

    public void posunDoprava(double o) {
        setLayoutX(getLayoutX() + o);
        if (getLayoutX() + getWidth() > plocha.getWidth()) {
            setLayoutX(plocha.getWidth() - getWidth());
        }
    }

    @Override
    protected void pohni() {
        setLayoutY(getLayoutY() + smer * rychlost);

        if (getLayoutY() + getHeight() >= plocha.getHeight()) {
            smer = -1;
        }
        if (getLayoutY() <= HORE) {
            smer = 1;
        }
    }
}