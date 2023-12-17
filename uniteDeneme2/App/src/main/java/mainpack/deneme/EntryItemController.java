package mainpack.deneme;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class EntryItemController implements Initializable {

    @FXML
    private Label entryName;
    @FXML
    private Label entryText;
    @FXML
    private ImageView entryImage;
    @FXML
    private Button replyButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    public void onReplyButtonClick() {
        try {
            Stage stage = (Stage) replyButton.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/responseview.fxml"));
            primaryStage.setTitle("Forum");
            primaryStage.setScene(new Scene(root,900,600));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }

    public void setData(Question q) {
        entryText.setText(q.getInfo());
        entryName.setText(q.getOwner().getName());
    }
}
