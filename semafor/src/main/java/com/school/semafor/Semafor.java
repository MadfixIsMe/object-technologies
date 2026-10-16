package com.school.semafor;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Semafor extends Canvas {
    private GraphicsContext gc;
    private int stav = 0;
    private Timeline t;
    private boolean bezi = false;

    public Semafor(){
        super(150, 400);
        setLayoutX(50);
        this.gc = this.getGraphicsContext2D();
        vykresli(Color.RED, Color.BLACK, Color.BLACK);
        setOnMousePressed(e->zmenStav());
        t = new Timeline(new KeyFrame(Duration.seconds(1), e -> zmenStav()));
        t.setCycleCount(Timeline.INDEFINITE);
    }

    public void start(){
        if(bezi){
            t.stop();
            bezi = false;
        }else {
            t.play();
            bezi = true;
        }
    }

    private void vykresli(Color red, Color yellow, Color green){
        gc.setFill(Color.GRAY);
        gc.fillRect(0, 0, 150, 400);
        gc.setFill(red);
        gc.fillOval(30, 30, 80, 80);
        gc.setFill(yellow);
        gc.fillOval(30, 30+80+10, 80, 80);
        gc.setFill(green);
        gc.fillOval(30, 30+80+10+80+10, 80, 80);
    }

    public void zmenStav(){
        if(stav==3) stav = 0;
        else stav++;
        switch (stav){
            case 0: vykresli(Color.RED, Color.BLACK, Color.BLACK);
            case 1: vykresli(Color.RED, Color.YELLOW, Color.BLACK);
            case 2: vykresli(Color.BLACK, Color.BLACK, Color.GREEN);
            case 3: vykresli(Color.BLACK, Color.YELLOW, Color.BLACK);
        }
    }
}
