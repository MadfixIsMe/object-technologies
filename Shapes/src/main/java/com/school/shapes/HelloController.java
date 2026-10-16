package com.school.shapes;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Random;

public class HelloController {
    @FXML
    private Canvas canvas;

    private GraphicsContext gc;
    private ArrayList<GeometricShape> shapes = new ArrayList<>();
    private Random random = new Random();

    @FXML
    public void initialize() {
        gc = canvas.getGraphicsContext2D();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                for (GeometricShape s : shapes) {
                    s.move();
                    s.draw(gc);
                }
            }
        };
        timer.start();
    }

    @FXML
    private void addRectangle() {
        shapes.add(new MyRectangle(random.nextInt(480), random.nextInt(350)));
    }

    @FXML
    private void addCircle() {
        shapes.add(new MyCircle(100 + random.nextInt(400), 50 + random.nextInt(250)));
    }

    @FXML
    private void addSquare() {
        shapes.add(new MySquare(random.nextInt(550), random.nextInt(350)));
    }

    @FXML
    private void makeCirclesBlue() {
        for (GeometricShape s : shapes) {
            if (s instanceof MyCircle) {
                s.setColor(Color.BLUE);
            }
        }
    }

    @FXML
    private void moveAllDown() {
        for (GeometricShape s : shapes) {
            s.moveDown(30);
        }
    }
}