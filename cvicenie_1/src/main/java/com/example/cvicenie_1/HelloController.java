package com.example.cvicenie_1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class HelloController {

    @FXML
    private Label displayLabel, saveLabel;

    private int prveCislo;
    private String operacia = "";

    @FXML
    protected void Cislo(ActionEvent event) {
        Button button = (Button) event.getSource();
        saveLabel.setText(saveLabel.getText() + button.getText());
    }

    @FXML
    protected void addition() {
        if (operacia.equals("")) {
            saveLabel.setText(saveLabel.getText() + " + ");
            operacia = "+";
        }
    }

    @FXML
    protected void substraction() {
        if (operacia.equals("")) {
            saveLabel.setText(saveLabel.getText() + " - ");
            operacia = "-";
        }
    }

    @FXML
    protected void multiply() {
        if (operacia.equals("")) {
            saveLabel.setText(saveLabel.getText() + " x ");
            operacia = "x";
        }
    }

    @FXML
    protected void division() {
        if (operacia.equals("")) {
            saveLabel.setText(saveLabel.getText() + " / ");
            operacia = "/";
        }
    }

    @FXML
    protected void equals() {

        String text = saveLabel.getText();

        String[] casti = text.split(" ");

        int prveCislo = Integer.parseInt(casti[0]);
        int druheCislo = Integer.parseInt(casti[2]);

        int vysledok = 0;

        if (operacia.equals("+")) {
            vysledok = prveCislo + druheCislo;
        } else if (operacia.equals("-")) {
            vysledok = prveCislo - druheCislo;
        } else if (operacia.equals("x")) {
            vysledok = prveCislo * druheCislo;
        } else if (operacia.equals("/")) {
            vysledok = prveCislo / druheCislo;
        }

        displayLabel.setText(String.valueOf(vysledok));

        operacia = "";
    }

    @FXML
    protected void clear() {
        displayLabel.setText("");
        saveLabel.setText("");
        operacia = "";
    }
}