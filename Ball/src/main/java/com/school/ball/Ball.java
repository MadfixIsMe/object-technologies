package com.school.ball;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Ball extends Canvas {

    private GraphicsContext gc;
    private Pane plocha;
    private Timeline casovac;
    private boolean bezi = true;
    private int smerX = 1;
    private int smerY = 1;
    private int rychlost = 3;

    public Ball(double x, double y, Pane plocha) {
        super(40, 40);
        this.plocha = plocha;
        setLayoutX(x);
        setLayoutY(y);
        gc = getGraphicsContext2D();
        vykresli();

        casovac = new Timeline(
                new KeyFrame(Duration.millis(30), e -> pohyb()));
        casovac.setCycleCount(Animation.INDEFINITE);
        casovac.play();

        setOnKeyPressed(evt -> spracuj(evt));
        setFocusTraversable(true);
        requestFocus();

        setOnMouseClicked(evt -> klik());
    }

    private void vykresli() {
        gc.setFill(Color.BLUE);
        gc.fillOval(0, 0, getWidth(), getHeight());
    }

    private void klik() {
        if (bezi) {
            casovac.stop();
            bezi = false;
        } else {
            casovac.play();
            bezi = true;
        }
        requestFocus();
    }

    private void pohyb() {
        setLayoutX(getLayoutX() + smerX * rychlost);
        setLayoutY(getLayoutY() + smerY * rychlost);

        if (getLayoutX() <= 0) {
            smerX = 1;
        }
        if (getLayoutX() + getWidth() >= plocha.getWidth()) {
            smerX = -1;
        }

        if (getLayoutY() <= 0) {
            smerY = 1;
        }
        if (getLayoutY() + getHeight() >= plocha.getHeight()) {
            smerY = -1;
        }
    }

    private void spracuj(KeyEvent evt) {
        KeyCode k = evt.getCode();
        if (k == KeyCode.F) {
            rychlost = rychlost + 1;
        }
        if (k == KeyCode.S) {
            if (rychlost > 1) {
                rychlost = rychlost - 1;
            }
        }
    }
}