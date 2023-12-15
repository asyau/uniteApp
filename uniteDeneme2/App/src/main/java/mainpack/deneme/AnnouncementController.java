package mainpack.deneme;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AnnouncementController implements Initializable {
    @FXML
    private Label dateLabel;
    @FXML
    private Button weekBackButton;
    @FXML
    private Button weekForwardButton;
    @FXML
    private Label welcomeText;
    @FXML
    private Button backButton;
    @FXML
    public void onBackButtonClick() {
        try {
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/menu-view.fxml"));
            primaryStage.setTitle("Forum");
            primaryStage.setScene(new Scene(root,900,600));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }

    private AnnouncementHolder annh;
    private String dateText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        annh = new AnnouncementHolder(null);
        setText();
        weekBackButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                annh.weekBackward();
                setText();
            }
        });
        weekForwardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                annh.weekForward();
                setText();
            }
        });
    }

    private void setText() {
        dateText = String.format("%s - %s", annh.minString, annh.maxString);
        dateLabel.setText(dateText);
    }



}