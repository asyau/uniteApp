package mainpack.deneme;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.TimeZone;

import javafx.scene.Parent;

public class ResponseController implements Initializable {
    Question question;
    int inputSize = 0;
    @FXML
    private Button backButton;
    @FXML
    private Label userNameQuestion;
    @FXML
    private Label textOfQuestion;
    @FXML
    private VBox responseBox;
    @FXML
    private Button responseSendButton;
    @FXML
    private TextArea textArea;
    @FXML
    private Label wordLimit;
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
        question = q;
        textOfQuestion.setText(q.getInfo());
        userNameQuestion.setText(q.getOwner().getName());
        responseBox.getChildren().clear();
        for (Reply r : Forum.getReplies()) {
            if (r.getQuestion().equals(q)) {
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
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wordLimit.setText(String.format("Character Limit:  %3d/280", 0));
        responseSendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (inputSize < 10) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("WARNING");
                    alert.setContentText("You should have minimum 10 characters.");
                    alert.showAndWait();
                } else if (inputSize > 280) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("WARNING");
                    alert.setContentText("You should have maximum 280 characters");
                    alert.showAndWait();
                } else {
                    String text = textArea.getText();
                    Reply r = new Reply(text, Authenticator.currentUser,
                            Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul")),
                            question);
                    DBController dbc = new DBController();
                    dbc.InsertNewReply(r, question);
                    try {
                        Stage stage = (Stage) responseSendButton.getScene().getWindow();
                        stage.close();
                        Stage primaryStage = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("/forumview.fxml"));
                        primaryStage.setTitle("Forum");
                        primaryStage.setScene(new Scene(root, 900, 600));
                        primaryStage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                        // Handle the exception
                    }
                }
            }
        });
        textArea.textProperty().addListener((observable, oldValue, newValue) -> {
            inputSize = newValue.length();
            wordLimit.setText(String.format("Character Limit:  %3d/280", inputSize));
        });
    }
}