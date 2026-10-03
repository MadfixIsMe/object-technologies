package com.school.homework1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label header, bmi_result, result_string;
    @FXML
    private TextField field_weight, field_height;
    @FXML
    private Button button_calc;
    @FXML
    private double result;


    @FXML
    protected void button_click(){
        double weight = Double.parseDouble(field_weight.getText());
        double height = Double.parseDouble(field_height.getText()) / 100;
        result = weight / (height*height);

        bmi_result.setText(String.format("%.2f", result));

        if(result >= 30.0){
            result_string.setText("Máte Obezitu");
        } else if (result >= 25.0) {
            result_string.setText("Máte Nadváhu");
        } else if (result >= 18.5) {
            result_string.setText("Máte Normálnu váhu");
        } else {
            result_string.setText("Máte Podváhu");
        }
    }
}
