package mainpack.deneme;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class AskAQController implements Initializable {
    @FXML
    private Label userName;
    @FXML
    private Button lostFoundButton;
    @FXML
    private Button transportationButton;
    @FXML
    private Button roommateButton;
    @FXML
    private Button otherButton;
    @FXML
    private Button sendButton;
    @FXML
    private TextArea textInput;
    @FXML
    private Label charLimitText;
    private int tag;
    private int inputSize;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set the text to "Asya" when the FXML is loaded
        userName.setText("Asya");
        lostFoundButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lostFoundButton.setStyle("-fx-background-color: CORNFLOWERBLUE");
                transportationButton.setStyle("");
                roommateButton.setStyle("");
                otherButton.setStyle("");
                tag = 1;
            }
        });
        transportationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lostFoundButton.setStyle("");
                transportationButton.setStyle("-fx-background-color: CORNFLOWERBLUE");
                roommateButton.setStyle("");
                otherButton.setStyle("");
                tag = 2;
            }
        });
        roommateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lostFoundButton.setStyle("");
                transportationButton.setStyle("");
                roommateButton.setStyle("-fx-background-color: CORNFLOWERBLUE");
                otherButton.setStyle("");
                tag = 3;
            }
        });
        otherButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lostFoundButton.setStyle("");
                transportationButton.setStyle("");
                roommateButton.setStyle("");
                otherButton.setStyle("-fx-background-color: CORNFLOWERBLUE");
                tag = 4;
            }
        });
        textInput.textProperty().addListener((observable, oldValue, newValue) -> {
            inputSize = newValue.length();
            charLimitText.setText(String.format("Character Limit:  %3d/280", inputSize));
        });
        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (tag == 0){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("WARNING");
                    alert.setContentText("You should choose a tag.");
                    alert.showAndWait();
                } else if (inputSize < 10) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("WARNING");
                    alert.setContentText("You should have minimum 10 characters.");
                    alert.showAndWait();
                } else if (inputSize > 280) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("WARNING");
                    alert.setContentText("You should have maximum 280 characters");
                    alert.showAndWait();
                } else {
                    Question q = new Question("Heading", textInput.getText(),tag,
                            Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul")),null);
                    //Save to database.
                    //Direct to other page.

                    try {
                        Stage stage = (Stage) sendButton.getScene().getWindow();
                        stage.close();
                        Stage primaryStage = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("/forumview.fxml"));
                        primaryStage.setTitle("Forum");
                        primaryStage.setScene(new Scene(root,900,600));
                        primaryStage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                        // Handle the exception
                    }

                }
            }
        });
    }
}