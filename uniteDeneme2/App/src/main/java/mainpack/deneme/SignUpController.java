package mainpack.deneme;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @FXML
    private Button SignUpPageSignUpButton;
    @FXML
    private Label viewer;
    @FXML
    private Button SignUpPageLoginButton;
    @FXML
    private TextField SignUpPageNameText;
    @FXML
    private TextField bilkentMailAddress;
    @FXML
    private PasswordField passwordText;
    @FXML
    private Button signUpButton;
    @FXML
    private Button loginButton;

    public void signUp(ActionEvent event){
        viewer.setText("Welcome");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean signUpIsValid;
                String name = SignUpPageNameText.getText();
                String mail = bilkentMailAddress.getText();
                String password = passwordText.getText();
                signUpIsValid = Authenticator.signUp(mail, password, name);
                if (signUpIsValid){
                    //direct to the menu page
                }
            }
        });
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //direct to login page
            }
        });
    }
}