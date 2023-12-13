package mainpack.deneme;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ResponseController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}