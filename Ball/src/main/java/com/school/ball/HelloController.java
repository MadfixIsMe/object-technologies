package com.school.ball;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class HelloController {

    @FXML
    private Pane root;

    private Ball ball;

    @FXML
    public void initialize() {
        ball = new Ball(50, 50, root);
        root.getChildren().add(ball);
    }
}