package mainpack.deneme;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Parent;

public class ResponseController implements Initializable {
    @FXML
    private Button backButton;
    @FXML
    private Label userNameQuestion;
    @FXML
    private Label textOfQuestion;
    @FXML
    private VBox responseBox;
    @FXML
    public void onBackButtonClick() {
        try {
            Stage stage = (Stage) backButton.getScene().getWindow();
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

    public void setData(Question q) {
        textOfQuestion.setText(q.getInfo());
        userNameQuestion.setText(q.getOwner().getName());
        responseBox.getChildren().clear();
        for (Reply r : q.getReplies()) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/response.fxml"));
            try {
                HBox hbox = loader.load();
                ResponseItemController ric = loader.getController();
                ric.setData(r);
                responseBox.getChildren().add(hbox);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}