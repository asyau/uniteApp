package mainpack.deneme;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

public class EventItemController implements Initializable{
    @FXML
    private Label hourOfEvent;
    @FXML
    private Label nameOfEvent;
    @FXML
    private Label placeOfEvent;
    @FXML
    private Label eventClub;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void setData(Announcement a) {
        hourOfEvent.setText(calToString(a.getTime()));
        nameOfEvent.setText(a.getEventInformation());
        placeOfEvent.setText(a.getPlace());
        eventClub.setText(a.getOrganizer());
    }
    private String calToString(Calendar cal) {
        String result = "";
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR) % 100;

        if (day / 10 == 0) {
            result += "0"+day+"/";
        }
        else {
            result += day+"/";
        }
        if (month / 10 == 0) {
            result += "0"+month+"/";
        }
        else {
            result += month+"/";
        }
        result += year;

        return result;
    }
}
