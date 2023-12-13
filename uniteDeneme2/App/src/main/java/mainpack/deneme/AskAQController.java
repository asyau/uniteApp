package mainpack.deneme;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class AskAQController implements Initializable {
    @FXML
    private Label userName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set the text to "Asya" when the FXML is loaded
        userName.setText("Asya");
    }
}