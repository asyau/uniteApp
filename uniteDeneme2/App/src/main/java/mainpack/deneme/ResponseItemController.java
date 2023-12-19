package mainpack.deneme;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ResponseItemController {

    @FXML
    private Label userNameResponse;
    @FXML
    private Label textResponse;
    @FXML
    private Label timePassed;
    @FXML
    private ImageView userPhoto;

    public void setData(Reply r) {
        DBController dbc = new DBController();
        userNameResponse.setText(r.getOwner().getName());
        textResponse.setText(r.getContent());
        timePassed.setText(r.getTimePassed());
        userPhoto.setImage(new Image(dbc.getProfilUrl(r.getOwner())));
    }
}
