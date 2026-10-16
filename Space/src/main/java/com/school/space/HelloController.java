package com.school.space;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Random;

public class HelloController {

    @FXML
    private Pane root;

    private ArrayList<SpaceObject> objekty = new ArrayList<>();
    private Random random = new Random();

    @FXML
    private void pridajPlanetu() {
        double x = 80 + random.nextInt((int) root.getWidth() - 160);
        double y = 130 + random.nextInt((int) root.getHeight() - 200);
        Planet p = new Planet(x, y, root);
        objekty.add(p);
        root.getChildren().add(p);
    }

    @FXML
    private void pridajAsteroid() {
        double x = random.nextInt((int) root.getWidth() - 30);
        double y = 50 + random.nextInt((int) root.getHeight() - 80);
        Asteroid a = new Asteroid(x, y, root);
        objekty.add(a);
        root.getChildren().add(a);
    }

    @FXML
    private void pridajSatelit() {
        double x = random.nextInt((int) root.getWidth() - 40);
        double y = 50 + random.nextInt((int) root.getHeight() - 90);
        Satellite s = new Satellite(x, y, root);
        objekty.add(s);
        root.getChildren().add(s);
    }

    @FXML
    private void asteroidyNaCerveno() {
        for (SpaceObject o : objekty) {
            if (o instanceof Asteroid) {
                ((Asteroid) o).setFarba(Color.RED);
            }
        }
    }

    @FXML
    private void satelityDoprava() {
        for (SpaceObject o : objekty) {
            if (o instanceof Satellite) {
                ((Satellite) o).posunDoprava(20);
            }
        }
    }
}