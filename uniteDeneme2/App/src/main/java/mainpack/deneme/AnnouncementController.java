package mainpack.deneme;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AnnouncementController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private Label dateLabel;
    @FXML
    private Button weekBackButton;
    @FXML
    private Button weekForwardButton;

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