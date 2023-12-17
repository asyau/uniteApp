package mainpack.deneme;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.Parent;

public class MenuController {

    @FXML
    private Button uploadProfilePicButton;
    @FXML
    private ImageView menuProfilePic;
    @FXML
    private Label welcomeText;
    @FXML
    private Button forumButton;
    @FXML
    private Button eventsButton;
    @FXML
    private Button contactButton;
    @FXML
    public void onForumButtonClick() {
        try {
            Stage stage = (Stage) forumButton.getScene().getWindow();
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

    @FXML
    public void UploadProfilePicButtonClick() {
        try {
            Stage stage = (Stage) uploadProfilePicButton.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/profilePicUploadPage.fxml"));
            primaryStage.setTitle("Upload Profile Picture");
            primaryStage.setScene(new Scene(root,900,600));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }
    @FXML
    public void initialize() {
        Image profileImage = ProfileService.getProfileImage();
        if (profileImage != null) {
            menuProfilePic.setImage(profileImage);
        }
    }

    @FXML
    public void onEventsButtonClick() {
        try {
            Stage stage = (Stage) eventsButton.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/announcement-view.fxml"));
            primaryStage.setTitle("Events");
            primaryStage.setScene(new Scene(root,900,600));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }

    @FXML
    public void onContactButtonClick() {
        try {
            Stage stage = (Stage) contactButton.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/contactsview.fxml"));
            primaryStage.setTitle("Contact Information");
            primaryStage.setScene(new Scene(root,900,600));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}