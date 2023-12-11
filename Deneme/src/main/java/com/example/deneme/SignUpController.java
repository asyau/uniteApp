package com.example.deneme;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SignUpController {
    @FXML
    private Button SignUpPageSignUpButton;
    @FXML
    private Label viewer;
    @FXML
    private Button SignUpPageLoginButton;

    public void signUpButtonPressed(ActionEvent event){
            viewer.setText("Welcome");
    }
}