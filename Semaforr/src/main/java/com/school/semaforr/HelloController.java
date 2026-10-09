package com.school.semaforr;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML private Pane root;
    Semafor s;

    @FXML protected void draw(){
        s = new Semafor();
        root.getChildren().add(s);
    }

    @FXML protected void zmenStav(){
        s.zmenStav();
    }

    @FXML protected void auto(){
        s.start();
    }

    @FXML protected void zltaOnly(){
        s.zlta();
    }
}