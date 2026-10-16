package com.school.elevator;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Elevator extends Canvas {

    public static final int POSCHODIA = 9;
    public static final double VYSKA = 45;
    public static final double ZACIATOK_Y = 50;

    private GraphicsContext gc;
    private Label floorLabel;
    private Timeline casovac;

    private int cielovePoschodie = 0;
    private int cakajuce = -1;
    private int stav = 0;
    private int cakanie = 0;
    private double rychlost = 2;

    public Elevator(double x, Label floorLabel) {
        super(60, VYSKA - 6);
        this.floorLabel = floorLabel;
        setLayoutX(x);
        setLayoutY(poziciaY(0));
        gc = getGraphicsContext2D();
        vykresli();

        casovac = new Timeline(
                new KeyFrame(Duration.millis(20), e -> pohyb()));
        casovac.setCycleCount(Animation.INDEFINITE);
        casovac.play();

        setOnKeyPressed(evt -> spracuj(evt));
        setFocusTraversable(true);
        requestFocus();
    }

    private void vykresli() {
        gc.setFill(Color.BLUE);
        gc.fillRect(0, 0, getWidth(), getHeight());
        gc.setStroke(Color.BLACK);
        gc.strokeRect(0, 0, getWidth(), getHeight());
    }

    private double poziciaY(int poschodie) {
        return ZACIATOK_Y + (POSCHODIA - 1 - poschodie) * VYSKA + 3;
    }

    public int getAktualnePoschodie() {
        return (int) Math.round((poziciaY(0) - getLayoutY()) / VYSKA);
    }

    private void spracuj(KeyEvent evt) {
        String text = evt.getText();
        if (text.length() == 1 && Character.isDigit(text.charAt(0))) {
            int poschodie = Integer.parseInt(text);
            if (poschodie < POSCHODIA) {
                poziadavka(poschodie);
            }
        }
    }

    private void poziadavka(int poschodie) {
        if (stav == 0) {
            if (poschodie != getAktualnePoschodie()) {
                cielovePoschodie = poschodie;
                stav = 1;
            }
        } else {
            if (poschodie != cielovePoschodie) {
                cakajuce = poschodie;
            }
        }
    }

    private void pohyb() {
        if (stav == 1) {
            double cielY = poziciaY(cielovePoschodie);
            if (Math.abs(cielY - getLayoutY()) <= rychlost) {
                setLayoutY(cielY);
                if (cakajuce != -1 && cakajuce != cielovePoschodie) {
                    stav = 2;
                    cakanie = 0;
                } else {
                    cakajuce = -1;
                    stav = 0;
                }
            } else if (cielY < getLayoutY()) {
                setLayoutY(getLayoutY() - rychlost);
            } else {
                setLayoutY(getLayoutY() + rychlost);
            }
        } else if (stav == 2) {
            cakanie++;
            if (cakanie >= 100) {
                cielovePoschodie = cakajuce;
                cakajuce = -1;
                stav = 1;
            }
        }
        floorLabel.setText("Aktuálne poschodie: " + getAktualnePoschodie());
    }
}