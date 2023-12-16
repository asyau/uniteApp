package mainpack.deneme;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class EntryItemController implements Initializable {

    @FXML
    private Label entryName;
    @FXML
    private Label entryText;
    @FXML
    private ImageView entryImage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setData(Question q) {
        entryText.setText(q.getInfo());
        entryName.setText(q.getOwner().getName());
    }
}
