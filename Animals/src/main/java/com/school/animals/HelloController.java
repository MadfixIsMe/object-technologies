package com.school.animals;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;
import java.util.Random;

public class HelloController {
    @FXML
    private Canvas canvas;

    private GraphicsContext gc;
    private ArrayList<Animal> animals = new ArrayList<>();
    private Random random = new Random();
    private boolean running = true;

    @FXML
    public void initialize() {
        gc = canvas.getGraphicsContext2D();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                for (Animal a : animals) {
                    if (running) {
                        a.move();
                    }
                    a.draw(gc);
                }
            }
        };
        timer.start();
    }

    @FXML
    private void addHerbivore() {
        // náhodný okraj: 0 = hore, 1 = vpravo, 2 = dole, 3 = vľavo
        int side = random.nextInt(4);
        double x = 10, y = 10;
        double rx = 10 + random.nextInt(550);
        double ry = 10 + random.nextInt(350);
        if (side == 0) { x = rx; y = 10; }
        if (side == 1) { x = 560; y = ry; }
        if (side == 2) { x = rx; y = 360; }
        if (side == 3) { x = 10; y = ry; }
        animals.add(new Herbivore(x, y, side));
    }

    @FXML
    private void addCarnivore() {
        int side = random.nextInt(4);
        double x = 10, y = 10;
        double rx = 10 + random.nextInt(550);
        double ry = 10 + random.nextInt(350);
        if (side == 0) { x = rx; y = 10; }
        if (side == 1) { x = 560; y = ry; }
        if (side == 2) { x = rx; y = 360; }
        if (side == 3) { x = 10; y = ry; }
        animals.add(new Carnivore(x, y, side));
    }

    @FXML
    private void changeCarnivoreDirection() {
        for (Animal a : animals) {
            if (a instanceof Carnivore) {
                ((Carnivore) a).changeDirection();
            }
        }
    }

    @FXML
    private void stopStart() {
        running = !running;
    }
}