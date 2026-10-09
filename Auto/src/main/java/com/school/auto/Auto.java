package com.school.auto;

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

public class Auto extends Canvas {

    private GraphicsContext gc;
    private Pane plocha;
    private Timeline casovac;
    private boolean automatika = true;
    private boolean bezi = true;
    private int smer = 1;
    private int rychlost = 3;

    public Auto(double x, double y, Pane plocha) {
        super(80, 40);
        this.plocha = plocha;
        setLayoutX(x);
        setLayoutY(y);
        gc = getGraphicsContext2D();
        vykresli();

        casovac = new Timeline(
                new KeyFrame(Duration.millis(30), e -> pohniAutomaticky()));
        casovac.setCycleCount(Animation.INDEFINITE);
        casovac.play();

        setOnKeyPressed(evt -> spracuj(evt));
        setFocusTraversable(true);
        requestFocus();

        setOnMouseClicked(evt -> klik());
    }

    private void vykresli() {
        gc.setFill(Color.RED);
        gc.fillRect(0, 0, getWidth(), getHeight());
    }

    public boolean isAutomatika() {
        return automatika;
    }

    public void prepniRezim() {
        automatika = !automatika;
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
    private void pohniAutomaticky() {
        if (!automatika) {
            return;
        }

        setLayoutX(getLayoutX() + smer * rychlost);

        if (getLayoutX() + getWidth() >= plocha.getWidth()) {
            smer = -1;
        }
        if (getLayoutX() <= 0) {
            smer = 1;
        }
    }

    private void spracuj(KeyEvent evt) {
        if (automatika) {
            return;
        }

        KeyCode k = evt.getCode();
        if (k == KeyCode.LEFT) {
            setLayoutX(getLayoutX() - 10);
        }
        if (k == KeyCode.RIGHT) {
            setLayoutX(getLayoutX() + 10);
        }
        if (getLayoutX() < 0) {
            setLayoutX(0);
        }
        if (getLayoutX() + getWidth() > plocha.getWidth()) {
            setLayoutX(plocha.getWidth() - getWidth());
        }
        if (getLayoutY() < 0) {
            setLayoutY(0);
        }
        if (getLayoutY() + getHeight() > plocha.getHeight()) {
            setLayoutY(plocha.getHeight() - getHeight());
        }
    }
}