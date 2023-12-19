package mainpack.deneme;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField bilkentMailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button sendButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                boolean loginIsValid;
                String mail = bilkentMailField.getText();
                String password = passwordField.getText();
                loginIsValid = Authenticator.login(mail,password);
                if (loginIsValid){
                    System.out.println("VALID");
                    try {
                        Stage stage = (Stage) sendButton.getScene().getWindow();
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
                else {
                    //error message
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error!");
                    alert.setHeaderText(null);
                    alert.setContentText("Information are not valid!");

                    alert.showAndWait();
                }
            }
        });
    }
}