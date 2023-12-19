package mainpack.deneme;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ResponseItemController {

    @FXML
    private Label userNameResponse;
    @FXML
    private Label textResponse;
    @FXML
    private Label timePassed;

    public void setData(Reply r) {
        userNameResponse.setText(r.getOwner().getName());
        textResponse.setText(r.getContent());
        timePassed.setText(r.getTimePassed());
    }
}
