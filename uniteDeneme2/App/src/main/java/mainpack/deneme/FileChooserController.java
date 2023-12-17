package mainpack.deneme;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class FileChooserController {

    @FXML
    private Button chooseFileButton;

    @FXML
    private ImageView profilePic;

    @FXML
    private Button sendProfilePicButton;

    @FXML
    void sendProfilePicButtonClick() {
        Image selectedImage = profilePic.getImage();
        if (selectedImage != null) {
            ProfileService.setProfileImage(selectedImage);
            // Optionally, close the current stage and open the menu
            openMenu();
        }
    }

    private void openMenu() {
        try {
            Stage stage = (Stage) sendProfilePicButton.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/menu-view.fxml"));
            primaryStage.setTitle("Menu");
            primaryStage.setScene(new Scene(root, 900, 600));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void button(ActionEvent e) {
        try {
            Stage stage = (Stage) chooseFileButton.getScene().getWindow();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open a file");
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("JPEG Image", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG Image", "*.png")
            );

            File selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile != null) {
                Image image = new Image(selectedFile.toURI().toString());
                profilePic.setImage(image);
                ProfileService.setProfileImage(image);
            } else {
                System.out.println("No file has been selected");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("An error occurred: " + ex.getMessage());
        }
    }
}

