package com.example.contacts;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class NumbersController implements Initializable {

    @FXML
    private Label numberName;

    @FXML
    private Label phoneNumber;


    public  void setData(bilkentNumbers bilkentNumber){
        numberName.setText(bilkentNumber.getName());
        phoneNumber.setText(bilkentNumber.getPhoneNumber());
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}