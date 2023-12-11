package com.example.askaquestion;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Label userName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set the text to "Asya" when the FXML is loaded
        userName.setText("Asya");
    }
}