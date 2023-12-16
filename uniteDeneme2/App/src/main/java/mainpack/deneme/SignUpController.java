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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
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
                    try {
                        Stage stage = (Stage) signUpButton.getScene().getWindow();
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
            }
        });
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    stage.close();
                    Stage primaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/loginview.fxml"));
                    primaryStage.setTitle("Forum");
                    primaryStage.setScene(new Scene(root,900,600));
                    primaryStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                    // Handle the exception
                }
            }
        });
    }
}