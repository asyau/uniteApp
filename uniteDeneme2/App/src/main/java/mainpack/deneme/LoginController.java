package mainpack.deneme;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;

public class LoginController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField bilkentMailField;
    @FXML
    private PasswordField passwordField;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        boolean loginIsValid;
        String mail = bilkentMailField.getText();
        String password = passwordField.getText();
        loginIsValid = Authenticator.login(mail,password);
        if (loginIsValid){
            //direct to the menu
        }
        else {
            //error message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!");
            alert.setHeaderText(null);
            alert.setContentText("Information are not valid!");

            alert.showAndWait();
        }
    }


}