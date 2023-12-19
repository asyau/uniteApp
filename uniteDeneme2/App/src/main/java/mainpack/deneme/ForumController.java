package mainpack.deneme;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.TimeZone;

import javafx.scene.Parent;

public class ForumController implements Initializable {
    private Forum forum;
    @FXML
    private Button backButton;
    @FXML
    private Button qButton;
    @FXML
    private VBox forumBox;
    @FXML
    private Button allqButton;
    @FXML
    private Button tpButton;
    @FXML
    private Button rmButton;
    @FXML
    private Button lfButton;
    @FXML
    private Button oButton;
    @FXML
    private Button yourqButton;
    @FXML
    private Button youraButton;
    @FXML
    private TextField filterField;
    @FXML
    public void onBackButtonClick() {
        try {
            Stage stage = (Stage) backButton.getScene().getWindow();
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
    @FXML
    public void onAskAQClick() {
        try {
            Stage stage = (Stage) qButton.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/askaqview.fxml"));
            primaryStage.setTitle("Forum");
            primaryStage.setScene(new Scene(root,900,600));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Question.count = 0;
        DBController dbc = new DBController();
        Authenticator.saveUsers();
        forum = new Forum(dbc.createQuestionArr());
        Authenticator.currentUser = Authenticator.users.get(3);


        showAllQuestions();

        allqButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showAllQuestions();
            }
        });
        tpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                sort(1);
            }
        });
        rmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                sort(2);
            }
        });
        lfButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                sort(3);
            }
        });
        oButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                sort(1);
            }
        });
        yourqButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                forumBox.getChildren().clear();
                for (Question q : forum.getQuestions()) {
                    if (q.getOwner() == Authenticator.currentUser){
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/entry.fxml"));
                        try {
                            HBox hbox = loader.load();
                            EntryItemController eic = loader.getController();
                            eic.setData(q);
                            forumBox.getChildren().add(hbox);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
        youraButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                forumBox.getChildren().clear();
                ArrayList<Question> qs = new ArrayList<>();
                for(Reply r : Forum.getReplies()) {
                    if (r.getOwner().equals(Authenticator.currentUser) && !qs.contains(r.getQuestion()))
                        qs.add(r.getQuestion());
                }
                for (Question q : qs) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/entry.fxml"));
                    try {
                        HBox hbox = loader.load();
                        EntryItemController eic = loader.getController();
                        eic.setData(q);
                        forumBox.getChildren().add(hbox);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filter(newValue);
        });

    }


    public void showAllQuestions(){
        forumBox.getChildren().clear();
        for (Question q : forum.getQuestions()) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/entry.fxml"));
            try {
                HBox hbox = loader.load();
                EntryItemController eic = loader.getController();
                eic.setData(q);
                forumBox.getChildren().add(hbox);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void sort(int tag) {
        forumBox.getChildren().clear();
        for (Question q : forum.getQuestions()) {
            if (q.getTag() == tag){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/entry.fxml"));
                try {
                    HBox hbox = loader.load();
                    EntryItemController eic = loader.getController();
                    eic.setData(q);
                    forumBox.getChildren().add(hbox);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public void filter(String input) {
        forumBox.getChildren().clear();
        for (Question q : forum.getQuestions()) {
            if (q.getInfo().toLowerCase().contains(input.toLowerCase()) ||
            q.getOwner().getName().toLowerCase().contains(input.toLowerCase())) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/entry.fxml"));
                try {
                    HBox hbox = loader.load();
                    EntryItemController eic = loader.getController();
                    eic.setData(q);
                    forumBox.getChildren().add(hbox);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}