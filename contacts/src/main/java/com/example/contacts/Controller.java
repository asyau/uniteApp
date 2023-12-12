package com.example.contacts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    @FXML
    private TableView<StaffContact> table;
    @FXML
    private TableColumn<StaffContact, String> photoColumn;
    @FXML
    private TableColumn<StaffContact, String> nameColumn;
    @FXML
    private TableColumn<StaffContact, String> officeColumn;
    @FXML
    private TableColumn<StaffContact, String> titleColumn;
    @FXML
    private TableColumn<StaffContact, String> departmentColumn;
    @FXML
    private TableColumn<StaffContact, String> emailColumn;
    @FXML
    private TextField keywordField;

    ObservableList<StaffContact> obs;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<StaffContact> staffs = new ArrayList<>();
        staffs.add(new StaffContact("Uğur Güdükbay", "EA", "Prof", "CS", "ug@bilkent.edu.tr", null));
        staffs.add(new StaffContact("Lori Russel Dağ", "EA", "Instructor", "CS", "lrd@bilkent.edu.tr", null));
        staffs.add(new StaffContact("Uğur Doğrusöz", "EA", "Prof", "CS", "ud@bilkent.edu.tr", null));
        staffs.add(new StaffContact("Can Alkan", "EA", "Assoc", "CS", "ca@bilkent.edu.tr", null));
        staffs.add(new StaffContact("Selim Aksoy", "EA", "Doc", "CS", "saksoy@bilkent.edu.tr", null));

        ContactHolder h = new ContactHolder(staffs);

        obs = FXCollections.observableArrayList(h.getStaff());

        photoColumn.setCellValueFactory(new PropertyValueFactory<>("photo"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        officeColumn.setCellValueFactory(new PropertyValueFactory<>("office"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("mail"));
        
        table.setItems(obs);

        keywordField.textProperty().addListener((observable, oldValue, newValue) -> {
            obs = FXCollections.observableArrayList(h.filterStaff(newValue));
            table.setItems(obs);
        } );



    }



}