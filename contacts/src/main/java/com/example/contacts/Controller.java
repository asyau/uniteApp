package com.example.contacts;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ListView<bilkentNumbers> numbersListView;
    @FXML
    private VBox phoneNumbersLayout;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<bilkentNumbers> bilkentNumbers = new ArrayList<>(numbers());
        for (int i = 0; i < bilkentNumbers.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("numbers.fxml"));

            try{
                HBox hBox = fxmlLoader.load();
                NumbersController nc = fxmlLoader.getController();
                nc.setData(bilkentNumbers.get(i));
                phoneNumbersLayout.getChildren().add(hBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private List<bilkentNumbers> numbers() {
        List<bilkentNumbers> nums = new ArrayList<>();

        bilkentNumbers num1 = new bilkentNumbers();
        num1.setName("Bilkent Emergency Call Center");
        num1.setPhoneNumber("290-6666");
        nums.add(num1);

        bilkentNumbers num2 = new bilkentNumbers(); // Create a new object for num2
        num2.setName("Health Center - Main Campus");
        num2.setPhoneNumber("290-1666");
        nums.add(num2);

        return nums;
    }

}