package com.school.space;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public abstract class SpaceObject extends Canvas {

    protected static final double HORE = 50;
    protected GraphicsContext gc;
    protected Pane plocha;
    private Timeline casovac;

    public SpaceObject(double sirka, double vyska, double x, double y, Pane plocha) {
        super(sirka, vyska);
        this.plocha = plocha;
        setLayoutX(x);
        setLayoutY(y);
        gc = getGraphicsContext2D();

        casovac = new Timeline(
                new KeyFrame(Duration.millis(30), e -> pohni()));
        casovac.setCycleCount(Animation.INDEFINITE);
        casovac.play();
    }
    protected abstract void vykresli();
    protected abstract void pohni();
}