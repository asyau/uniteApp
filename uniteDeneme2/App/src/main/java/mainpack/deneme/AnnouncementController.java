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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

public class AnnouncementController implements Initializable {
    @FXML
    private Label dateLabel;
    @FXML
    private Button weekBackButton;
    @FXML
    private Button weekForwardButton;
    @FXML
    private Label welcomeText;
    @FXML
    private Button backButton;
    @FXML
    private VBox announcementBox;
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

    private AnnouncementHolder annh;
    private String dateText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.DAY_OF_MONTH, 20);
        c1.set(Calendar.MONTH, 11);
        Announcement a1 = new Announcement(c1, "Yes", "Ankara Start-up Zirvesi", "Ea 203");
        Announcement a2 = new Announcement(c1, "Or", "Zıddıbık etkinliği", "Bz 08");
        ArrayList<Announcement> anns = new ArrayList<Announcement>();
        anns.add(a1);
        anns.add(a2);
        annh = new AnnouncementHolder(anns);
        showEvents();
        setText();
        weekBackButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                annh.weekBackward();
                showEvents();
                setText();
            }
        });
        weekForwardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                annh.weekForward();
                showEvents();
                setText();
            }
        });
    }

    private void setText() {
        dateText = String.format("%s - %s", annh.minString, annh.maxString);
        dateLabel.setText(dateText);
    }
    public void showEvents(){
        announcementBox.getChildren().clear();
        for (Announcement a : annh.filter()) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/event.fxml"));
            try {
                HBox hbox = loader.load();
                EventItemController eic = loader.getController();
                eic.setData(a);
                announcementBox.getChildren().add(hbox);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }



}