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
public class MenuPicChooserController {
    @FXML
    private Button chooseFileButton;

    @FXML
    private ImageView menuPic;

    @FXML
    private Button sendMenuPicButton;

    @FXML
    void sendMenuPicButtonClick() {
        Image selectedImage = menuPic.getImage();
        if (selectedImage != null) {
            MenuService.setMenuImage(selectedImage);
            // Optionally, close the current stage and open the menu
            openMenu();
        }
    }

    private void openMenu() {
        try {
            Stage stage = (Stage) sendMenuPicButton.getScene().getWindow();
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
    void onChooseFileButtonClick(){
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
                String profilePicUrl = selectedFile.toURI().toString();
                DBController dbc = new DBController();
                dbc.insertNewMenuImage(profilePicUrl,Authenticator.currentUser.getMail());
                menuPic.setImage(image);
                MenuService.setMenuImage(image);
            } else {
                System.out.println("No file has been selected");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("An error occurred: " + ex.getMessage());
        }
    }
}
