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
import java.util.TimeZone;

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
        ArrayList<Announcement> anns = new ArrayList<Announcement>();
        fillEventsList(anns);
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
    private void fillEventsList(ArrayList<Announcement> input){
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
        // Archaeology Club's Event
        cal.set(Calendar.DAY_OF_MONTH, 15);
        cal.set(Calendar.MONTH, 11); // December is the 12th month, so we use 11 as months in Calendar are 0-based
        Announcement a3 = new Announcement(cal, "Archaeology Club", "Meeting on International Archaeology Students Conference", "İİSBF/FEASS - C Block Amphi");
        input.add(a3);

        // Historical Society's Event
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.DAY_OF_MONTH, 16);
        cal1.set(Calendar.MONTH, 11);
        Announcement a4 = new Announcement(cal1, "Historical Society", "Romans in the East, Roman Religion and Unbecoming Roman", "SBF/FEASS C Block Amphi");
        input.add(a4);

        // Think Colorfully Club's Event
        cal.set(Calendar.DAY_OF_MONTH, 19);
        cal.set(Calendar.MONTH, 11);
        Announcement a5 = new Announcement(cal, "Think Colorfully Club", "Queer Awards 2023", "GSMF/FADA FFB 22");
        input.add(a5);

        // Beyblade Club's Event
        cal.set(Calendar.DAY_OF_MONTH, 20);
        cal.set(Calendar.MONTH, 11);
        Announcement a6 = new Announcement(cal, "Beyblade Club", "Second Traditional Beyblade Activity", "MAN V2 Amphi");
        input.add(a6);

        // Bilkent Gazette Society's Event
        cal.set(Calendar.DAY_OF_MONTH, 21);
        cal.set(Calendar.MONTH, 11);
        Announcement a7 = new Announcement(cal, "Bilkent Gazette Society", "Women who Challenge Archetypes in Literature", "HF/FL B Building B 113");
        input.add(a7);

        // Management and Economics Society's Event
        cal.set(Calendar.DAY_OF_MONTH, 22);
        cal.set(Calendar.MONTH, 11);
        Announcement a8 = new Announcement(cal, "Management and Economics Society", "Weekly Club Meeting", "SBF/FEASS B Building BZ 06, BZ 07");
        input.add(a8);
// Theater Club's Event
        cal.set(Calendar.DAY_OF_MONTH, 27);
        cal.set(Calendar.MONTH, 11); // Month is December, 0-based index in Java Calendar is 11
        Announcement a9 = new Announcement(cal, "Theater Club", "Improvisation Exercise", "SBF/FEASS C Block Amphi");
        input.add(a9);

// Outdoor Sports Society's Event
        cal.set(Calendar.DAY_OF_MONTH, 28);
        cal.set(Calendar.MONTH, 11); // Month is December
        Announcement a10 = new Announcement(cal, "Outdoor Sports Society", "Long Climbing Wall Training", "Bilkent Long Climbing Wall");
        input.add(a10);

// Historical Society Seminar Event
        cal.set(Calendar.DAY_OF_MONTH, 30);
        cal.set(Calendar.MONTH, 11); // Month is December
        Announcement a11 = new Announcement(cal, "Historical Society", "Romans in the East, Roman Religion and Unbecoming Roman", "SBF/FEASS C Block Amphi");
        input.add(a11);

// Young Leaders Club's Event
        cal.set(Calendar.DAY_OF_MONTH, 5);
        cal.set(Calendar.MONTH, 12); // Month is December
        Announcement a12 = new Announcement(cal, "Young Leaders Club", "Case Study", "GSTMF/FADA FFB 06");
        input.add(a12);

// Musical Society's Rehearsal
        cal.set(Calendar.DAY_OF_MONTH, 7);
        cal.set(Calendar.MONTH, 0); // Month is December
        Announcement a13 = new Announcement(cal, "Musical Society", "Rehearsal", "U Building Old Cafe");
        input.add(a13);

// Theater Club's Second Event
        cal.set(Calendar.DAY_OF_MONTH, 11);
        cal.set(Calendar.MONTH, 0); // Month is December
        Announcement a14 = new Announcement(cal, "Theater Club", "Improvisation Exercise", "SBF/FEASS C Block Amphi");
        input.add(a14);

// Outdoor Sports Society's Training Program
        cal.set(Calendar.DAY_OF_MONTH, 13);
        cal.set(Calendar.MONTH, 0); // Month is December
        Announcement a15 = new Announcement(cal, "Outdoor Sports Society", "Training Program", "Bilkent DOST Long Climbing Wall Training Bilkent Long Climbing Wall");
        input.add(a15);

// QSB Bilkent Student Branch & Physics Society's Movie Screening & Discussion
        cal.set(Calendar.DAY_OF_MONTH, 18);
        cal.set(Calendar.MONTH, 0); // Month is December
        Announcement a16 = new Announcement(cal, "QSB Bilkent Student Branch & Physics Society", "Movie Screening & Discussion: Quantum Computing with Michio Kaku", "HF/FL V2 Amphi");
        input.add(a16);

// Outdoor Sports Society's Training Program
        cal.set(Calendar.DAY_OF_MONTH, 20);
        cal.set(Calendar.MONTH, 0); // Month is December
        Announcement a17 = new Announcement(cal, "Outdoor Sports Society", "Training Program", "Bilkent DOST Long Climbing Wall Training Bilkent Long Climbing Wall");
        input.add(a17);

// Debate Society's Club Meeting & Practice Match
        cal.set(Calendar.DAY_OF_MONTH, 21);
        cal.set(Calendar.MONTH, 0); // Month is December
        Announcement a18 = new Announcement(cal, "Debate Society", "Club Meeting & Debate Practice Match", "MF/FE B Building B 102");
        input.add(a18);

// Bilkent Gazette Society's Conference
        cal.set(Calendar.DAY_OF_MONTH, 13);
        cal.set(Calendar.MONTH, 0); // Month is December
        Announcement a19 = new Announcement(cal, "Bilkent Gazette Society", "Conference: Women who Challenge Archetypes in Literature, Guest Speaker: Funda Bilgen, Instructor", "HF/FL B Building B 113");
        input.add(a19);

// Management and Economics Society's Club Meeting
        cal.set(Calendar.DAY_OF_MONTH, 25);
        cal.set(Calendar.MONTH, 0); // Month is December
        Announcement a20 = new Announcement(cal, "Management and Economics Society", "Club Meeting: Weekly Club Meeting SBF/FEASS B Building BZ 06, BZ 07", "SBF/FEASS B Building");
        input.add(a20);

// Young Entrepreneurs Society's Club Meeting
        cal.set(Calendar.DAY_OF_MONTH, 26);
        cal.set(Calendar.MONTH, 0); // Month is January
        Announcement a21 = new Announcement(cal, "Young Entrepreneurs Society", "Club Meeting", "EN Business Talks Amsterdam '24, 2nd Day Amsterdam, Holland");
        input.add(a21);

// Model United Nations Society's Conference
        cal.set(Calendar.DAY_OF_MONTH, 10);
        cal.set(Calendar.MONTH, 11); // Month is January
        cal.set(Calendar.YEAR, 2023);
        Announcement a22 = new Announcement(cal, "Model United Nations Society", "Conference MUNBU'24", "MSSF/FMPA Concert Hall, MAZ02, MAZ03, MAZ04, MAZ05, AZ25, AZ27, MA101, MA103, MA104, MA105, MA201, MA202, MA206, MA301, MA302, V01, V02, V03, V04");
        input.add(a22);

// Musical Society's Rehearsal
        cal.set(Calendar.DAY_OF_MONTH, 9);
        cal.set(Calendar.MONTH, 11); // Month is January
        Announcement a23 = new Announcement(cal, "Musical Society", "Rehearsal", "Mirage Studio, Çankaya Ankara");
        input.add(a23);

// Atelier Bilkent Society & Botanical Society's Activity
        cal.set(Calendar.DAY_OF_MONTH, 5);
        cal.set(Calendar.MONTH, 11); // Month is December
        Announcement a24 = new Announcement(cal, "Atelier Bilkent Society & Botanical Society", "New Years & Christmas Pinecone Decoration Workshop", "U Building Old Cafe");
        input.add(a24);

// Musical Society's Rehearsal
        cal.set(Calendar.DAY_OF_MONTH, 23);
        cal.set(Calendar.MONTH, 11); // Month is December
        Announcement a25 = new Announcement(cal, "Musical Society", "Rehearsal", "MSSF/FMPA Room 215");
        input.add(a25);

// Science Fiction and Fantasy Society's Club Meeting
        cal.set(Calendar.DAY_OF_MONTH, 27);
        cal.set(Calendar.MONTH, 11); // Month is December
        Announcement a26 = new Announcement(cal, "Science Fiction and Fantasy Society", "Club Meeting", "One Shot Night Main Campus U Building Clubs and Societies Activity Hall");
        input.add(a26);
    }



}