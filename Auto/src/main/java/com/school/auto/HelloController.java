package com.school.auto;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class HelloController {

    @FXML
    private Pane root;

    @FXML
    private Button btn;

    private Auto auto;

    @FXML
    public void initialize() {
        auto = new Auto(50, 200, root);
        root.getChildren().add(auto);
    }

    @FXML
    private void zmenRezim() {
        auto.prepniRezim();

        if (auto.isAutomatika()) {
            btn.setText("Režim: AUTOMATIKA");
        } else {
            btn.setText("Režim: MANUÁL");
        }
        auto.requestFocus();
    }
}