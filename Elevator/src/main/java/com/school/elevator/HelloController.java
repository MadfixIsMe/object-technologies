package com.school.elevator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class HelloController {

    @FXML
    private Pane root;

    @FXML
    private Label floorLabel;

    private Elevator elevator;

    @FXML
    public void initialize() {
        elevator = new Elevator(140, floorLabel);
        root.getChildren().add(elevator);
        elevator.requestFocus();

        root.setOnMouseClicked(e -> elevator.requestFocus());
    }
}