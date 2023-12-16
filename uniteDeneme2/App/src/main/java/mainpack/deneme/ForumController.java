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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.TimeZone;

import javafx.scene.Parent;

public class ForumController implements Initializable {
    @FXML
    private Button backButton;
    @FXML
    private Button qButton;
    @FXML
    private VBox forumBox;
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
        User u1 = new User("kv@ug.bilkent.edu.tr", "1234567", "Kerem Varnalı");
        User u2 = new User("aa@ug.bilkent.edu.tr", "1234567", "Atakan Akar");
        User u3 = new User("ba@ug.bilkent.edu.tr", "1234567", "Bilgehan Akın");
        User u4 = new User("aü@ug.bilkent.edu.tr", "1234567", "Asya Ünal");
        User u5 = new User("eu@ug.bilkent.edu.tr", "1234567", "Erdem Uğurlu");
        Calendar cal1 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
        Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
        cal2.add(Calendar.DATE, -1);
        Question q1 = new Question("","Bilkent 3'te ev arıyorum", 1, cal1, null, u1);
        Question q2 = new Question("","Havalimanına yarın 14:30da gidicem", 2, cal2, null, u2);
        Question q3 = new Question("","Adamlar konserine 2 biletim var", 3, cal1, null, u3);
        Question q4 = new Question("","BASYS3 kartı satan var mı?", 1, cal2, null, u4);
        Question q5 = new Question("","Okeye gidiyorum 4. aranıyor", 1, cal1, null, u5);
        ArrayList<Question> qs = new ArrayList<>();
        qs.add(q1);
        qs.add(q2);
        qs.add(q3);
        qs.add(q4);
        qs.add(q5);


        for (int i = 0; i < qs.size(); i++) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/entry.fxml"));
            try {
                HBox hbox = loader.load();
                EntryItemController eic = loader.getController();
                eic.setData(qs.get(i));
                forumBox.getChildren().add(hbox);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}